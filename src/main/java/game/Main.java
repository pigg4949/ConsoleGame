package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) 이름 입력
        String name;
        while (true) {
            System.out.print("이름을 입력하세요(2~10자 한글/영문): ");
            name = sc.nextLine();
            if (name.matches("^[가-힣a-zA-Z]{2,10}$")) {
                break;
            }
            System.out.println("이름은 한글 또는 영문 2~10자여야 합니다.");
        }

        // 2) 성별 입력
        String gender;
        while (true) {
            System.out.print("성별을 선택하세요 (1: 남자, 2: 여자): ");
            String sel = sc.nextLine();
            if (sel.equals("1")) {
                gender = "남";
                break;
            } else if (sel.equals("2")) {
                gender = "여";
                break;
            }
            System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
        }

        // 3) Player 생성
        Player player = new Player(name, gender);

        // 4) Stage1 실행
        Stage1 stage1 = new Stage1(player, sc);
        Stage1.Result result1 = stage1.play();
        // result1.partnerName, result1.affection 반영
        player.setAffection(result1.affection);
        String partnerName = result1.partnerName;

        if (player.getAffection() < 20) {
            System.out.println("\n[GAME OVER] Stage1에서 실패했습니다.");
            sc.close();
            return;
        }

        // 5) Stage2 실행
        Stage2 stage2 = new Stage2(player, sc, partnerName);
        stage2.play();
        if (player.getAffection() < 40) {
            System.out.println("\n[GAME OVER] Stage2에서 실패했습니다.");
            sc.close();
            return;
        }

        // 6) Stage3 실행
        Stage3 stage3 = new Stage3(player, sc, partnerName);
        stage3.play();

        sc.close();
    }
}
