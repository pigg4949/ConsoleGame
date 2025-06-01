package game;

import java.util.Scanner;

public class GameTools {
    Scanner sc = new Scanner(System.in);
    int getInput(int min, int max) {
    while (true) {
        System.out.printf("선택(%d~%d): ", min, max);
        int n = sc.nextInt();
        if (n >= min && n <= max){
            return n;
        }
        else{
            System.out.println("잘못된 입력입니다. 다시 선택하세요.");
        }
    }
}
}
