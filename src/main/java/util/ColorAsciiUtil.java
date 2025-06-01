package util;

import com.googlecode.lanterna.TextColor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static com.googlecode.lanterna.gui2.Interactable.FocusChangeDirection.RESET;

// 리소스 작명 규칙
// 첫 대문자는 npc 성별, 즉 플레이어 성별과는 반대.
// 1~3은 스테이지별 기본 이미지
// 0은 돌발상황 이미지
// 01은 엔딩 분기 이미지

public class ColorAsciiUtil {
        public static final String RESET = "\u001B[0m";
        private static final String WHITE = "\u001B[97m";

        private static final String[] RAINBOW = {
                "\u001B[31m", // 빨강
                "\u001B[33m", // 주황
                "\u001B[32m", // 초록
                "\u001B[36m", // 하늘
                "\u001B[34m", // 파랑
                "\u001B[35m", // 보라
                "\u001B[95m"  // 연보라
        };

        // 게임 오버: 흰색 출력
        public static void printGameOver() {
            for (String line : gameOverAscii) {
                System.out.println(WHITE + line + RESET);
            }
        }

        // 스테이지 클리어: 무지개 출력
        public static void printStageClear() {
            int colorIndex = 0;
            for (String line : stageClearAscii) {
                String color = RAINBOW[colorIndex % RAINBOW.length];
                System.out.println(color + line + RESET);
                colorIndex++;
            }
        }

        public static class TextColorUtil {
            public static String colorizeChar(char c, TextColor color) {
                return "\u001B[38;2;" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m" + c + "\u001B[0m";
            }

            public static void printFromResource(String resourcePath, Map<Character, TextColor> colorMap) {
                try (InputStream is = ColorAsciiUtil.class.getResourceAsStream(resourcePath);
                     InputStreamReader isr = new InputStreamReader(Objects.requireNonNull(is));
                     BufferedReader reader = new BufferedReader(isr)) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        for (char c : line.toCharArray()) {
                            TextColor color = colorMap.getOrDefault(c, TextColor.ANSI.DEFAULT);
                            System.out.print(TextColorUtil.colorizeChar(c, color)); // 아래에서 정의
                        }
                        System.out.println();
                    }
                } catch (IOException | NullPointerException e) {
                    System.err.println("아스키 리소스 출력 실패: " + resourcePath);
                }
            }
        }


    static List<String> gameOverAscii = Arrays.asList(
            "\n",
            " ______  ______  ______  ______  ______  ______  ______  ______  ______ \n" +
                    "| |__| || |__| || |__| || |__| || |__| || |__| || |__| || |__| || |__| |\n" +
                    "|  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  |\n" +
                    "|______||______||______||______||______||______||______||______||______|\n" +
                    " ______                                                          ______ \n" +
                    "| |__| |    ________  ________  _____ ______   _______          | |__| |\n" +
                    "|  ()  |   |\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\         |  ()  |\n" +
                    "|______|   \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|        |______|\n" +
                    " ______     \\ \\  \\  __\\ \\   __  \\ \\  \\\\|__| \\  \\ \\  \\_|/__       ______ \n" +
                    "| |__| |     \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\     | |__| |\n" +
                    "|  ()  |      \\ \\_______\\ \\__\\ \\__\\ \\__\\    \\ \\__\\ \\_______\\    |  ()  |\n" +
                    "|______|       \\|_______|\\|__|\\|__|\\|__|     \\|__|\\|_______|    |______|\n" +
                    " ______                                                          ______ \n" +
                    "| |__| |                                                        | |__| |\n" +
                    "|  ()  |                                                        |  ()  |\n" +
                    "|______|    ________  ___      ___ _______   ________           |______|\n" +
                    " ______    |\\   __  \\|\\  \\    /  /|\\  ___ \\ |\\   __  \\           ______ \n" +
                    "| |__| |   \\ \\  \\|\\  \\ \\  \\  /  / | \\   __/|\\ \\  \\|\\  \\         | |__| |\n" +
                    "|  ()  |    \\ \\  \\\\\\  \\ \\  \\/  / / \\ \\  \\_|/_\\ \\   _  _\\        |  ()  |\n" +
                    "|______|     \\ \\  \\\\\\  \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\\\  \\|       |______|\n" +
                    " ______       \\ \\_______\\ \\__/ /     \\ \\_______\\ \\__\\\\ _\\        ______ \n" +
                    "| |__| |       \\|_______|\\|__|/       \\|_______|\\|__|\\|__|      | |__| |\n" +
                    "|  ()  |                                                        |  ()  |\n" +
                    "|______|                                                        |______|\n" +
                    " ______  ______  ______  ______  ______  ______  ______  ______  ______ \n" +
                    "| |__| || |__| || |__| || |__| || |__| || |__| || |__| || |__| || |__| |\n" +
                    "|  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  ||  ()  |\n" +
                    "|______||______||______||______||______||______||______||______||______|",
            "\n"
    );

    static List<String> stageClearAscii = Arrays.asList(
            "\n",
            " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n",
                    "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n",
                    " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < \n",
                    " /\\_/\\       _______.___________.    ___       _______  _______      ______  __       _______     ___      .______       __    /\\_/\\ \n",
                    "( o.o )     /       |           |   /   \\     /  _____||   ____|    /      ||  |     |   ____|   /   \\     |   _  \\     |  |  ( o.o )\n",
                    " > ^ <     |   (----`---|  |----`  /  ^  \\   |  |  __  |  |__      |  ,----'|  |     |  |__     /  ^  \\    |  |_)  |    |  |   > ^ < \n",
                    " /\\_/\\      \\   \\       |  |      /  /_\\  \\  |  | |_ | |   __|     |  |     |  |     |   __|   /  /_\\  \\   |      /     |  |   /\\_/\\ \n",
                    "( o.o ) .----)   |      |  |     /  _____  \\ |  |__| | |  |____    |  `----.|  `----.|  |____ /  _____  \\  |  |\\  \\----.|__|  ( o.o )\n",
                    " > ^ <  |_______/       |__|    /__/     \\__\\ \\______| |_______|    \\______||_______||_______/__/     \\__\\ | _| `._____|(__)   > ^ < \n",
                    " /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\  /\\_/\\ \n",
                    "( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )( o.o )\n",
                    " > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ <  > ^ < ",
            "\n"
    );
}

