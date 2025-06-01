package game;

import java.util.Scanner;

public class Stage2 {
    private Player player;
    private Scanner sc;
    private String partnerName;
    private GameTools GT = new GameTools();

    public Stage2(Player player) {
        this.player = player;
    }

    public Player play() {
        System.out.println("\n[Stage2] 두근두근 2번째 데이트\n");
        partnerName = player.getPartnerName();
        if (player.getGender().equals("남")) {
            playMale();
        } else {
            playFemale();
        }
        return player;
    }

    // 여성 플레이어 부분 대본 약간 수정 필요하지만.....

    private void playMale() {
        int input;

        System.out.println("첫 번째 만남 이후 주말 영화 데이트,,,\n");

        System.out.println("💃 Q1. 저 영화 좋아하긴 하는데 혼자도 잘 봐요! 혹시 혼영 가능하세요?");
        System.out.println("  1. 혼영 진짜 좋아해요. 혼자 영화관 한 줄 통째로 예매함");
        System.out.println("  2. 저는 무조건 둘이 봐야죠. 팝콘 핑계로 손 잡아야 하니까");
        System.out.println("  3. 영화관 자체가 무서워요. 광고에서 감동받아 운 적 있음\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) '이 사람 자기랑 영화도 나눠 못 보는 사람일지도…?'라는 생각에 혼란을 느꼈습니다.");
                System.out.println("[system] 호감도 +5 자기애에는 약하지만 감명받았습니다.\n");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 갑작스러운 스킨십 언급에 멘탈이 살짝 날아갔습니다.");
                System.out.println("[system] 호감도가 +10 되었지만 신중도가 -15 되었습니다.\n");
                player.addAffection(10);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 감수성을 이해할 수 없어... 오히려 좋아했습니다.");
                System.out.println("[system] 호감도 +8 이해불가 호감도 보너스가 적용되었습니다.\n");
                player.addAffection(8);
            }
        }

        System.out.println("💃 Q2. 팝콘은 단짠 조합이 국룰 아닌가요?");
        System.out.println("  1. 오히려 카라멜만! 인생은 단맛만 있으면 돼요");
        System.out.println("  2. 전 소금팝콘만 먹어요. 단 건 별로…");
        System.out.println("  3. 팝콘은 손 잡는 핑계일 뿐이죠\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {

                System.out.println("\n[system] 민초 질문이 튀어나왔습니다.");
                System.out.println("💃 Q2-1. 혹시 민초 좋아하세요?");
                System.out.println("  1. 완전 좋아하죠. 치약맛이라면서요 ㅋㅋ");
                System.out.println("  2. 민초요? 사람 음식 맞나요?\n");

                int sub = GT.getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 반민초협회 부회장입니다.");
                        System.out.println("[system] 호감도 -50\n");
                        player.addAffection(-50);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) 당신을 소울메이트 후보로 등록했습니다.");
                        System.out.println("[system] 호감도 +30 민초혐오공감치 +999");
                        System.out.println("[system] 비밀 선택지 ‘민초 지옥 탈출 커플 루트’가 열렸습니다.\n");
                        player.addAffection(30);

                        // 바로 Stage3으로 진입
                        Stage3 stage3 = new Stage3(player);
                        stage3.play();
                        return;
                    }
                }
            }
            case 2 -> {
                System.out.println("\n💃 Q2-1. 그럼… 연애도 약간 짠맛 있어야 한다고 생각하세요?");
                System.out.println("  1. 네. 늘 달기만 하면 언젠간 질려요");
                System.out.println("  2. 아뇨, 연애는 무조건 달콤해야죠. 현실에서까지 고생하고 싶진 않아요\n");
                int sub = GT.getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + partnerName + "은(는) 이 발언에 지나치게 공감했습니다");
                        System.out.println("[system] 호감도 +18 현실주의 커플관 공감도 상승\n");

                        player.addAffection(18);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) '이 사람 도피형인가…?'라고 분석했습니다.");
                        System.out.println("[system] 호감도 +3 위험감지 +1\n");
                        player.addAffection(3);
                    }
                    case 3 -> {
                        System.out.println("[system] " + partnerName + "은(는) 고민에 빠졌습니다.");
                        System.out.println("[system] 호감도 변화 없음\n");
                    }
                }
            }
            case 3 -> {
                System.out.println("💃Q2-1. 그럼… 오늘은 팝콘이 핑계인가요, 진심인가요?");
                System.out.println("  1. 진심이죠. 팝콘 말고도 같이 먹고 싶은 게 많아요");
                System.out.println("  2. 핑계죠. 손잡고 싶어서 무슨 수를 써서라도 샀어요\n");
                int sub = GT.getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + partnerName + "은(는) 얼굴 근육이 움직이지 않았지만 심장이 0.5초 빨라졌습니다.");
                        System.out.println("[system] 호감도 +20 야식권유도 +1\n");
                        player.addAffection(20);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) 생각보다 더 진심인 당신에게 당황 + 흥미를 느꼈습니다.");
                        System.out.println("[system] 호감도 +12 주의력 집중도 +15\n");
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
        System.out.println("  3. 영화는 기억 안 나고" + partnerName + " 씨 옆모습만 봤어요\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 자신이 주인공이라니 충격에 빠졌습니다.");
                System.out.println("[system] 호감도 +12 현실도피형 호감도 상승이 감지되었습니다.\n");
                player.addAffection(12);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 인간미에 감동받았습니다.");
                System.out.println("[system] 호감도 +15 몰래 우는 타입 = 내 사람 가능성 ↑\n");
                player.addAffection(15);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 정지 후, 재부팅 중입니다.");
                System.out.println("[system] 호감도 +20 치명타 판정\n");
                player.addAffection(20);
            }
        }

        // Q4
        System.out.println("[커피 마시며]");
        System.out.println("💃 Q4. 데이트라면 어떤 스타일 선호하세요?");
        System.out.println("  1. 감성카페 돌기 / 전시회 구경");
        System.out.println("  2. 볼링 / 방탈출 / 액티비티");
        System.out.println("  3. 집콕 / 넷플릭스 / 배달 시켜먹기\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + " ‘갤러리-인증커플’의 미래를 꿈꾸기 시작했습니다.");
                System.out.println("[system] 호감도 +10 함께 걸을 감성 루트가 생성되었습니다.\n");
                player.addAffection(10);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 체력이 안 되지만 잠깐 설렜습니다.");
                System.out.println("[system] 호감도 +5 진심은 좋지만 관절은 안 좋습니다.\n");
                player.addAffection(5);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 넷플릭스가 19금인지 영화감상인지 고민하기 시작했습니다.");
                System.out.println("[system] 호감도 -10 긴급 방어모드 진입\n");
                player.addAffection(-10);
            }
        }

        // Q5
        System.out.println("[카페 나가기 전]");
        System.out.println("💃 Q5.오늘은 진짜 재밌었어요. 집 가는 길 외롭겠죠?");
        System.out.println("  1. 외롭긴요." + partnerName + "씨 사진으로 하루 종일 생각할 듯");
        System.out.println("  2. 외롭진 않아도 좀 아쉽겠죠");
        System.out.println("  3. 집 가는 길에 영화 다시 돌이켜보면서 혼자 몰입 예정이에요\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 갤러리에 저장된 자신의 얼굴을 상상하며 살짝 무서워졌습니다");
                System.out.println("[system] 호감도 +5 스토커 감지율 +20\n");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 감정선을 안전하게 내려놓았습니다.");
                System.out.println("[system] 호감도 +8\n");
                player.addAffection(8);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) \"와… 이 사람... 엔딩크레딧도 같이 보겠네\" 라고 생각했습니다.");
                System.out.println("[system] 호감도 +13\n");
                player.addAffection(13);
            }
        }

        // 돌발 이벤트
        System.out.println("💥 집에 가는 길! 갑자기 소나기가 내립니다!");
        System.out.println("  1. 우산 사올게요. 거기서 잠깐만 기다려요");
        System.out.println("  2. 그냥 뛰죠! 영화처럼!");
        System.out.println("  3. 헐… 젖으면 안 되는데… 머리 감았단 말이에요\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 배려심에 감동합니다.");
                System.out.println("[system] 호감도 +20 매너남 칭호 획득!\n");

                player.addAffection(20);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 웃었지만 머릿속에 드라이기 계산을 시작했습니다.");
                System.out.println("[system] 호감도 +10 감기확률 +50% \n");

                player.addAffection(10);
            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) ‘이 사람 나보다 머리가 중요하구나’라고 인식했습니다.");
                System.out.println("[system] 호감도 -15\n");
                player.addAffection(-15);
            }
        }

        System.out.println("===== Stage2 엔딩 =====");
        if (player.getAffection() < 40) {
            System.out.println("[지인 엔딩] 매너는 있었지만 연애는 없었다.");
            System.out.println("얻은 호감도 : " + player.getAffection());
        } else {
            System.out.println("[Stage2 통과!] 다음 스테이지로 진입합니다.");
            System.out.println("얻은 호감도 : " + player.getAffection());

        }
        System.out.println("=========================================================\n");
    }

    private void playFemale() {
        int input;

        System.out.println("카페 소개팅 이후 주말 레스토랑 데이터, 상대가 먼저 도착해 기다리고 있다. \n 남성이 주문한 음식이 타이밍 좋게 나오고 대화를 시작한다.");

        // Q1
        System.out.println("👨‍💼 Q1. 어떤 음식을 좋아하시는지 몰라서 긴장되네요. 주문한 메뉴들 괜찮으세요?");
        System.out.println("  1. 제 취향에 맞는 음식 잘 골라주신 것 같아요~! 저희 입맛이 비슷한가봐요!");
        System.out.println("  2. 가리는 음식은 없어서 다 괜찮아요");
        System.out.println("  3. 향이 강한 음식을 싫어해서, 좀 거부감이 드네요;;\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 취향이 는 부분을 찾았다 출발이 좋다.");
                System.out.println("[system] 호감도 +5\n");

                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 편안해 합니다.");
                System.out.println("[system] 호감도 변화 없음\n");

            }
            case 3 -> {
                System.out.println("[system] 벌써부터 삐그덕 " + partnerName + "은(는) 곤란해 합니다.");
                System.out.println("[system] 호감도 -5\n");

                player.addAffection(-5);
            }
        }

        // Q2
        System.out.println("👨‍💼 Q2. 가방에 달린 건 여행 기념품이에요? 여행 좋아하시나요?");
        System.out.println("  1. 여행을 굉장히 좋아해요, 떠나기 전 설렘이 좋아요");
        System.out.println("  2. 그냥 가끔 답답할 때 다녀와요");
        System.out.println("  3. 여행은 피곤해서 별로 안 좋아해요\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("👨‍💼 여행 계획의 설레임 저도 좋아해요! 특히 여행지에서 맛집 찾았을때 엄청 기분이 좋잖아요?!");
                System.out.println("  1. 저도 여행지 맛집은 꼭꼭 찾아다녀요! 식도락 여행의 묘미를 아시네여 ㅋㅋㅋ");
                System.out.println("  2. 꼭 맛집을 찾는건 아니지만 어떤 기분인지는 저도 알것같네요");
                System.out.println("  3. 저는 관광지 위주, 사진 잔뜩 찍어야해요, 남는 건 사진이니까요.\n");
                int sub = GT.getInput(1, 3);
                switch (sub) {
                    case 1 -> {
                        System.out.println("[system] " + partnerName + "은(는) 여행의 묘미는 맛있는 음식이라고 생각합니다.");
                        System.out.println("[system] 호감도 +5\n");

                        player.addAffection(5);
                    }
                    case 2 -> {
                        System.out.println("[system] " + partnerName + "은(는) 일상의 감성을 공유했습니다.");
                        System.out.println("[system] 호감도 변화 없음\n");

                    }
                    case 3 -> {
                        System.out.println("[system] " + partnerName + "은(는) 먹는 걸 더 중요하게 생각합니다.");
                        System.out.println("[system] 호감도 -5\n");

                        player.addAffection(-5);
                    }
                }
            }
            case 2 -> {
                System.out.println("👨‍💼 여행을 싫어하시는건 아닌가보네요, 혹시 최근에 다녀오신 곳 있어요??");
                System.out.println("  1. 지방 축제에 갔었는데 기대 이상이었어요. 축제에 맛있는것도 많더라구요.");
                System.out.println("  2.  그냥 일상에서 벗어나는 것 자체가 힐링이 되더라구요.");
                System.out.println("  3. 특별히 기억에 남는 여행은 없었네요.....\n");
                int sub = GT.getInput(1, 3);
                if (sub == 1) {
                    System.out.println("[system] " + partnerName + "은(는) 축제의 분위기를 좋아합니다.");
                    System.out.println("[system] 호감도 +5\n");

                    player.addAffection(5);
                } else {
                    System.out.println("[system] " + partnerName + "은(는) 고개를 끄덕였습니다.");
                    System.out.println("[system] 호감도 변화 없음\n");

                }
            }
            case 3 -> {
                System.out.println("👨‍💼 주말에 주로 뭐 하세요?");
                System.out.println("  1. 게임 즐겨해요!");
                System.out.println("  2. 친구들과 같이 가끔 게임하는 정도?");
                System.out.println("  3. 그냥 집에서 쉬어요\n");
                int sub = GT.getInput(1, 3);
                if (sub == 1) {
                    System.out.println("[system] " + partnerName + "은(는) 공통 취미에 관심을 보입니다.");
                    System.out.println("[system] 호감도 +5\n");

                    player.addAffection(5);
                } else {
                    System.out.println("[system] " + partnerName + "은(는) 미소를 지었습니다.");
                    System.out.println("[system] 호감도 변화 없음\n");

                }
            }
        }

        // 돌발 이벤트
        System.out.println("💥[system] 상대의 음식에서 소스가 옷에 튀었다!");
        System.out.println("  1. 괜찮아요. 옷은 더러워질 수도 있는 거잖아요");
        System.out.println("  2. 빨면 되죠");
        System.out.println("  3. 엄청 아끼는 옷인데...\n");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + partnerName + "은(는) 감동했습니다.");
                System.out.println("[system] 호감도 +8\n");

                player.addAffection(8);
            }
            case 2 -> {
                System.out.println("[system] " + partnerName + "은(는) 안심했습니다.");
                System.out.println("[system] 호감도 변화 없음\n");

            }
            case 3 -> {
                System.out.println("[system] " + partnerName + "은(는) 미안하지만 조금 띠꺼워 합니다.");
                System.out.println("[system] 호감도 -8\n");

                player.addAffection(-8);
            }
        }

        // 엔딩
        System.out.println("===== Stage2 엔딩 =====");
        if (player.getAffection() < 40) {
            System.out.println("[지인 엔딩] 매너는 있었지만 연애는 없었다.");
            System.out.println("호감도 : " + player.getAffection());
        } else {
            System.out.println("[Stage2 통과!] 다음 스테이지로 진입합니다.");
            System.out.println("호감도 : " + player.getAffection());
        }
        System.out.println("=========================================================\n");
    }
}
