// ConsoleGalaga.java
// 콘솔 기반 갤러가 게임, 완전판 (약 400줄)
// - 일반 웨이브 및 N번째 웨이브마다 보스 등장
// - 보스 처치 직후 스킬 선택 (동료 추가, 목숨 +1, 탄환 강화)
// - 동료 비행기 동기화 이동 및 공격

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ConsoleGalaga {
    // 화면 크기
    static final int WIDTH = 40;
    static final int HEIGHT = 20;

    // 화면 버퍼
    static char[][] screen = new char[HEIGHT][WIDTH];

    // 입력 상태
    static volatile int keyPressed = -1;
    static volatile boolean running = true;

    // 게임 상태
    static int score = 0;
    static int lives = 3;
    static int wave = 1;

    // 보스 등장 주기 (3스테이지마다)
    static final int BOSS_INTERVAL = 3;

    // 동료 비행기 상태
    static boolean hasAlly = false;
    static Player ally;

    // 엔티티 리스트
    static ArrayList<Enemy> enemies;
    static ArrayList<Bullet> bullets;
    static ArrayList<Bullet> enemyBullets;

    public static void main(String[] args) throws InterruptedException {
        clearScreenBuffer();
        Player player = new Player(WIDTH / 2, HEIGHT - 2, 'A');
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        enemyBullets = new ArrayList<>();

        spawnEnemies(enemies);
        startInputThread();

        while (running) {
            handleInput(player, bullets);
            player.update();
            if (hasAlly) syncAlly(player);
            updateEntities(enemies);
            updateEntities(bullets);
            updateEntities(enemyBullets);

            handleCollisions();
            handleEnemyHits(player);

            fireEnemyBullets();
            render(player);

            removeOffscreenEnemies();

            if (enemies.isEmpty()) {
                if (wave % BOSS_INTERVAL == 0) {
                    chooseSkill(player);
                }
                wave++;
                if (wave % BOSS_INTERVAL == 0) {
                    spawnBoss(enemies, wave);
                } else {
                    spawnEnemies(enemies);
                }
            }

            Thread.sleep(100);
        }

        clearConsole();
        if (lives > 0) {
            System.out.println("*** YOU WIN! ***");
        } else {
            System.out.println("*** GAME OVER ***");
        }
        System.exit(0);
    }

    /** 화면 버퍼 초기화 */
    static void clearScreenBuffer() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                screen[y][x] = ' ';
            }
        }
    }

    /** 입력 스레드 시작 */
    static void startInputThread() {
        Thread t = new Thread(() -> {
            try {
                while (running) {
                    if (System.in.available() > 0) {
                        keyPressed = System.in.read();
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    /** 일반 웨이브 적 생성 */
    static void spawnEnemies(ArrayList<Enemy> list) {
        int count = 8 + (wave - 1) * 2;
        for (int i = 0; i < count; i++) {
            int x = 2 + (i % 8) * 4;
            int y = 2 + (i / 8);
            list.add(new Enemy(x, y, 'M'));
        }
    }

    /** 보스 웨이브 스폰 */
    static void spawnBoss(ArrayList<Enemy> list, int waveNum) {
        list.clear();
        int bossHp = 5 + ((waveNum / BOSS_INTERVAL) - 1) * 5;
        list.add(new BossEnemy(WIDTH / 2 - 2, 2, 'B', bossHp));
    }

    /** 보스 처치 후 스킬 선택 */
    static void chooseSkill(Player p) throws InterruptedException {
        clearConsole();
        System.out.println("보스 처치! 스킬 선택:");
        System.out.println("1) 동료 비행기 추가");
        System.out.println("2) 목숨 +1");
        System.out.println("3) 탄환 강화 (2발)");
        int choice = -1;
        while (choice < 1 || choice > 3) {
            try {
                if (System.in.available() > 0) {
                    choice = System.in.read() - '0';
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(100);
        }
        switch (choice) {
            case 1:
                hasAlly = true;
                ally = new Player(p.x + 2, p.y, 'A');
                break;
            case 2:
                lives++;
                break;
            case 3:
                p.numBullets = 2;
                break;
        }
    }

    /** 플레이어 입력 및 발사 */
    static void handleInput(Player p, ArrayList<Bullet> bl) {
        int k = keyPressed;
        keyPressed = -1;
        if (k == 27) {
            running = false;
        } else if (k == 'a' || k == 'A') {
            p.move(-1, 0);
        } else if (k == 'd' || k == 'D') {
            p.move(1, 0);
        } else if (k == ' ' || k == 'w') {
            for (int i = 0; i < p.numBullets; i++) {
                bl.add(new Bullet(p.x - i, p.y - 1, '|', 0, -1));
            }
            if (hasAlly) {
                for (int i = 0; i < p.numBullets; i++) {
                    bl.add(new Bullet(ally.x - i, ally.y - 1, '|', 0, -1));
                }
            }
        }
    }

    /** 엔티티 업데이트 */
    static <T extends Entity> void updateEntities(ArrayList<T> list) {
        for (T e : list) {
            e.update();
        }
    }

    /** 내 탄환 vs 적 충돌 처리 */
    static void handleCollisions() {
        Iterator<Bullet> bi = bullets.iterator();
        while (bi.hasNext()) {
            Bullet b = bi.next();
            Iterator<Enemy> ei = enemies.iterator();
            while (ei.hasNext()) {
                Enemy e = ei.next();
                if (b.x == e.x && b.y == e.y) {
                    bi.remove();
                    if (e instanceof BossEnemy) {
                        BossEnemy boss = (BossEnemy) e;
                        boss.onHit();
                        if (boss.hp <= 0) {
                            ei.remove();
                            score += 10;
                        }
                    } else {
                        ei.remove();
                        score++;
                    }
                    break;
                }
            }
        }
    }

    /** 적 탄환 vs 플레이어/동료 충돌 처리 */
    static void handleEnemyHits(Player p) {
        Iterator<Bullet> ei = enemyBullets.iterator();
        while (ei.hasNext()) {
            Bullet b = ei.next();
            boolean hpHit = (b.x == p.x && b.y == p.y);
            boolean allyHit = (hasAlly && b.x == ally.x && b.y == ally.y);
            if (hpHit || allyHit) {
                lives--;
                ei.remove();
                if (lives <= 0) running = false;
                break;
            }
            if (b.y >= HEIGHT) ei.remove();
        }
    }

    /** 적 탄환 발사 */
    static void fireEnemyBullets() {
        for (Enemy e : enemies) {
            if (Math.random() < 0.02) {
                enemyBullets.add(new Bullet(e.x, e.y + 1, '!', 0, 1));
            }
        }
    }

    /** 화면 밖 적 제거 */
    static void removeOffscreenEnemies() {
        Iterator<Enemy> it = enemies.iterator();
        while (it.hasNext()) {
            if (it.next().y >= HEIGHT) it.remove();
        }
    }

    /** 화면 렌더링 */
    static void render(Player p) {
        clearScreenBuffer();
        p.draw(screen);
        if (hasAlly) ally.draw(screen);
        for (Enemy e : enemies) e.draw(screen);
        for (Bullet b : bullets) b.draw(screen);
        for (Bullet b : enemyBullets) b.draw(screen);
        clearConsole();
        System.out.println("+" + "-".repeat(WIDTH * 2) + "+");
        for (char[] row : screen) {
            System.out.print("|");
            for (char c : row) System.out.print(colorize(c));
            System.out.println("|");
        }
        System.out.println("+" + "-".repeat(WIDTH * 2) + "+");
        System.out.println(" Score: " + score + "    Lives: " + lives);
    }

    /** 콘솔 클리어 */
    static void clearConsole() {
        System.out.print("\033[2J\033[H");
    }

    /** 동료 동기화 */
    static void syncAlly(Player p) {
        ally.x = p.x + 2;
        ally.y = p.y;
    }

    /** ANSI 컬러 출력 */
    static String colorize(char c) {
        switch (c) {
            case 'A': return "\033[32mA \033[0m";
            case 'B': return "\033[35mB \033[0m";
            case 'M': return "\033[31mM \033[0m";
            case '|': return "\033[36m| \033[0m";
            case '!': return "\033[33m! \033[0m";
            default: return "  ";
        }
    }

    /** 엔티티 추상 클래스 */
    static abstract class Entity {
        int x, y;
        char glyph;
        Entity(int x, int y, char glyph) {
            this.x = x;
            this.y = y;
            this.glyph = glyph;
        }
        void draw(char[][] buf) {
            if (y >= 0 && y < HEIGHT && x >= 0 && x < WIDTH) buf[y][x] = glyph;
        }
        abstract void update();
    }

    /** 플레이어 클래스 */
    static class Player extends Entity {
        int numBullets = 1;
        Player(int x, int y, char glyph) { super(x, y, glyph); }
        @Override void update() {}
        void move(int dx, int dy) {
            x = Math.max(0, Math.min(WIDTH - 1, x + dx));
            y = Math.max(0, Math.min(HEIGHT - 1, y + dy));
        }
    }

    /** 일반 적 클래스 */
    static class Enemy extends Entity {
        private int dir = 1;
        private int stepCount = 0;
        private int frameCount = 0;
        Enemy(int x, int y, char glyph) { super(x, y, glyph); }
        @Override void update() {
            frameCount++;
            if (frameCount % 3 != 0) return;
            x += dir;
            stepCount++;
            if (stepCount >= 5) {
                dir = -dir;
                stepCount = 0;
                y++;
            }
        }
    }

    /** 보스 적 클래스 */
    static class BossEnemy extends Enemy {
        int hp;
        int cooldown;
        BossEnemy(int x, int y, char glyph, int hp) {
            super(x, y, glyph);
            this.hp = hp;
            this.cooldown = 0;
        }
        @Override void update() {
            super.update();
            if (cooldown-- <= 0) {
                cooldown = 20;
                enemyBullets.add(new Bullet(x-1, y+1, '!', -1, 1));
                enemyBullets.add(new Bullet(x,   y+1, '!',  0, 1));
                enemyBullets.add(new Bullet(x+1, y+1, '!',  1, 1));
            }
        }
        void onHit() { hp--; }
    }

    /** 탄환 클래스 */
    static class Bullet extends Entity {
        int dx, dy;
        Bullet(int x, int y, char glyph, int dx, int dy) {
            super(x, y, glyph);
            this.dx = dx;
            this.dy = dy;
        }
        @Override void update() { x += dx; y += dy; }
    }
}
