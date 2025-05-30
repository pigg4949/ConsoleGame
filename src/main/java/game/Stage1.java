package game;

import java.util.Random;
import java.util.Scanner;

public class Stage1 {
    public static class Result {
        public final String partnerName;
        public final int affection;
        public Result(String partnerName, int affection) {
            this.partnerName = partnerName;
            this.affection = affection;
        }
    }

    private final Player player;
    private final Scanner sc;
    private final Random rand = new Random();

    public Stage1(Player player, Scanner sc) {
        this.player = player;
        this.sc = sc;
    }

    public Result play() {
        boolean isMale = player.getGender().equals("남");
        String partnerName = "";
        int affection = 0;
        int sel;

        if (isMale) {
            // === 남자 플레이어 스토리 ===
            System.out.println("\n[Stage1 - Male] 첫 만남");
            System.out.println("⚙️: 농구 나시티 + 슬리퍼 선택 (난이도 상) → 소개팅 상대: 예민혜");
            System.out.println("⚙️: 브이넥 니트 + 구찌 벨트 선택 (난이도 중) → 소개팅 상대: 조심혜");
            System.out.println("⚙️: 청바지 + 무지티 선택 (난이도 하) → 소개팅 상대: Easy혜");
            while (true) {
                System.out.print("의상을 선택하세요 (1~3): ");
                try {
                    sel = Integer.parseInt(sc.nextLine());
                    if (sel >= 1 && sel <= 3) break;
                } catch (Exception e) {}
                System.out.println("잘못된 입력입니다.");
            }
            switch (sel) {
                case 1:
                    partnerName = "예민혜";
                    affection   = 20 + rand.nextInt(14);  // 20~33
                    System.out.println("⚙️ 멋은 불편함을 거부한다. 찐 여름엔 찐 나시! ('예민혜'와 만남)");
                    break;
                case 2:
                    partnerName = "조심혜";
                    affection   = 33 + rand.nextInt(18);  // 33~50
                    System.out.println("⚙️ 브랜드의 힘을 믿는다. 단, 알리익스프레스 출신임을 숨긴다. ('조심혜'와 만남)");
                    break;
                default:
                    partnerName = "Easy혜";
                    affection   = 50 + rand.nextInt(11);  // 50~60
                    System.out.println("⚙️ 무난은 무난하지 않다. 이게 바로 ‘꾸안꾸’다. ('Easy혜'와 만남)");
                    break;
            }
            player.setAffection(affection);
            System.out.println("[초기 호감도] " + affection + "\n");

            // Q1
            System.out.println("Stage 1\n");
            System.out.println("💁‍♂️) 사진이랑 똑같으세요. 실제로 보니까 더 인상이 좋네요! 평소에도 스타일에 신경 많이 쓰세요?");
            System.out.println("1) 감사합니다. 점잖게 입었어요. (호감도+5)");
            System.out.println("2) 무난한 스타일이에요.        (호감도+0)");
            System.out.println("3) 대충 입었어요. 성격이 중요하죠. (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q2
            System.out.println("💁‍♂️) 주선자분이 연락 많이 해주시던데, 평소에 자주 연락하세요?");
            System.out.println("1) 매일 연락해요.    (호감도+5)");
            System.out.println("2) 가끔 연락해요.    (호감도+0)");
            System.out.println("3) 거의 연락 안 해요. (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q3
            System.out.println("💁‍♂️) 퇴근 후엔 주로 뭐 하세요?");
            System.out.println("1) 운동하거나 산책해요.    (호감도+5)");
            System.out.println("2) 넷플릭스 봐요.         (호감도+0)");
            System.out.println("3) 그냥 집에만 있어요.    (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q4
            System.out.println("💁‍♂️) 소개팅 전날 고민 많이 하셨어요?");
            System.out.println("1) 고민했어요.  (호감도+5)");
            System.out.println("2) 별생각 없었어요. (호감도+0)");
            System.out.println("3) 나오기 싫었어요.  (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q5
            System.out.println("💁‍♂️) 평소 연애 스타일은 어떤 편이세요?");
            System.out.println("1) 표현 많이 해요.  (호감도+5)");
            System.out.println("2) 행동으로 보여줘요. (호감도+0)");
            System.out.println("3) 잘 못해요.       (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("최종 호감도: " + affection + "\n");

        } else {
            // === 여자 플레이어 스토리 ===
            System.out.println("\n[Stage1 - Female] 첫만남. 카톡으로 약속장소와 시간을 정하고 플레이어 집 근처 카페에서 만나기로 했다.");
            System.out.println("설레이는 마음으로 퇴근 후 집에 들려서 옷장을 열어본다. 어떤 옷을 입어야 좋을까?\n");
            System.out.println("1) 호피블레이저 + 빨간 스커트 (어려움) / 소개팅 상대: 남상규");
            System.out.println("2) 맨투맨 + 면바지 (보통)     / 소개팅 상대: 전중안");
            System.out.println("3) 흰티 + 청바지 + 가디건 (쉬움) / 소개팅 상대: 강시원");
            while (true) {
                System.out.print("의상을 선택하세요 (1~3): ");
                try {
                    sel = Integer.parseInt(sc.nextLine());
                    if (sel >= 1 && sel <= 3) break;
                } catch (Exception e) {}
                System.out.println("잘못된 입력입니다.");
            }
            switch (sel) {
                case 1:
                    partnerName = "남상규";
                    affection   = 20 + rand.nextInt(14);  // 20~33
                    System.out.println("⚙️ 어려움 선택 → '남상규'와 만남");
                    break;
                case 2:
                    partnerName = "전중안";
                    affection   = 33 + rand.nextInt(18);  // 33~50
                    System.out.println("⚙️ 보통 선택 → '전중안'과 만남");
                    break;
                default:
                    partnerName = "강시원";
                    affection   = 50 + rand.nextInt(11);  // 50~60
                    System.out.println("⚙️ 쉬움 선택 → '강시원'과 만남");
                    break;
            }
            player.setAffection(affection);
            System.out.println("[초기 호감도] " + affection + "\n");

            // 오프닝
            System.out.println("⚙️ 의상을 갈아입고 화장을 고친 후 카페로 출발한다.");
            System.out.println("평일 저녁, 느좋카페, 핸드폰속 사진과 주변을 확인하며 비슷한 사람을 찾는다.");
            System.out.println("그 때 창가 자리 옆에서 일어나 인사하는 남자를 발견하고 다가간다.\n");
            System.out.printf("여자) 안녕하세요, 혹시 오늘 이찬환님 소개로 나오신 %s님 맞으세요??\n", partnerName);
            System.out.printf("남자) 안녕하세요! 이솔비님 소개로 나오신 %s님 맞으시죠?\n\n", partnerName);
            System.out.println("시스템) 깔끔하게 정돈된 머리, 15cm 정도의 키차이, 은은한 섬유유연제 향, 깔끔한 옷차림의 좋은 인상을 가졌다");
            System.out.println("대화를 해보며 서로를 알아보자!\n");

            // Q1
            System.out.println("Stage 1\n");
            System.out.println("💁‍♂️) 사진이랑 똑같으세요. 실제로 보니까 더 인상이 좋네요! 평소에도 스타일에 신경 많이 쓰세요?\n");
            System.out.println("💁‍♀️a) 감사합니다. 평소엔 좀 편하게 입긴 하는데, 소개팅이니까 나름 신경을 썼어요.\n\t⚙️ 꾸밈과 자연스러움의 균형, 긍정적 인상을 심어주었다 (호감도+5)");
            System.out.println("💁‍♀️b) 음… 옷에 크게 신경쓰는 스타일은 아니에요.\n\t⚙️ 개성있는 스타일로 호불호가 갈릴 수 있으나, 무난하게 넘어간듯 하다 (호감도+0)");
            System.out.println("💁‍♀️c) 저 오늘 대충 입었어요. 옷 보다는 성격이 중요하잖아요.\n\t⚙️맞는말이다. 처 맞는말 (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q2
            System.out.println("💁‍♂️) 주선자분이 되게 좋은얘기 많이 해주시던데 평소에 자주 연락하세요??\n");
            System.out.println("💁‍♀️a) 자주 연락하죠! 거의 매일 연락하는 것 같아요.\n\t⚙️ 관계성 중심의 여성 이미지, 긍정적 인상을 심어주었다 (호감도+5)");
            System.out.println("💁‍♀️b) 가끔? 연락 안 해도 편한 친구라서 저도 이번에 오랜만에 연락받았어요\n\t⚙️ 이해 가능 범주, 성향에 따라 거리감이 생길 수 있다 (호감도+0)");
            System.out.println("💁‍♀️c) 귀찮아서 연락 잘 안해요.\n\t⚙️무관심 및 귀차니즘 성향으로 비춰진듯 하다. (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q3
            System.out.println("💁‍♂️) 요즘에 일 끝나면 어떤거 하세요? 퇴근하고 여유가 좀 있으신 편인가요??\n");
            System.out.println("💁‍♀️a) 요즘 퇴근하고 운동이랑 산책을 하면서 저만의 루틴을 만들고 있어요.\n\t⚙️ 자기관리 어필 성공! (호감도+5)");
            System.out.println("💁‍♀️b) 쇼파에 파뭍혀서 넷플릭스 보면서 편하게 보내는 편이에요.\n\t⚙️ 현실적이고 평범하다 (호감도+0)");
            System.out.println("💁‍♀️c) 집 가면 아무것도 하기 싫어요.\n\t⚙️ 상대방까지 무기력하게 만든다 (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q4
            System.out.println("💁‍♂️) 혹시 오늘 나오기 전에 고민 많이 하셨어요?? 소개팅 경험이 좀 있으신가요?\n");
            System.out.println("💁‍♀️a) 솔직히 살짝 고민했는데, 이런 만남 자체가 좋은 경험이고 실제로 만나니까 나오길 잘 한것 같아요.\n\t⚙️ 긍정적 열린 태도 어필 (호감도+5)");
            System.out.println("💁‍♀️b) 친구 부탁드로 나온거긴 한데 큰 기대는 안했어요.\n\t⚙️ 그럴 수 있다고 생각하는 듯 하다. (호감도+0)");
            System.out.println("💁‍♀️c) 어색한거 너무 싫어서 나오기 싫었어요.\n\t⚙️ 상대방 속마음이 들리는 듯 하다. (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("현재 호감도: " + affection + "\n");

            // Q5
            System.out.println("💁‍♂️) 평소 연애할 땐 어떤 스타일이에요?? 표현을 자주 하시나요??\n");
            System.out.println("💁‍♀️a) 좋아하는 사람한텐 표현을 많이 하려고 해요. 관계를 쌓아가는데 중요한 부분이라고 생각해요\n\t⚙️ 적극적 + 감성적 (호감도+5)");
            System.out.println("💁‍♀️b) 표현보다는 행동으로 보여주는 편이에요. 말보단 행동이죠!\n\t⚙️ 성향에 따라 다를 듯 하다. 매력/애매함의 공존 (호감도+0)");
            System.out.println("💁‍♀️c) 그런거 잘 못해요 무뚝뚝하다는 말 많이 듣는편이기도 하고..\n\t⚙️ 시작부터 거리감이 생긴 듯 하다. (호감도-5)");
            sel = getInput(1, 3);
            if (sel == 1) affection += 5;
            else if (sel == 3) affection -= 5;
            player.setAffection(affection);
            System.out.println("최종 호감도: " + affection + "\n");
        }

        // 엔딩 분기
        if (player.getAffection() < 20)
            System.out.println("[엔딩] 호감도가 너무 낮아 관계가 이어지지 않습니다.");
        else
            System.out.println("[엔딩] 다음 스테이지로 진입합니다!");

        return new Result(partnerName, player.getAffection());
    }

    private int getInput(int min, int max) {
        while (true) {
            System.out.printf("선택(%d~%d): ", min, max);
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) return n;
            } catch (Exception e) {}
            System.out.println("잘못된 입력입니다. 다시 선택하세요.");
        }
    }
}
