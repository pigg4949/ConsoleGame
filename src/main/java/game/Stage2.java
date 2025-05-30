package game;

import java.util.Random;
import java.util.Scanner;

public class Stage2 {
    private Player player;
    private Scanner sc;
    private String partnerName;

    public Stage2(Player player, Scanner sc, String partnerName) {
        this.player = player;
        this.sc = sc;
        this.partnerName = partnerName;
    }

    /**
     * Stage2: 두 번째 데이트 (남자는 영화관, 여자는 레스토랑)
     */
    public void play() {
        System.out.println("\n[Stage2] 두근두근 2번째 데이트\n");
        if (player.getGender().equals("남")) {
            playMale();
        } else {
            playFemale();
        }
    }

    /** 남자 플레이어용: 영화관 데이트 전체 대본 */
    private void playMale() {
        int input;

        System.out.println("⚙️ 두근 두근 2번째 만남! (" + partnerName + "와 영화관 데이트)\n");

        // Q1
        System.out.println("💁‍♂️) Q1. 혼영 가능하세요?");
        System.out.println("1. 혼영 진짜 좋아해요. 혼자 영화관 한 줄 통째로 예매함");
        System.out.println("2. 저는 무조건 둘이 봐야죠. 팝콘 핑계로 손 잡아야 하니까");
        System.out.println("3. 영화관 자체가 무서워요. 광고에서 감동받아 운 적 있음");
        input = getInput(1, 3);
        if (input == 1) {
            player.addAffection(5);
            System.out.println("[system] 하늘은 '이 사람 자기랑 영화도 나눠 못 보는 사람일지도…?'라는 생각에 혼란을 느꼈습니다. 호감도 +5");
        } else if (input == 2) {
            player.addAffection(10);
            System.out.println("[system] 하늘은 갑작스러운 스킨십 언급에 멘탈이 살짝 날아갔습니다. 호감도 +10 (신중도 -15)");
        } else {
            player.addAffection(8);
            System.out.println("[system] 하늘은 이 사람의 감수성을 이해할 수 없어... 오히려 좋아했습니다. 호감도 +8 (이해불가 보너스)");
        }
        System.out.println("현재 호감도: " + player.getAffection() + "\n");

        // Q2
        System.out.println("💁‍♂️) Q2. 팝콘은 단짠 조합이 국룰 아닌가요?");
        System.out.println("1. 오히려 카라멜만! 인생은 단맛만 있으면 돼요");
        System.out.println("2. 전 소금팝콘만 먹어요. 단 건 별로…");
        System.out.println("3. 팝콘은 손 잡는 핑계일 뿐이죠");
        input = getInput(1, 3);
        if (input == 1) {
            System.out.println("  → 분기 질문: \"혹시 민초 좋아하세요?\"");
            System.out.println("    1) 완전 좋아하죠. 치약맛이라면서요 ㅋㅋ");
            System.out.println("    2) 민초요? 사람 음식 맞나요?");
            System.out.println("    3) 그냥 보통이에요.");
            int sub = getInput(1,3);
            if (sub == 1) {
                player.addAffection(-50);
                System.out.println("[system] 하늘은 반민초협회 부회장입니다. 호감도 -50 / 대화종료까지 -2턴");
            } else if (sub == 2) {
                player.addAffection(30);
                System.out.println("[system] 하늘은 당신을 소울메이트 후보로 등록했습니다. 호감도 +30 / 민초혐오공감치 +999");
                System.out.println("[system] 비밀 선택지 ‘민초 지옥 탈출 커플 루트’가 열렸습니다.");
            } else {
                System.out.println("[system] 하늘은 무난하게 넘겼습니다. 호감도 변화 없음");
            }
        } else if (input == 2) {
            System.out.println("  → 분기 질문: \"그럼… 연애도 약간 짠맛 있어야 한다고 생각하세요?\"");
            System.out.println("    1) 네. 늘 달기만 하면 언젠간 질려요");
            System.out.println("    2) 아뇨, 연애는 무조건 달콤해야죠. 현실에서까지 고생하고 싶진 않아요");
            System.out.println("    3) 잘 모르겠어요.");
            int sub = getInput(1,3);
            if (sub == 1) {
                player.addAffection(8);
                System.out.println("[system] 호감도 +8 (현실주의 커플관 공감도 상승)");
            } else if (sub == 2) {
                player.addAffection(3);
                System.out.println("[system] 호감도 +3 (도피형 분석)");
            } else {
                System.out.println("[system] 호감도 변화 없음");
            }
        } else {
            System.out.println("  → 분기 질문: \"그럼… 오늘은 팝콘이 핑계인가요, 진심인가요?\"");
            System.out.println("    1) 진심이죠. 팝콘 말고도 같이 먹고 싶은 게 많아요");
            System.out.println("    2) 핑계죠. 손잡고 싶어서 무슨 수를 써서라도 샀어요");
            System.out.println("    3) 그냥 둘 다요");
            int sub = getInput(1,3);
            if (sub == 1) {
                player.addAffection(20);
                System.out.println("[system] 호감도 +20 / 야식권유도 +1");
            } else if (sub == 2) {
                player.addAffection(12);
                System.out.println("[system] 호감도 +12 / 주의력 집중도 +15");
            } else {
                System.out.println("[system] 호감도 변화 없음");
            }
        }
        System.out.println("현재 호감도: " + player.getAffection() + "\n");

        // Q3
        System.out.println("💁‍♂️) Q3. 방금 영화 어땠어요?");
        System.out.println("1. 주인공이 당신 같았어요. 감정 이입됐어요");
        System.out.println("2. 중간에 눈물 터졌어요. 근데 몰래 봤죠");
        System.out.println("3. 영화는 기억 안 나고 " + partnerName + " 씨 옆모습밖에 안 보였어요");
        input = getInput(1,3);
        if (input == 1) {
            player.addAffection(12);
            System.out.println("[system] 호감도 +12 (현실도피형 호감도 상승)");
        } else if (input == 2) {
            player.addAffection(15);
            System.out.println("[system] 호감도 +15 (내 사람 가능성 ↑)");
        } else {
            player.addAffection(20);
            System.out.println("[system] 호감도 +20 (치명타 판정)");
        }
        System.out.println();

        // Q4
        System.out.println("💁‍♂️) Q4. 데이트라면 어떤 스타일 선호하세요?");
        System.out.println("1. 감성카페 돌기 / 전시회 구경");
        System.out.println("2. 볼링 / 방탈출 / 액티비티");
        System.out.println("3. 집콕 / 넷플릭스 / 배달 시켜먹기");
        input = getInput(1,3);
        if (input == 1) {
            player.addAffection(10);
            System.out.println("[system] 호감도 +10");
        } else if (input == 2) {
            player.addAffection(5);
            System.out.println("[system] 호감도 +5");
        } else {
            player.addAffection(-10);
            System.out.println("[system] 호감도 -10");
        }
        System.out.println();

        // Q5
        System.out.println("💁‍♂️) Q5. 집 가는 길 외롭겠죠?");
        System.out.println("1. 외롭긴요. " + partnerName + " 씨 사진으로 하루 종일 생각할 듯");
        System.out.println("2. 외롭진 않아도 좀 아쉽겠죠");
        System.out.println("3. 집 가는 길에 영화 다시 돌이켜보면서 혼자 몰입 예정");
        input = getInput(1,3);
        if (input == 1) {
            player.addAffection(5);
            System.out.println("[system] 호감도 +5 / 스토커 감지율 +20");
        } else if (input == 2) {
            player.addAffection(8);
            System.out.println("[system] 호감도 +8 (안정적인 감정호조)");
        } else {
            player.addAffection(13);
            System.out.println("[system] 호감도 +13");
        }
        System.out.println();

        // 돌발 상황: 소나기
        System.out.println("💥 돌발 상황: 갑작스러운 비");
        System.out.println("하늘: “어? 비 오네요...”");
        System.out.println("1. “우산 사올게요. 거기서 잠깐만 기다려요”");
        System.out.println("2. “그냥 뛰죠! 영화처럼!”");
        System.out.println("3. “헐… 젖으면 안 되는데… 머리 감았단 말이에요”");
        input = getInput(1,3);
        if (input == 1) {
            player.addAffection(20);
            System.out.println("[system] 호감도 +20. 매너남 칭호 획득!");
        } else if (input == 2) {
            player.addAffection(10);
            System.out.println("[system] 호감도 +10 / 감기확률 +50%");
        } else {
            player.addAffection(-15);
            System.out.println("[system] 호감도 -15");
        }
        System.out.println();

        // 엔딩 분기
        System.out.println("===== Stage2 엔딩 =====");
        if (player.getAffection() < 40) {
            System.out.println("[지인 엔딩] 매너는 있었지만 연애는 없었다.");
        } else {
            System.out.println("[Stage2 통과!] 다음 스테이지로 진입합니다.");
        }
        System.out.println("=======================\n");
    }

    /** 여자 플레이어용: 레스토랑 데이트 전체 대본 */
    private void playFemale() {
        Random rand = new Random();
        int input;

        System.out.println("⚙️ 카페 소개팅 이후 주말 레스토랑 데이트, 남성이 먼저 도착해 기다리고 있다.");
        System.out.println("남성: \"어떤 음식을 좋아하시는지 몰라서 긴장되네요. 주문한 메뉴들 괜찮으세요??\"\n");

        // Q1
        System.out.println("💁‍♀️a) 제 취향에 맞는 음식 잘 골라주신 것 같아요~! 저희 입맛이 비슷한가봐요!");
        System.out.println("    ⚙️ 취향이 맞는 부분을 찾았다 출발이 좋다. (호감도+5)");
        System.out.println("💁‍♀️b) 가리는 음식은 없어서 다 괜찮아요.");
        System.out.println("    ⚙️ 무난한 흐름이다. (호감도+0)");
        System.out.println("💁‍♀️c) 향이 강한 음식을 싫어해서, 좀 거부감이 드네요");
        System.out.println("    ⚙️ 벌써부터 삐그덕, 남자가 곤란해 한다 (호감도-5)");
        input = getInput(1,3);
        if (input == 1) {
            player.addAffection(5);
        } else if (input == 3) {
            player.addAffection(-5);
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // 분기 질문 Q2
        System.out.println("[분기 질문]");
        System.out.println("남성: \"가방에 달린건 여행 기념품이에요?? 여행 좋아하시나요??\"\n");

        System.out.println("💁‍♀️a) 네, 여행을 굉장히 좋아해요, 떠나기 전 설레임이 좋아요.");
        System.out.println("    ⚙️ 저도 여행 전날에 여행지에서 어떤 일이 일어날까 기대되서 잠을 잘 못자요");
        System.out.println("    남성: \"여행 계획의 설레임 저도 좋아해요! 특히 여행지에서 맛집 찾았을때 엄청 기분이 좋잖아요?!\"\n");
        System.out.println("   💁‍♀️a1) 저도 여행지 맛집은 꼭꼭 찾아다녀요! 식도락 여행의 묘미를 아시네여 ㅋㅋㅋ (호감도+5)");
        System.out.println("       ⚙️ 여행은 먹으려고 다니는 거죠 ㅋㅋ");
        System.out.println("   💁‍♀️a2) 꼭 맛집을 찾는건 아니지만 어떤 기분인지는 저도 알것같네요. (호감도+0)");
        System.out.println("       ⚙️ 여행은 즐기려고 가는거니까요");
        System.out.println("   💁‍♀️a3) 저는 관광지 위주, 사진 잔뜩 찍어야해요, 남는건 사진이니까요. (호감도-5)");
        System.out.println("       ⚙️ 저는 여행을 먹으려고 가는거라서 사진은 별로 중요하게 생각하지 않네요\n");
        if (input == 1) {
            int sub = getInput(1,3);
            if (sub == 1) player.addAffection(5);
            else if (sub == 3) player.addAffection(-5);
        }

        System.out.println("💁‍♀️b) 그냥 가끔 답답할 때 다녀오곤 해요.");
        System.out.println("    ⚙️ 일상에서 벗어나는 느낌을 받으려고 여행을 가는 분들도 많죠");
        System.out.println("    남성: \"여행을 싫어하시는건 아닌가보네요, 혹시 최근에 다녀오신 곳 있어요??\"\n");
        System.out.println("   💁‍♀️b1) 지방 축제에 갔었는데 기대 이상이었어요. 축제에 맛있는것도 많더라구요. (호감도+5)");
        System.out.println("       ⚙️ 여행의 묘미는 맛있는 음식이죠!");
        System.out.println("   💁‍♀️b2) 그냥 일상에서 벗어나는 것 자체가 힐링이 되더라구요. (호감도+0)");
        System.out.println("       ⚙️ 일상에서 벗어나는 것만으로도 마음이 가벼워지죠");
        System.out.println("   💁‍♀️b3) 특별히 기억에 남는 여행은 없었네요. (호감도+0)");
        System.out.println("       ⚙️ 뭐.. 사람마다 기억하는게 다르니까요.\n");
        if (input == 2) {
            int sub = getInput(1,3);
            if (sub == 1) player.addAffection(5);
        }

        System.out.println("💁‍♀️c) 아뇨, 여행은 피곤해서 별로 안좋아해요, 가방에 달린 고리는 선물받았어요.");
        System.out.println("    ⚙️ 고리만 보고 저처럼 여행을 좋아하시는줄 알았네요");
        System.out.println("    남성: \"그럼 여행 말고 좋아하는 다른건 있으세요?? 저는 게임 좋아하거든요.\"\n");
        System.out.println("   💁‍♀️c1) 저도 주말에 게임 즐겨해요! 나름 잘 하기도 하구요! (호감도+5)");
        System.out.println("       ⚙️ 오 하시는 게임이 같다면 나중에 같이 하시죠!");
        System.out.println("   💁‍♀️c2) 게임 잘 하진 않는데 친구들하고 같이 할때 정도? (호감도+0)");
        System.out.println("       ⚙️ 혼자하는 것보다는 같이 하는게 재밌죠.");
        System.out.println("   💁‍♀️c3) 집에서 그냥 아무 계획 없이 보내요. 쇼파가 최고 (호감도+0)");
        System.out.println("       ⚙️ 그래도 주말을 집에서만 보내기 아깝네요.\n");
        if (input == 3) {
            int sub = getInput(1,3);
            if (sub == 1) player.addAffection(5);
        }

        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // 돌발 상황
        System.out.println("💥 돌발 상황: 상대의 음식에서 소스가 옷에 튀었다. 분위기가 나빠진거 같다.");
        System.out.println("1) \"괜찮아요. 옷은 더러워질수도 있는 거잖아요\" (+8)");
        System.out.println("   상대 반응: \"그래도 죄송하네요. 사죄의 의미로 밥 한번 더 살게요.\"");
        System.out.println("2) \"빨면 되요.\" (0)");
        System.out.println("   상대 반응: \"죄송해요. 안지워지면 연락주세요.\"");
        System.out.println("3) \"엄청 아끼는 옷인데..\" (-8)");
        System.out.println("   상대 반응: \"죄송합니다. 세탁비는 따로 보내드릴게요\"\n");
        input = getInput(1,3);
        if (input == 1) {
            player.addAffection(8);
        } else if (input == 3) {
            player.addAffection(-8);
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // 엔딩 분기
        System.out.println("===== Stage2 엔딩 =====");
        if (player.getAffection() < 40) {
            System.out.println("[지인 엔딩] 매너는 있었지만 연애는 없었다.");
        } else {
            System.out.println("[Stage2 통과!] 다음 스테이지로 진입합니다.");
        }
        System.out.println("=======================\n");
    }

    /** 1~3 입력만 받고, 아니면 반복 */
    private int getInput(int min, int max) {
        int num;
        while (true) {
            System.out.printf("선택(%d~%d): ", min, max);
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) return num;
            } catch (Exception ignored) {}
            System.out.println("잘못된 입력입니다. 다시 선택하세요.");
        }
    }
}
