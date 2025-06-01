package game;

import java.util.Scanner;

public class Player {
    private String playerName;
    private String gender;
    private int affection = 0;
    private String partnerName;

    public Player(String name, String gender) {
        this.playerName = name;
        this.gender = gender;
    }

    public static Player inputPlayer() {
        Scanner scanner = new Scanner(System.in);
        String name, gender;

        while (true) {
            System.out.print("이름을 입력하세요: ");
            name = scanner.nextLine();
            if (name.matches("^[가-힣a-zA-Z]{2,10}$")) break;
            else System.out.println("이름은 한글 또는 영문 2~10자여야 합니다.");
        }

        while (true) {
            System.out.print("성별을 선택하세요 (1: 남자, 2: 여자): ");
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

        return new Player(name, gender);
    }

    // === Getter & Setter ===
    public String getPlayerName() {
        return playerName;
    }

    public String getGender() {
        return gender;
    }

    public int getAffection() {
        return affection;
    }

    public void increaseAffection(int amount) {
        affection += amount;
    }

    public void resetAffection() {
        affection = 0;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
