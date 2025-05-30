package game;

import game.gwang.Player;

import java.util.Scanner;

public class GameManager {
    private Player player;
    Scanner scanner = new Scanner(System.in);

    public void run() {
        player = Player.inputPlayer(); // 생성

        if (checkPreviousProgress()) {
            if (!askToSkip()) {
                runStage1();
            }
        } else {
            runStage1();
        }

        runStage2();

        runStage3();

        showRanking();
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

    private void runStage1() {
        Stage1 stage = new Stage1(player);
        stage.start();
    }

    private void runStage2() {
        Stage2 stage2 = new Stage2(player);
        stage2.stage2;
    }

    private void runStage3() {
        Stage3 stage = new Stage3(player);
        stage.start;
    }

    private void showRanking() {
        RankingManager.showRanking();
    }
}