package game;

import java.util.Scanner;

/**
 * Stage2 - 두 번째 데이트(영화관/레스토랑, 민초 스페셜 엔딩)
 *
 * [호출 예시]
 *   Stage2 stage = new Stage2(playerName, gender, partnerName, scanner);
 *   Stage2.Stage2Result result = stage.play(affection);
 *   affection = result.affection;
 *
 * [반환 객체]
 *   result.affection : 누적 호감도 (int)
 *   result.specialRoute : 스페셜 엔딩 분기(민초/특별루트 여부, boolean)
 *   result.stage2Success : 스테이지 통과 여부 (boolean)
 */
public class Stage2 {

    /** Stage2의 결과값을 담는 내부 클래스 */
    public static class Stage2Result {
        public int affection;
        public boolean specialRoute;
        public boolean stage2Success;
        public Stage2Result(int affection, boolean specialRoute, boolean stage2Success) {
            this.affection = affection;
            this.specialRoute = specialRoute;
            this.stage2Success = stage2Success;
        }
    }

    private final String playerName;
    private final String gender;
    private final String partnerName;
    private final Scanner scanner;

    public Stage2(String playerName, String gender, String partnerName, Scanner scanner) {
        this.playerName = playerName;
        this.gender = gender;
        this.partnerName = partnerName;
        this.scanner = scanner;
    }

    public Stage2Result play(int affection) {
        boolean specialRoute = false;
        boolean stage2Success = false;

        // ===== 남자 플레이어: 영화관 데이트 + 민초 분기 =====
        if (gender.equals("남")) {
            System.out.println("[system] 두근 두근 2번째 만남! (" + partnerName + "와 영화관 데이트)");

            // Q1
            System.out.println("[system] Q1. 혼영 가능하세요?");
            System.out.println("[system] 1. 한 줄 예매함\n[system] 2. 무조건 둘이 봐야죠\n[system] 3. 영화관 무서워요");
            int q1 = getValidatedChoice(scanner);
            switch (q1) {
                case 1 -> { affection += 5; System.out.println("[system] " + partnerName + "은(는) 독립적인 사람을 좋아합니다. [system] 호감도 +5"); }
                case 2 -> { affection += 10; System.out.println("[system] " + partnerName + "은(는) 함께하는 시간을 소중히 여깁니다. [system] 호감도 +10"); }
                case 3 -> { affection += 8; System.out.println("[system] " + partnerName + "이(가) 귀여운 면을 발견했습니다. [system] 호감도 +8"); }
            }
            System.out.println();

            // Q2
            System.out.println("[system] Q2. 팝콘 조합은?");
            System.out.println("[system] 1. 카라멜만\n[system] 2. 소금만 먹음\n[system] 3. 팝콘은 손잡는 핑계일 뿐");
            int q2 = getValidatedChoice(scanner);
            if (q2 == 1) {
                // 민초 분기
                System.out.println("[system] Q2-1. 혹시 민초 좋아하세요?");
                System.out.println("[system] 1. 완전 좋아하죠. 치약맛이라면서요 ㅋㅋ\n[system] 2. 민초요? 사람 음식 맞나요?\n[system] 3. 그냥 보통이에요.");
                int q2_1 = getValidatedChoice(scanner);
                if (q2_1 == 1) {
                    affection -= 50;
                    specialRoute = false;
                    System.out.println("[system] " + partnerName + "은(는) 반민초협회 부회장입니다. [system] 호감도 -50");
                } else if (q2_1 == 2) {
                    affection += 30;
                    specialRoute = true;
                    System.out.println("[system] " + partnerName + "은(는) 당신을 소울메이트 후보로 등록했습니다. [system] 호감도 +30");
                } else {
                    System.out.println("[system] " + partnerName + "은(는) 무난하게 넘겼습니다. [system] 호감도 변화 없음");
                }
            } else if (q2 == 2) {
                System.out.println("[system] Q2-1. 그럼… 연애도 약간 짠맛 있어야 한다고 생각하세요?");
                System.out.println("[system] 1. 네. 늘 달기만 하면 언젠간 질려요\n[system] 2. 아뇨, 연애는 달콤해야죠\n[system] 3. 잘 모르겠어요.");
                int q2_2 = getValidatedChoice(scanner);
                if (q2_2 == 1) { affection += 8; System.out.println("[system] " + partnerName + "은(는) 현실주의 공감도가 상승했습니다. [system] 호감도 +8"); }
                else if (q2_2 == 2) { affection += 3; System.out.println("[system] " + partnerName + "은(는) 달달한 연애를 꿈꿉니다. [system] 호감도 +3"); }
                else { System.out.println("[system] " + partnerName + "은(는) 고민에 빠졌습니다. [system] 호감도 변화 없음"); }
            } else if (q2 == 3) {
                System.out.println("[system] Q2-1. 오늘은 팝콘이 핑계인가요, 진심인가요?");
                System.out.println("[system] 1. 진심이죠\n[system] 2. 핑계죠\n[system] 3. 그냥 둘 다요");
                int q2_3 = getValidatedChoice(scanner);
                if (q2_3 == 1) { affection += 20; System.out.println("[system] " + partnerName + "은(는) 진심에 감동했습니다. [system] 호감도 +20"); }
                else if (q2_3 == 2) { affection += 12; System.out.println("[system] " + partnerName + "은(는) 솔직함이 좋았습니다. [system] 호감도 +12"); }
                else { System.out.println("[system] " + partnerName + "은(는) 장난스러운 답변을 웃으며 넘겼습니다. [system] 호감도 변화 없음"); }
            }
            System.out.println();

            // Q3
            System.out.println("[system] Q3. 오늘 본 영화, 어땠어요?");
            System.out.println("[system] 1. 당신 같았어요\n[system] 2. 중간에 눈물 났어요\n[system] 3. " + partnerName + "씨 옆모습만 봤어요");
            int q3 = getValidatedChoice(scanner);
            switch (q3) {
                case 1 -> { affection += 12; System.out.println("[system] " + partnerName + "이(가) 당신에게 호기심을 느꼈습니다. [system] 호감도 +12"); }
                case 2 -> { affection += 15; System.out.println("[system] " + partnerName + "이(가) 감수성에 공감합니다. [system] 호감도 +15"); }
                case 3 -> { affection += 20; System.out.println("[system] " + partnerName + "이(가) 부끄러워합니다. [system] 호감도 +20"); }
            }
            System.out.println();

            // Q4
            System.out.println("[system] Q4. 데이트 스타일?");
            System.out.println("[system] 1. 감성 카페\n[system] 2. 볼링/액티비티\n[system] 3. 집콕");
            int q4 = getValidatedChoice(scanner);
            switch (q4) {
                case 1 -> { affection += 10; System.out.println("[system] " + partnerName + "이(가) 분위기 있는 시간을 좋아합니다. [system] 호감도 +10"); }
                case 2 -> { affection += 5; System.out.println("[system] " + partnerName + "이(가) 액티비티에 관심을 보입니다. [system] 호감도 +5"); }
                case 3 -> { affection -= 10; System.out.println("[system] " + partnerName + "이(가) 집돌이/집순이를 걱정합니다. [system] 호감도 -10"); }
            }
            System.out.println();

            // Q5
            System.out.println("[system] Q5. 집 가는 길 외롭겠죠?");
            System.out.println("[system] 1. 하루종일 생각할 듯\n[system] 2. 좀 아쉽겠죠\n[system] 3. 영화 되새김질 예정");
            int q5 = getValidatedChoice(scanner);
            switch (q5) {
                case 1 -> { affection += 5; System.out.println("[system] " + partnerName + "이(가) 설렘을 느꼈습니다. [system] 호감도 +5"); }
                case 2 -> { affection += 8; System.out.println("[system] " + partnerName + "이(가) 아쉬움에 공감합니다. [system] 호감도 +8"); }
                case 3 -> { affection += 13; System.out.println("[system] " + partnerName + "이(가) 당신의 진지함에 흥미를 느꼈습니다. [system] 호감도 +13"); }
            }
            System.out.println();

            // ★ 이벤트: 비옴
            System.out.println("[system] [이벤트] 영화관에서 나왔는데 갑자기 소나기가 내립니다!");
            System.out.println("[system] 1. 우산 사올게요\n[system] 2. 그냥 뛰죠\n[system] 3. 머리 감았단 말이에요");
            int rain = getValidatedChoice(scanner);
            switch (rain) {
                case 1 -> { affection += 20; System.out.println("[system] " + partnerName + "이(가) 배려심에 감동합니다. [system] 호감도 +20"); }
                case 2 -> { affection += 10; System.out.println("[system] " + partnerName + "이(가) 함께 달리는 스릴을 즐깁니다. [system] 호감도 +10"); }
                case 3 -> { affection -= 15; System.out.println("[system] " + partnerName + "이(가) 난감해합니다. [system] 호감도 -15"); }
            }
            System.out.println();
        }
        // ===== 여자 플레이어: 레스토랑 데이트 =====
        else if (gender.equals("여")) {
            System.out.println("[system] 주말 레스토랑 데이트! (" + partnerName + "와(과) 만남)");

            // Q1
            System.out.println("[system] Q1. 어떤 음식을 좋아하시는지 몰라서 긴장되네요. 주문한 메뉴들 괜찮으세요?");
            System.out.println("[system] 1. 제 취향에 맞는 음식 잘 골라주신 것 같아요!\n[system] 2. 가리는 음식은 없어서 다 괜찮아요.\n[system] 3. 향이 강한 음식을 싫어해서, 좀 거부감이 드네요");
            int q1 = getValidatedChoice(scanner);
            switch (q1) {
                case 1 -> { affection += 5; System.out.println("[system] " + partnerName + "은(는) 센스에 만족합니다. [system] 호감도 +5"); }
                case 2 -> { System.out.println("[system] " + partnerName + "은(는) 편안해 합니다. [system] 호감도 변화 없음"); }
                case 3 -> { affection -= 5; System.out.println("[system] " + partnerName + "은(는) 당황했습니다. [system] 호감도 -5"); }
            }
            System.out.println();

            // Q2
            System.out.println("[system] Q2. 가방에 달린 건 여행 기념품이에요? 영화 좋아하시나요?");
            System.out.println("[system] 1. 여행을 굉장히 좋아해요\n[system] 2. 그냥 가끔 답답할 때 다녀와요\n[system] 3. 여행은 피곤해서 별로 안좋아해요");
            int q2 = getValidatedChoice(scanner);
            switch (q2) {
                case 1 -> { affection += 3; System.out.println("[system] " + partnerName + "은(는) 여행 이야기에 흥미를 느꼈습니다. [system] 호감도 +3"); }
                case 2 -> { affection += 2; System.out.println("[system] " + partnerName + "은(는) 일상의 소중함을 느낍니다. [system] 호감도 +2"); }
                case 3 -> { System.out.println("[system] " + partnerName + "은(는) 주제를 전환합니다. [system] 호감도 변화 없음"); }
            }
            System.out.println();

            // Q3
            System.out.println("[system] Q3. 주말엔 보통 뭐 하세요?");
            System.out.println("[system] 1. 운동이나 산책\n[system] 2. 넷플릭스\n[system] 3. 집에서 쉬어요");
            int q3 = getValidatedChoice(scanner);
            switch (q3) {
                case 1 -> { affection += 5; System.out.println("[system] " + partnerName + "이(가) 자기관리하는 점을 높이 평가합니다. [system] 호감도 +5"); }
                case 2 -> { System.out.println("[system] " + partnerName + "은(는) 소소함에 공감합니다. [system] 호감도 변화 없음"); }
                case 3 -> { affection -= 5; System.out.println("[system] " + partnerName + "이(가) 걱정합니다. [system] 호감도 -5"); }
            }
            System.out.println();

            // Q4
            System.out.println("[system] Q4. 표현을 자주 하시나요?");
            System.out.println("[system] 1. 많이 하려고 해요\n[system] 2. 행동으로 보여주는 편이에요\n[system] 3. 잘 못해요");
            int q4 = getValidatedChoice(scanner);
            switch (q4) {
                case 1 -> { affection += 5; System.out.println("[system] " + partnerName + "이(가) 감성에 공감합니다. [system] 호감도 +5"); }
                case 2 -> { System.out.println("[system] " + partnerName + "이(가) 행동을 중요하게 여깁니다. [system] 호감도 변화 없음"); }
                case 3 -> { affection -= 5; System.out.println("[system] " + partnerName + "이(가) 거리감을 느낍니다. [system] 호감도 -5"); }
            }
            System.out.println();

            // Q5
            System.out.println("[system] Q5. 오늘 나오기 전에 고민 많이 하셨어요?");
            System.out.println("[system] 1. 경험 자체가 좋아요\n[system] 2. 큰 기대는 안했어요\n[system] 3. 나오기 싫었어요");
            int q5 = getValidatedChoice(scanner);
            switch (q5) {
                case 1 -> { affection += 5; System.out.println("[system] " + partnerName + "이(가) 긍정적인 마인드에 호감을 느낍니다. [system] 호감도 +5"); }
                case 2 -> { System.out.println("[system] " + partnerName + "이(가) 담백한 면에 공감합니다. [system] 호감도 변화 없음"); }
                case 3 -> { affection -= 5; System.out.println("[system] " + partnerName + "이(가) 섭섭함을 느낍니다. [system] 호감도 -5"); }
            }
            System.out.println();

            // ★ 이벤트: 서프라이즈 디저트
            System.out.println("[system] [이벤트] 레스토랑에서 깜짝 디저트가 나왔습니다!");
            System.out.println("[system] 1. 너무 감동이에요\n[system] 2. 쑥스러워요\n[system] 3. 원래 이런 거 해요?");
            int event = getValidatedChoice(scanner);
            switch (event) {
                case 1 -> { affection += 10; System.out.println("[system] " + partnerName + "이(가) 감동한 표정으로 당신을 바라봅니다. [system] 호감도 +10"); }
                case 2 -> { affection += 5; System.out.println("[system] " + partnerName + "이(가) 귀여워합니다. [system] 호감도 +5"); }
                case 3 -> { System.out.println("[system] " + partnerName + "이(가) 쿨하게 받아줍니다. [system] 호감도 변화 없음"); }
            }
            System.out.println();
        }
        else {
            System.out.println("[system] 성별은 '남' 또는 '여'만 가능합니다.");
        }

        // --- 엔딩 조건(통과/실패/스페셜엔딩) ---
        if (affection < 40) {
            stage2Success = false;
        } else {
            stage2Success = true;
        }

        return new Stage2Result(affection, specialRoute, stage2Success);
    }

    /** 1,2,3 입력만 받기 (잘못 입력시 계속 반복) */
    private static int getValidatedChoice(Scanner sc) {
        int choice = -1;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 3) break;
            } else {
                sc.next(); // 숫자가 아니면 skip
            }
            System.out.print("[system] 1, 2, 3 중 하나를 선택하세요: ");
        }
        sc.nextLine(); // 엔터 처리
        return choice;
    }
}
