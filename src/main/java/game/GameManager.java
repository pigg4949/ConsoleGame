package game;

import java.util.Scanner;

public class GameManager {
    private Player player;
    Scanner scanner = new Scanner(System.in);
    private DBHandler db = new DBHandler();

    public void run() {
        db.connect();
        player = Player.inputPlayer(); // 생성

        if (db.checkProgress(player.getPlayerName(), player.getGender())) {
            if(askToSkip()){
                player = db.findByPlayerName(player.getPlayerName(), player.getGender());
                System.out.println(player.toString());
                switch (player.getClearStage()) {
                    case 0: runStage1();
                    case 1: runStage2();
                    case 2: runStage3(); db.showRanking(player.getPartnerName());break;
                    case 3: runStage3(); db.showRanking(player.getPartnerName());break;
                }
            }else {runStage1();}
        }else{

            runStage1();

            runStage2();

            runStage3();}

        db.showRanking(player.getPartnerName());

    }

    private boolean askToSkip() {
        boolean resultChk = false;
        boolean askResult = false;

        while (!resultChk) {
            System.out.print("이전에 진행한 기록이 있습니다. 이어하시겠습니까? (Y/N): ");
            String input = scanner.nextLine();
            if (!("Y".equals(input) || "N".equals(input))) {
                System.out.println("잘못된 입력값입니다. Y 또는 N 을 입력해주세요.");
            }
            else if ("Y".equals(input)) {
                System.out.println( "이어서 시작하겠습니다.");
                resultChk = true;
                askResult = true;
            }
            else if ("N".equals(input)) {
                resultChk = true;
                askResult = false;
            }
        }
        return askResult;
    }

    private void runStage1() {
        Stage1 stage = new Stage1(player);
        player = stage.play();
    }

    private void runStage2() {
        Stage2 stage2 = new Stage2(player);
        player = stage2.play();
    }

    private void runStage3() {
        Stage3 stage = new Stage3(player);
        stage.play();
    }

    public int getInput(int min, int max) {
        while (true) {
            System.out.printf("선택(%d~%d): ", min, max);
            int n = scanner.nextInt();
            if (n >= min && n <= max){
                return n;
            }
            else{
                System.out.println("잘못된 입력입니다. 다시 선택하세요.3");
            }
        }
    }
}