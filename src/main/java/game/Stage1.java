package game;

import java.util.Random;
import java.util.Scanner;

public class Stage1 {
//    public static class Result {
//        public final String partnerName;
//        public final int affection;
//        public Result(String partnerName, int affection) {
//            this.partnerName = partnerName;
//            this.affection = affection;
//        }
//    }

    private final Player player;
    private Scanner sc = new Scanner(System.in);
    private final Random rand = new Random();
    private GameTools GT = new GameTools();

    public Stage1(Player player) {
        this.player = player;
    }

    public Player play() {
        boolean isMale = player.getGender().equals("남");
        String partnerName = "";
        int affection = 0;
        int sel = 0;

        if (isMale) {
            // === 남자 플레이어 스토리 ===
            System.out.println("\n[Stage1 - Male] 첫 만남");
            System.out.println("[system]️ 농구 나시티 + 슬리퍼 선택 (난이도 상) → 소개팅 상대: 예민혜");
            System.out.println("[system] 브이넥 니트 + 구찌 벨트 선택 (난이도 중) → 소개팅 상대: 조심혜");
            System.out.println("[system] 청바지 + 무지티 선택 (난이도 하) → 소개팅 상대: Easy혜");

            while (true) {
                System.out.print("의상을 선택하세요 (1~3): ");
                sel = sc.nextInt();

                if (sel >= 1 && sel <= 3) {
                    break;
                }
                else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            switch (sel) {
                case 1:
                    partnerName = "예민혜";
                    affection   = 20 + rand.nextInt(14);  // 20~33
                    System.out.println("[system] 멋은 불편함을 거부한다. 찐 여름엔 찐 나시! ('예민혜'와 만남)");
                    break;
                case 2:
                    partnerName = "조심혜";
                    affection   = 33 + rand.nextInt(18);  // 33~50
                    System.out.println("[system] 브랜드의 힘을 믿는다. 단, 알리익스프레스 출신임을 숨긴다. ('조심혜'와 만남)");
                    break;
                default:
                    partnerName = "Easy혜";
                    affection   = 50 + rand.nextInt(11);  // 50~60
                    System.out.println("[system] 무난은 무난하지 않다. 이게 바로 ‘꾸안꾸’다. ('Easy혜'와 만남)");
                    break;
            }
            player.setAffection(affection);
            System.out.println("[초기 호감도] " + affection + "\n");

            // Q1
            System.out.println("Stage 1\n");
            System.out.println(partnerName + ": 주말에 보통 뭐 하세요?");
            System.out.println("1. 혼자 영화 보거나 산책해요.");
            System.out.println("2. 친구들 만나거나 놀러 다녀요.");
            System.out.println("3. 거의 집에만 있어요.");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(10);
                    System.out.println("[system]" + partnerName + "은(는) 감성적인 일상 공유에 공감한다");
                    System.out.println("[system] 호감도 +10");
                }
                case 2 -> {
                    player.addAffection(5);
                    System.out.println("[system] 사교적인 사람을 좋아하는" + partnerName + "은(는) 긍정적인 웃음을 띈다!");
                    System.out.println("[system] 호감도 +5");
                }
                case 3 -> {
                    player.addAffection(-5);
                    System.out.println("[system] 평범한 대화," + partnerName + "은(는) 본인과도 집데이트만 할까 걱정된다.");
                    System.out.println("[system] 호감도 -5");
                }
            }

            System.out.printf("현재 호감도: %d\n\n", player.getAffection());

            // Q2
            System.out.println(partnerName + ": 최근 연애는 언제쯤이었어요?");
            System.out.println("1. 꽤 오래 됐어요. 이제는 인연 만나고 싶어요.");
            System.out.println("2. 최근이에요. 좋은 추억으로 남았어요.");
            System.out.println("3. 한동안 쉬었어요. 새 출발하고 싶네요.");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(5);
                    System.out.println("[system] 진심 어린 마음이 " + partnerName + "에게 전해지는 듯 하다!" );
                    System.out.println("[system] 호감도 +5");
                }
                case 2 -> {
                    player.addAffection(-5);
                    System.out.println("[system] 솔직한 태도에 신뢰감이 생기나, 부담스러운듯 하다... ");
                    System.out.println("[system] 호감도 -5");
                }
                case 3 -> {
                    player.addAffection(10);
                    System.out.println("[system] 감정 정리가 끝난듯 해 " + partnerName + "의 부담감이 줄었다!");
                    System.out.println("[system] 호감도 +10");
                }
            }
            System.out.println("현재 호감도: " + player.getAffection() + "\n");

            // Q3
            System.out.println(partnerName + ": 제 첫인상은 어땠어요?");
            System.out.println("1. 편하게 말 걸어주셔서 좋았어요.");
            System.out.println("2. 솔직히 좀 긴장됐어요.");
            System.out.println("3. 되게 인상이 좋으셨어요.");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(10);
                    System.out.println("[system] 따뜻한 분위기에 " + partnerName + "도 편해진 듯 하다.");
                    System.out.println("[system] 호감도 +10");
                }
                case 2 -> {
                    player.addAffection(5);
                    System.out.println("[system] 귀여운 솔직함에" + partnerName + "은(는) 미소를 짓는다." );
                    System.out.println("[system] 호감도 +5");
                }
                case 3 -> {
                    player.addAffection(5);
                    System.out.println("[system]" + partnerName + "은(는) 형식적인 대답에 미소를 짓는다.");
                }
            }
            System.out.println("현재 호감도: " + player.getAffection() + "\n");

            // Q4
            System.out.println(partnerName + ": 이상형은 어떤 사람이에요?");
            System.out.println("1. 대화가 잘 통하고 유머있는 사람이 매력적이에요.");
            System.out.println("2. 안정적이고 믿음 가는 사람이 이상형이에요.");
            System.out.println("3. 그냥 느낌오는 사림이요.");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(10);
                    System.out.println("[system] 함께 웃을 수 있는 관계를 지향하는" + partnerName + "은(는) 같이 웃는다.");
                    System.out.println("[system] 호감도 +10");
                }
                case 2 -> {
                    player.addAffection(10);
                    System.out.println("[system] 진지한 태도에" + partnerName + "의 호감도가 증가한다.");
                    System.out.println("[system] 호감도 +10");
                }
                case 3 -> {
                    player.addAffection(-10);
                    System.out.println("[system] 무슨 대답이 저렇게 대충이야?" + partnerName + "은(는) 첫 만남부터 귀찮아하는 태도에 실망했다.");
                    System.out.println("[system] 호감도 -10");
                }
            }
            System.out.println("현재 호감도: " + player.getAffection() + "\n");

            // Q5
            System.out.println(partnerName + ": 오늘 소개팅 어땠어요?");
            System.out.println("1. 많이 즐거웠어요! 또 뵐 수 있을까요?");
            System.out.println("2. 시간이 잘 갔어요! 감사합니다.");
            System.out.println("3. 좋은 경험이었어요.");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(10);
                    System.out.println("[system] 적극적인 표현에" + partnerName + "의 마음이 설레인다!");
                    System.out.println("[system] 호감도 +10");
                }
                case 2 -> {
                    player.addAffection(0);
                    System.out.println("[system] 형식적인 대답에 호감도는 변하지 않았다.");
                }
                case 3 -> {
                    player.addAffection(-10);
                    System.out.println("[system] 무성의한 태도에" + partnerName + "의 표정이 좋지 않다.");
                    System.out.println("[system] 호감도 -10");
                }
            }
            System.out.println("최종 호감도: " + player.getAffection() + "\n");
            player.setPartnerName(partnerName);
        } else {
            // === 여자 플레이어 스토리 ===
            System.out.println("\n[Stage1] 첫만남. 카톡으로 약속장소와 시간을 정하고 플레이어 집 근처 카페에서 만나기로 했다.");
            System.out.println("설레이는 마음으로 퇴근 후 집에 들려서 옷장을 열어본다. 어떤 옷을 입어야 좋을까?\n");
            System.out.println("1) 호피블레이저 + 빨간 스커트 (어려움) / 소개팅 상대: 남상규");
            System.out.println("2) 맨투맨 + 면바지 (보통)     / 소개팅 상대: 전중안");
            System.out.println("3) 흰티 + 청바지 + 가디건 (쉬움) / 소개팅 상대: 강시원");
            while (true) {
                System.out.print("[system] 의상을 선택하세요 (1~3): ");
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
                    System.out.println("[system] 어려움 선택 → '남상규'와 만남");
                    break;
                case 2:
                    partnerName = "전중안";
                    affection   = 33 + rand.nextInt(18);  // 33~50
                    System.out.println("[system] 보통 선택 → '전중안'과 만남");
                    break;
                default:
                    partnerName = "강시원";
                    affection   = 50 + rand.nextInt(11);  // 50~60
                    System.out.println("[system] 쉬움 선택 → '강시원'과 만남");
                    break;
            }
            player.setAffection(affection);
            System.out.println("[초기 호감도] " + player.getAffection() + "\n");

            // 오프닝
            System.out.println("[system] 의상을 갈아입고 화장을 고친 후 카페로 출발한다.");
            System.out.println("평일 저녁, 느좋카페, 핸드폰속 사진과 주변을 확인하며 비슷한 사람을 찾는다.");
            System.out.println("그 때 창가 자리 옆에서 일어나 인사하는 남자를 발견하고 다가간다.\n");
            System.out.printf(player.getPlayerName() + ": 안녕하세요, 혹시 오늘 이찬환님 소개로 나오신 %s님 맞으세요??\n", partnerName);
            System.out.printf(partnerName + ": 안녕하세요! 요즘 날씨가 많이 덥죠? 시원한걸로 주문해놨어요\n");
            System.out.println("[system] 깔끔하게 정돈된 머리, 15cm 정도의 키차이, 은은한 섬유유연제 향, 깔끔한 옷차림의 좋은 인상을 가졌다\n");
            System.out.println("대화를 해보며 서로를 알아보자!\n");

            // Q1
            System.out.println(partnerName + ": 사진이랑 똑같으세요. 실제로 보니까 더 인상이 좋네요! 평소에도 스타일에 신경 많이 쓰세요?\n");
            System.out.println("1. 감사합니다. 평소엔 좀 편하게 입긴 하는데, 소개팅이니까 나름 신경을 썼어요.\n\t");
            System.out.println("2. 음… 옷에 크게 신경쓰는 스타일은 아니에요.\n\t");
            System.out.println("3. 저 오늘 대충 입었어요. 옷 보다는 성격이 중요하잖아요.\n\t");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(5);
                    System.out.println("[system] 꾸밈과 자연스러움의 균형, 긍정적 인상을 심어주었다");
                    System.out.println("[system] 호감도 +5");
                }
                case 2 -> {
                    System.out.println("[system] 개성있는 스타일로 호불호가 갈릴 수 있으나, 무난하게 넘어간듯 하다");
                    System.out.println("[system] 호감도 변동 없음");
                }
                case 3 -> {
                    player.addAffection(-5);
                    System.out.println("[system] 맞는말이다. 처 맞는말");
                    System.out.println("[system] 호감도 -5");
                }
            }
            System.out.println("현재 호감도: " + player.getAffection() + "\n");

            // Q2
            System.out.println(partnerName + ": 주선자분이 되게 좋은얘기 많이 해주시던데 평소에 자주 연락하세요??\n");
            System.out.println("1. 자주 연락하죠! 거의 매일 연락하는 것 같아요.\n\t");
            System.out.println("2. 가끔? 연락 안 해도 편한 친구라서 저도 이번에 오랜만에 연락받았어요\n\t");
            System.out.println("3. 귀찮아서 연락 잘 안해요.\n\t");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(5);
                    System.out.println("[system] 관계성 중심의 여성 이미지, 긍정적 인상을 심어주었다.");
                    System.out.println("[system] 호감도 +5");
                }
                case 2 -> {
                    System.out.println("[system] 이해 가능 범주, 성향에 따라 거리감이 생길 수 있다.");
                    System.out.println("[system] 호감도 변동 없음");
                }
                case 3 -> {
                    player.addAffection(-5);
                    System.out.println("[system] 무관심 및 귀차니즘 성향으로 비춰진듯 하다.");
                    System.out.println("[system] 호감도 -5");
                }
            }
            System.out.println("현재 호감도: " + player.getAffection() + "\n");

            // Q3
            System.out.println(partnerName + ": 요즘에 일 끝나면 어떤거 하세요? 퇴근하고 여유가 좀 있으신 편인가요??\n");
            System.out.println("1. 요즘 퇴근하고 운동이랑 산책을 하면서 저만의 루틴을 만들고 있어요.\n\t");
            System.out.println("2. 쇼파에 파뭍혀서 넷플릭스 보면서 편하게 보내는 편이에요.\n\t");
            System.out.println("3. 집 가면 아무것도 하기 싫어요.\n\t");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(5);
                    System.out.println("[system] 자기관리 어필 성공!");
                    System.out.println("[system] 호감도 +5");
                }
                case 2 -> {
                    System.out.println("[system] 현실적이고 평범하다 ");
                    System.out.println("[system] 호감도 변동 없음");
                }
                case 3 -> {
                    player.addAffection(-5);
                    System.out.println("[system] 상대방까지 무기력하게 만든다.");
                    System.out.println("[system] 호감도 -5");
                }
            }
            System.out.println("현재 호감도: " + player.getAffection() + "\n");

            // Q4
            System.out.println(partnerName + ": 혹시 오늘 나오기 전에 고민 많이 하셨어요?? 소개팅 경험이 좀 있으신가요?\n");
            System.out.println("1. 솔직히 살짝 고민했는데, 이런 만남 자체가 좋은 경험이고 실제로 만나니까 나오길 잘 한것 같아요.\n\t");
            System.out.println("2. 친구 부탁드로 나온거긴 한데 큰 기대는 안했어요.\n\t");
            System.out.println("3. 어색한거 너무 싫어서 나오기 싫었어요.\n\t");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(5);
                    System.out.println("[system] 긍정적 열린 태도 어필!");
                    System.out.println("[system] 호감도 +5");
                }
                case 2 -> {
                    System.out.println("[system] 그럴 수 있다고 생각하는 듯 하다.");
                    System.out.println("[system] 호감도 변동 없음");
                }
                case 3 -> {
                    player.addAffection(-5);
                    System.out.println("[system] 상대방 속마음이 들리는 듯 하다.");
                    System.out.println("[system] 호감도 -5");
                }
            }
            System.out.println("현재 호감도: " + player.getAffection() + "\n");

            // Q5
            System.out.println(partnerName + ": 평소 연애할 땐 어떤 스타일이에요?? 표현을 자주 하시나요??\n");
            System.out.println("1. 좋아하는 사람한텐 표현을 많이 하려고 해요. 관계를 쌓아가는데 중요한 부분이라고 생각해요\n\t");
            System.out.println("2. 표현보다는 행동으로 보여주는 편이에요. 말보단 행동이죠!\n\t");
            System.out.println("3. 그런거 잘 못해요 무뚝뚝하다는 말 많이 듣는편이기도 하고..\n\t");
            sel = GT.getInput(1, 3);
            switch (sel) {
                case 1 -> {
                    player.addAffection(5);
                    System.out.println("[system] 적극적 스타일에 남자가 빵끗!");
                    System.out.println("[system] 호감도 +5");
                }
                case 2 -> {
                    System.out.println("[system] 성향에 따라 다를 듯 하다. 매력/애매함의 공존");
                    System.out.println("[system] 호감도 변동 없음");
                }
                case 3 -> {
                    player.addAffection(-5);
                    System.out.println("[system] 시작부터 거리감이 생긴 듯 하다.");
                    System.out.println("[system] 호감도 -5");
                }

            }
            System.out.println("최종 호감도: " + player.getAffection() + "\n");
            player.setPartnerName(partnerName);
        }

        // 엔딩 분기
        if (player.getAffection() < 20)
            System.out.println("[엔딩] 호감도가 너무 낮아 관계가 이어지지 않습니다.");
        else
            System.out.println("[엔딩] 다음 스테이지로 진입합니다!");

        return player;
    }
}