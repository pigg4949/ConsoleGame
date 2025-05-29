package game;

import java.util.Scanner;

public class GameManager {

    private Scanner scanner = new Scanner(System.in);
    private String playerName;
    private String gender;
    private int affection = 0;

    public void run() {
        inputGender();
        inputName();

        if (checkPreviousProgress()) {
            if (!askToSkip()) {
                runStage1();
            }
        } else {
            runStage1();
        }

        if (!checkStagePass(Stage1.getPassScore(), 1)) return;
        if (!askToContinue()) return;

        runStage2();
        if (!checkStagePass(Stage2.getPassScore(), 2)) return;
        if (!askToContinue()) return;

        runStage3();
        if (!checkStagePass(Stage3.getPassScore(), 3)) return;

        showSuccessEnding();
        showRanking();
    }

    private void inputGender() {
        while (true) {
            System.out.print("성별을 선택하세요 (1: 남, 2: 여): ");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                gender = "남";
                break;
            } else if (input.equals("2")) {
                gender = "여";
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void inputName() {
        while (true) {
            System.out.print("이름을 입력하세요: ");
            String input = scanner.nextLine();
            if (input.matches("^[가-힣a-zA-Z]{2,10}$")) {
                playerName = input;
                break;
            } else {
                System.out.println("이름은 한글 또는 영문 2~10자여야 합니다.");
            }
        }
    }

    private boolean checkPreviousProgress() {
        // DBHandler.checkProgress(playerName, gender)
        return false;
    }

    private boolean askToSkip() {
        System.out.print("이전에 진행한 기록이 있습니다. 스킵하시겠습니까? (Y/N): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    private boolean askToContinue() {
        System.out.print("다음 스테이지로 진행하시겠습니까? (Y/N): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    private void runStage1() {
        Stage1 stage = new Stage1(playerName, gender, scanner);
        affection = stage.play(affection);
    }

    private void runStage2() {
        Stage2 stage = new Stage2(playerName, gender, scanner);
        affection = stage.play(affection);
    }

    private void runStage3() {
        Stage3 stage = new Stage3(playerName, gender, scanner);
        affection = stage.play(affection);
    }

    private boolean checkStagePass(int passScore, int stageNumber) {
        if (affection < passScore) {
            EndingManager.showFailureEnding(stageNumber, playerName, gender);
            return false;
        }
        return true;
    }

    private void showSuccessEnding() {
        EndingManager.showSuccessEnding(playerName, gender, affection);
    }

    private void showRanking() {
        RankingManager.showRanking();
    }
}