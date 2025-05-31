package game;

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

    public void play() {
        System.out.println("\n[Stage2] 두근두근 2번째 데이트\n");
        if (player.getGender().equals("남")) {
            playMale();
        } else {
            playFemale();
        }
    }

    private void playMale() {
        int input;

        System.out.println("💃 Q1. 저 영화 좋아하긴 하는데 혼자도 잘 봐요!" + player + "씨는 혼영 가능하세요?");
        System.out.println("  1. 혼영 진짜 좋아해요. 혼자 영화관 한 줄 통째로 예매함");
        System.out.println("  2. 저는 무조건 둘이 봐야죠. 팝콘 핑계로 손 잡아야 하니까");
        System.out.println("  3. 영화관 자체가 무서워요. 광고에서 감동받아 운 적 있음");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) '이 사람 자기랑 영화도 나눠 못 보는 사람일지도…?'라는 생각에 혼란을 느꼈습니다.");
                System.out.println("[system] 호감도 +5 자기애에는 약하지만 감명받았습니다.");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 갑작스러운 스킨십 언급에 멘탈이 살짝 날아갔습니다.");
                System.out.println("[system] 호감도가 +10 되었지만 신중도가 -15 되었습니다.");
                player.addAffection(10);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 감수성을 이해할 수 없어... 오히려 좋아했습니다.");
                System.out.println("[system] 호감도 +8 이해불가 호감도 보너스가 적용되었습니다.");
                player.addAffection(8);
            }
        }

        System.out.println("💃 Q2. 팝콘은 단짠 조합이 국룰 아닌가요?");
        System.out.println("  1. 오히려 카라멜만! 인생은 단맛만 있으면 돼요");
        System.out.println("  2. 전 소금팝콘만 먹어요. 단 건 별로…");
        System.out.println("  3. 팝콘은 손 잡는 핑계일 뿐이죠");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] 민초 질문이 튀어나왔습니다.");
                System.out.println("💃 Q2-1. 혹시 민초 좋아하세요?");
                System.out.println("  1. 완전 좋아하죠. 치약맛이라면서요 ㅋㅋ");
                System.out.println("  2. 민초요? 사람 음식 맞나요?");

                int sub = getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + partnerName + "은(는) 반민초협회 부회장입니다.");
                        System.out.println("[system] 호감도 -50");
                        player.addAffection(-50);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) 당신을 소울메이트 후보로 등록했습니다.");
                        System.out.println("[system] 호감도 +30 민초혐오공감치 +999");
                        System.out.println("[system] 비밀 선택지 ‘민초 지옥 탈출 커플 루트’가 열렸습니다.\n");
                        player.addAffection(30);
                    }
                }
            }
            case 2 -> {
                System.out.println("💃 Q2-1. 그럼… 연애도 약간 짠맛 있어야 한다고 생각하세요?");
                System.out.println("  1. 네. 늘 달기만 하면 언젠간 질려요");
                System.out.println("  2. 아뇨, 연애는 무조건 달콤해야죠. 현실에서까지 고생하고 싶진 않아요");
                int sub = getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + partnerName + "은(는) 이 발언에 지나치게 공감했습니다");
                        System.out.println("[system] 호감도 +18 현실주의 커플관 공감도 상승");
                        player.addAffection(18);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) '이 사람 도피형인가…?'라고 분석했습니다.\n");
                        System.out.println("[system] 호감도 +3 위험감지 +1");
                        player.addAffection(3);
                    }
                    case 3 -> {
                        System.out.println("[system] " + partnerName + "은(는) 고민에 빠졌습니다.");
                        System.out.println("[system] 호감도 변화 없음");
                    }
                }
            }
            case 3 -> {
                System.out.println("💃Q2-1. 그럼… 오늘은 팝콘이 핑계인가요, 진심인가요?");
                System.out.println("  1. 진심이죠. 팝콘 말고도 같이 먹고 싶은 게 많아요");
                System.out.println("  2. 핑계죠. 손잡고 싶어서 무슨 수를 써서라도 샀어요");
                int sub = getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + partnerName + "은(는) 얼굴 근육이 움직이지 않았지만 심장이 0.5초 빨라졌습니다.");
                        System.out.println("[system] 호감도 +20 야식권유도 +1");
                        player.addAffection(20);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) 생각보다 더 진심인 당신에게 당황 + 흥미를 느꼈습니다.");
                        System.out.println("[system] 호감도 +12 주의력 집중도 +15");
                        player.addAffection(12);
                    }
                }
            }
        }
        // Q3
        System.out.println("====== 영화가 끝났다 ======");
        System.out.println("💃 Q3. 방금 영화 어땠어요?");
        System.out.println("  1. 주인공이 당신 같았어요. 감정 이입됐어요");
        System.out.println("  2. 중간에 눈물 터졌어요. 근데 몰래 봤죠");
        System.out.println("  3. 영화는 기억 안 나고" + partnerName + " 씨 옆모습만 봤어요");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 자신이 주인공이라니 충격에 빠졌습니다.");
                System.out.println("[system] 호감도 +12 현실도피형 호감도 상승이 감지되었습니다.\n");
                player.addAffection(12);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 인간미에 감동받았습니다.");
                System.out.println("[system] 호감도 +15 몰래 우는 타입 = 내 사람 가능성 ↑");
                player.addAffection(15);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "하늘은 정지 후, 재부팅 중입니다.\n");
                System.out.println("[system] 호감도 +20 치명타 판정\n");
                player.addAffection(20);
            }
        }

        // Q4
        System.out.println("💃 Q4. 데이트 스타일은?");
        System.out.println("  1. 감성 카페");
        System.out.println("  2. 볼링/액티비티");
        System.out.println("  3. 집콕");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 분위기 있는 시간을 좋아합니다.");
                System.out.println("[system] 호감도 +10");
                player.addAffection(10);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 액티비티에 관심을 보입니다.");
                System.out.println("[system] 호감도 +5");
                player.addAffection(5);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 집돌이/집순이를 걱정합니다.");
                System.out.println("[system] 호감도 -10");
                player.addAffection(-10);
            }
        }

        // Q5
        System.out.println("💃 Q5. 집 가는 길 외롭겠죠?");
        System.out.println("  1. 하루종일 생각할 듯");
        System.out.println("  2. 좀 아쉽겠죠");
        System.out.println("  3. 영화 되새김질 예정");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 설렘을 느꼈습니다.");
                System.out.println("[system] 호감도 +5");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 아쉬움에 공감합니다.");
                System.out.println("[system] 호감도 +8");
                player.addAffection(8);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 당신의 진지함에 흥미를 느꼈습니다.");
                System.out.println("[system] 호감도 +13");
                player.addAffection(13);
            }
        }

        // 돌발 이벤트
        System.out.println("💥 영화관에서 나왔는데 갑자기 소나기가 내립니다!");
        System.out.println("  1. 우산 사올게요");
        System.out.println("  2. 그냥 뛰죠");
        System.out.println("  3. 머리 감았단 말이에요");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 배려심에 감동합니다.");
                System.out.println("[system] 호감도 +20");
                player.addAffection(20);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 함께 달리는 스릴을 즐깁니다.");
                System.out.println("[system] 호감도 +10");
                player.addAffection(10);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 난감해합니다.");
                System.out.println("[system] 호감도 -15");
                player.addAffection(-15);
            }
        }

        System.out.println("===== Stage2 엔딩 =====");
        if (player.getAffection() < 40) {
            System.out.println("[지인 엔딩] 매너는 있었지만 연애는 없었다.");
        } else {
            System.out.println("[Stage2 통과!] 다음 스테이지로 진입합니다.");
        }
        System.out.println("=======================\n");
    }

    private void playFemale() {
        int input;

        // Q1
        System.out.println("👨‍💼 Q1. 어떤 음식을 좋아하시는지 몰라서 긴장되네요. 주문한 메뉴들 괜찮으세요?");
        System.out.println("  1. 제 취향에 맞는 음식 잘 골라주신 것 같아요!");
        System.out.println("  2. 가리는 음식은 없어서 다 괜찮아요");
        System.out.println("  3. 향이 강한 음식을 싫어해서, 좀 거부감이 드네요");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 센스에 만족합니다.");
                System.out.println("[system] 호감도 +5");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 편안해 합니다.");
                System.out.println("[system] 호감도 변화 없음");
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 당황했습니다.");
                System.out.println("[system] 호감도 -5");
                player.addAffection(-5);
            }
        }

        // Q2
        System.out.println("👨‍💼 Q2. 가방에 달린 건 여행 기념품이에요? 여행 좋아하시나요?");
        System.out.println("  1. 여행을 굉장히 좋아해요, 떠나기 전 설렘이 좋아요");
        System.out.println("  2. 그냥 가끔 답답할 때 다녀와요");
        System.out.println("  3. 여행은 피곤해서 별로 안 좋아해요");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("👨‍💼 어떤 여행의 즐거움을 가장 좋아하세요?");
                System.out.println("  1. 맛집 탐방");
                System.out.println("  2. 감성적인 여행 분위기");
                System.out.println("  3. 사진을 많이 찍는 여행");
                int sub = getInput(1, 3);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + partnerName + "은(는) 여행의 묘미는 맛있는 음식이라고 생각합니다.");
                        System.out.println("[system] 호감도 +5");
                        player.addAffection(5);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) 일상의 감성을 공유했습니다.");
                        System.out.println("[system] 호감도 변화 없음");
                    }
                    case 3 -> {
                        System.out.println("[system] " + partnerName + "은(는) 먹는 걸 더 중요하게 생각합니다.");
                        System.out.println("[system] 호감도 -5");
                        player.addAffection(-5);
                    }
                }
            }
            case 2 -> {
                System.out.println("👨‍💼 최근 다녀오신 곳이 있으세요?");
                System.out.println("  1. 지방 축제");
                System.out.println("  2. 그냥 일상 탈출");
                System.out.println("  3. 특별히 기억에 남는 여행은 없어요");
                int sub = getInput(1, 3);
                if (sub == 1) {
                    System.out.println("[system] " + partnerName + "은(는) 축제의 분위기를 좋아합니다.");
                    System.out.println("[system] 호감도 +5");
                    player.addAffection(5);
                } else {
                    System.out.println("[system] " + partnerName + "은(는) 고개를 끄덕였습니다.");
                    System.out.println("[system] 호감도 변화 없음");
                }
            }
            case 3 -> {
                System.out.println("👨‍💼 주말에 주로 뭐 하세요?");
                System.out.println("  1. 게임 즐겨해요!");
                System.out.println("  2. 친구들과 같이 가끔");
                System.out.println("  3. 그냥 집에서 쉬어요");
                int sub = getInput(1, 3);
                if (sub == 1) {
                    System.out.println("[system] " + partnerName + "은(는) 공통 취미에 관심을 보입니다.");
                    System.out.println("[system] 호감도 +5");
                    player.addAffection(5);
                } else {
                    System.out.println("[system] " + partnerName + "은(는) 미소를 지었습니다.");
                    System.out.println("[system] 호감도 변화 없음");
                }
            }
        }

        // 돌발 이벤트
        System.out.println("💥[system] 상대의 음식에서 소스가 옷에 튀었다!");
        System.out.println("  1. 괜찮아요. 옷은 더러워질 수도 있는 거잖아요");
        System.out.println("  2. 빨면 되죠");
        System.out.println("  3. 엄청 아끼는 옷인데...");
        input = getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 감동했습니다.");
                System.out.println("[system] 호감도 +8");
                player.addAffection(8);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 안심했습니다.");
                System.out.println("[system] 호감도 변화 없음");
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 당황했습니다.");
                System.out.println("[system] 호감도 -8");
                player.addAffection(-8);
            }
        }

        // 엔딩
        System.out.println("===== Stage2 엔딩 =====");
        if (player.getAffection() < 40) {
            System.out.println("[지인 엔딩] 매너는 있었지만 연애는 없었다.");
        } else {
            System.out.println("[Stage2 통과!] 다음 스테이지로 진입합니다.");
        }
        System.out.println("=======================\n");
    }

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