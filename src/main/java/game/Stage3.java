package game;

import java.util.Random;
import java.util.Scanner;

public class Stage3 {
    private Player player;
    private Scanner sc;
    private GameTools GT = new GameTools();
    private DBHandler DB = new DBHandler();

    public Stage3(Player player) {
        this.player = player;
    }

    public void play() {
        System.out.println("\n[Stage3] 공원, 마지막 장소. 여운 있는 분위기\n");
        if (player.getGender().equals("남")) {
            playMale();
        } else {
            playFemale();
        }
    }

    private void playMale() {
        Random rand = new Random();
        int input;

        // Q1
        System.out.println(this.player.getPartnerName() + ": \"오늘 너무 많이 걸은 것 같아요. 잠깐 저기 벤치에 앉아서 쉬는 게 어떨까요?\"");
        System.out.println("1. 좋아요. 마침 저도 잠깐 쉬고 싶었어요.");
        System.out.println("2. 그럼요. 벤치에 앉아서 노을이나 같이 볼까요?");
        System.out.println("3. 괜찮으세요? 많이 피곤하신가 봐요.");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 안도한 듯 미소 짓고 벤치 쪽으로 걸음을 옮긴다. 호감도 +5");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 눈을 살짝 크게 뜨며 “좋죠~” 하고 작게 웃는다. 호감도 +10");
                player.addAffection(10);
            }
            case 3 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 약간 당황하면서도 “아뇨, 그냥 잠깐…….”이라며 고개를 끄덕인다. 호감도 +0");
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // Q2
        System.out.println(this.player.getPartnerName() + ": \"바람도 선선하니 좋네요……. 공원 같은 데 자주 오시나요?\"");
        System.out.println("1. 네, 마음이 차분해져서 좋아해요. 평소에 혼자 산책도 자주 하고요.");
        System.out.println("2. 가끔은 오죠. 오늘처럼 즐거웠던 날엔 누군가와 같이 오면 더 좋겠단 생각이 들기도 해요.");
        System.out.println("3. 잘 안 와요. 솔직히 공원은 좀 지루해서요.");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 조용한 감성에 공감하며 따뜻하게 미소 짓는다. 호감도 +5");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 의미심장한 눈빛을 보내며 고개를 끄덕인다. 호감도 +10");
                player.addAffection(10);
            }
            case 3 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 고개를 끄덕이지만 약간은 거리감을 느낀다. 호감도 -5");
                player.addAffection(-5);
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // 돌발상황: 길고양이 습격
        System.out.println("[돌발상황] 갑자기 덤불에서 길고양이가 달려나와 " + this.player.getPartnerName() + "에게 뛰어듭니다!");
        System.out.println(this.player.getPartnerName() + ": \"꺄악! 뭐야, 고양이……?!\"");
        System.out.println("1. “괜찮으세요? 잠깐만요!” (즉시 앞으로 나서며 고양이를 잡아낸다)");
        System.out.println("2. “고양이였네요, 다친 데는 없으시죠?” (거리를 두고 안부 확인)");
        System.out.println("3. “어? 뭐야……. 길고양이였나 봐요. 놀랐네.” (무신경한 반응)");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 안심한 듯 작게 웃으며 “휴우, 감사해요……. 진짜 놀랐어요.” 호감도 +10");
                player.addAffection(10);
            }
            case 2 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 놀란 숨을 고르며 “네, 괜찮아요…….” 호감도 +5");
                player.addAffection(5);
            }
            case 3 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 표정이 굳어지며 말이 없어진다. 호감도 -10");
                player.addAffection(-10);
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // Q3
        System.out.println(this.player.getPartnerName() + ": \"혹시… 사랑이 오래 지속되기 위해 가장 필요한 게 있다면, 무엇일 거라고 생각하세요?\"");
        System.out.println("1. 서로 솔직해지는 거요. 감정 숨기면 결국 멀어지게 되니까.");
        System.out.println("2. 서로에게 여유를 주는 거 아닐까요? 사람 사이엔 거리도 필요하니까.");
        System.out.println("3. 매일 노력하는 거요. 사랑은 가만히 두면 식는 것 같아요.");
        input = GT.getInput(1, 3);
        int branch = input;
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 잠시 조용히 있다가 “……그 말, 되게 와닿네요.”라며 고개를 끄덕인다. 호감도 +10");
                player.addAffection(10);
            }
            case 2 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 입꼬리를 살짝 올리며 “제일 갖기 어려운 게 그런 여유인 것 같아요.”라며 웃는다. 호감도 -5");
                player.addAffection(-5);
            }
            case 3 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 약간 놀란 듯 눈을 깜빡이며 “되게 성실하시네요…… 의외예요.”라고 말한다. 호감도 +0");
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // Q4 분기
        switch (branch) {
            case 1 -> {
                System.out.println(this.player.getPartnerName() + ": “혹시 지금까지 누군가에게 정말 솔직하게 마음을 털어놓은 적 있으세요?”");
                System.out.println("1. 네, 단 한 번. 그래서 아직도 기억에 남아요.");
                System.out.println("2. 그렇게까지 털어놓을 사람을 못 만난 것 같아요. 그래도… 언젠간 그럴 상대도 나타날 거라 믿어요.");
                System.out.println("3. 솔직해지면 상처받을까봐 어쩐지 그런 건 피하게 되더라고요.");
                input = GT.getInput(1, 3);
                switch (input) {
                    case 1 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 고개를 끄덕이며 말을 아낀다. 호감도 -10");
                        player.addAffection(-10);
                    }
                    case 2 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 고개를 갸웃하다 뒤늦게 얼굴을 확 붉히며 “……저도요.” 호감도 +10");
                        player.addAffection(10);
                    }
                    case 3 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 표정이 잠시 굳는다. 호감도 -5");
                        player.addAffection(-5);
                    }
                }
            }
            case 2 -> {
                System.out.println(this.player.getPartnerName() + ": “상대가 연락이 잘 안 돼도 이해할 수 있는 편이세요?”");
                System.out.println("1. 처음엔 물론 걱정도 되겠지만, 그것까지 감수하고 믿고 기다리는 게 맞다고 생각해요.");
                System.out.println("2. 기분이 좋진 않겠지만, 서로 바쁠 수도 있으니까요. 약간 각자 사정을 봐 가며 연락 주기를 조정해야겠죠.");
                System.out.println("3. 연락 안 되면 불안해서 바로바로 물어보는 편이에요. 연인 관계에선 서로의 마음에 솔직해야 한다고 생각하거든요.");
                input = GT.getInput(1, 3);
                switch (input) {
                    case 1 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 살짝 안도의 미소를 지으며 고개를 끄덕인다. 호감도 +0");
                    }
                    case 2 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 현실적인 반응에 고개를 끄덕인다. 호감도 -5");
                        player.addAffection(-5);
                    }
                    case 3 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 살짝 감동한 듯한 표정을 짓는다. 호감도 +10");
                        player.addAffection(10);
                    }
                }
            }
            case 3 -> {
                System.out.println(this.player.getPartnerName() + ": “매일 노력하는 사랑이라면 끝내는 지칠 수도 있지 않을까요?”");
                System.out.println("1. 그럴 수도 있다고 생각해요. 그래도 그 사람이면 할 수 있다고 믿는 거죠.");
                System.out.println("2. 그래서 저는 가벼운 관계가 더 맞는 편인 것 같아요. 적당히 마음 써 가며 가늘고 길게 가는 게 좋더라고요.");
                System.out.println("3. 노력은 당연한 거니까요. 오히려 기대돼요. 함께할 미래가 어떤 모습일지…….");
                input = GT.getInput(1, 3);
                switch (input) {
                    case 1 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 눈을 크게 뜨며 감동한 듯 고개를 끄덕인다. 호감도 +0");
                    }
                    case 2 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) 눈을 살짝 내리깔며 “그럴 수도 있겠네요.” 호감도 -10");
                        player.addAffection(-10);
                    }
                    case 3 -> {
                        System.out.println("[system] " + this.player.getPartnerName() + "은(는) “되게 진지하시네요.”라며 미소 짓는다. 호감도 +10");
                        player.addAffection(10);
                    }
                }
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // Q5
        System.out.println(this.player.getPartnerName() + ": “마지막으로… 오늘 하루, 어떠셨어요?”");
        System.out.println("1. 오늘 함께해서 정말 좋았어요." + this.player.getPartnerName() +  "씨랑 다시 이런 하루를 보내고 싶어요.");
        System.out.println("2. 생각보다 즐거웠네요. 나쁘지 않았어요.");
        System.out.println("3. 뭔가 어색했지만… 그래도 기억엔 남을 것 같아요.");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 얼굴을 붉히며 웃는다. 호감도 +5");
                player.addAffection(5);
            }
            case 2 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 조용히 웃으며 “정말요?”라고 되묻는다. 호감도 +0");
            }
            case 3 -> {
                System.out.println("[system] " + this.player.getPartnerName() + "은(는) 무표정하게 고개를 끄덕인다. 호감도 -5");
                player.addAffection(-5);
            }
        }
        System.out.printf("최종 호감도: %d\n\n", player.getAffection());

        // 최종 엔딩
        System.out.println("===== [최종 엔딩] =====");
        int aff = player.getAffection();
        if (aff < 20) {
            System.out.println("실패 엔딩: 관계가 이어지지 않습니다.");
        } else if (aff < 40) {
            System.out.println("지인 엔딩: 매너는 있었지만 연애는 없었다.");
        } else if (aff < 70) {
            System.out.println("남사친 엔딩: 좋은 친구로 남고 싶어요.");
        } else {
            System.out.println("남친 엔딩: 해피 엔딩! 다음 주말에 또 만날래요?");
            player.setClearStage(3);
            DB.updatePlayer(player.getPlayerName(), player.getGender(),player.getAffection(), player.getPartnerName(), player.getClearStage());
        }
        System.out.println("=========================\n");
    }

    private void playFemale() {
        Random rand = new Random();
        int input;

        // Q1
        System.out.println("[system]️ 식사를 마친 후 남성이 집까지 데려다 주겠다고 하여 차를 타고 이동한다.");
        System.out.println("[system]️ 차 내부가 업류 서류로 지저분하다.\n");
        System.out.println(this.player.getPartnerName() + ": 죄송해요 차 안이 너무 지저분하죠..? 미리 미리 정리를 했어야 했는데 요즘 일이 바빠서 정리할 틈이 없었네요…");
        System.out.println("1. 바쁠때는 어쩔 수 없죠~ 저도 그렇거든요");
        System.out.println("2. 제 화장대에 비하면 이정도는 뭐 ㅋㅋㅋㅋㅋ");
        System.out.println("3. 아 국산차라 기대도 안했어요");

        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                player.addAffection(5);
                System.out.println("[system]️ 상대방이 민망하지 않게 잘 말한 것 같다! (호감도+5)");
            }
            case 2 -> System.out.println("[system] 친밀도 상승 / 친구로 남지 않도록 주의하세요 (호감도+0)");
            case 3 -> {
                player.addAffection(-30);
                System.out.println("[system] (끼이이이익) 남자가 급하게 차를 세운다. (호감도-30)");
                System.out.println(this.player.getPartnerName() + ": 야!! 내려, 버스타고 가!!");
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // Q2
        System.out.println("[system]️ 택시와 오토바이의 콜라보레이션 끼어들기로 인해 접촉 사고 발생 위험!");
        System.out.println(this.player.getPartnerName() + ": 많이 놀랐죠? 괜찮아요??");
        System.out.println("1. 저는 괜찮아요! 다른 사람이었으면 사고 났을텐데 순발력이 좋으시네요!");
        System.out.println("2. 한문철 각?");
        System.out.println("3. 자리 바꿔봐요, 저런 @#$들 내가 오늘 도로에서 지워버리고 지옥간다, 말리지마요");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                player.addAffection(5);
                System.out.println("[system] 긍정 마인드 어필 성공 (호감도+5)");
            }
            case 2 -> System.out.println("[system] 친밀도 상승 / 친구로 남지 않도록 주의하세요 (호감도+0)");
            case 3 -> {
                if (rand.nextDouble() < 0.3) {
                    player.addAffection(30);
                    System.out.println("[system] [반전매력💕] 발동 호감도 대폭 상승 (호감도+30)");
                } else {
                    player.addAffection(-5);
                    System.out.println("[system]" + this.player.getPartnerName() + "이(가) 데려다 주는걸 후회합니다. (호감도-5)");
                }
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // Q3
        System.out.println("[system]️ 접촉사고는 피했지만 이야기의 흐름이 끊겨버렸다…");
        System.out.println(this.player.getPartnerName() + ": 혹시 좋아하는 음악 있어요?? 저는 밴드 장르 좋아해요!");
        System.out.println("1. 🫢저도 그거 좋아해요!! 우리 그거 들으면서 가요!");
        System.out.println("2. 밴드 음악은 잘 안들어봐서 모르는데 신나는 음악을 좋아하시나봐요.");
        System.out.println("3. 전 시끄러운거 안좋아해요 그냥 조용한게 좋아요");

        input = GT.getInput(1, 3);
        switch (input) {
            case 1 ->{
                player.addAffection(5);
                System.out.println("[system] 공감대 형성! (호감도+5)");
            }
            case 2 ->  System.out.println("[system] 이야기의 흐름이 끊기지 않게 주의하세요 (호감도+0)");
            case 3 -> {
                player.addAffection(-5);
                System.out.println("[system] 상대방이 머쓱 (호감도-5)");
            }
        }
        System.out.printf("현재 호감도: %d\n\n", player.getAffection());

        // Q4 분기
        System.out.println("[system]️ 도착까지 얼마 남지 않았다! 이젠 승부수를 던져야 합니다!");
        System.out.println(this.player.getPartnerName() + ": 거의 다와가는것같은데 이 근처 맞죠??");
        System.out.println("1. 네, 여기 맞아요. 오늘 정말 감사했어요! 덕분에 즐거웠어요");
        System.out.println("2. 네, 오늘 편하게 해주셔서 감사했어요. 사실 긴장을 많이 했는데 덕분에 즐거웠어요.");
        System.out.println("3. 네, 맞긴 한데.. 조금만 천천히 가주실 수 있어요? 사실 좀 더 이야기 나누고 싶어서요.");
        input = GT.getInput(1, 3);
        switch (input) {
            case 1 -> {
                System.out.println(this.player.getPartnerName() + ": 저도 같은 마음이에요! 다음에 같이 영화보러 가는 거 어때요? 좋아하는 장르 있어요??");
                System.out.println("1. 로맨스나 코미디 좋아해요!");
                System.out.println("2. 저 좀 잔인하고 무서운 영화 좋아해요!");
                int sub = GT.getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        player.addAffection(5);
                        System.out.println("[system] 취향 확인! 상대방의 고민이 줄었다. (호감도+5)");
                    }
                    case 2 -> {
                        player.addAffection(-5);
                        System.out.println("[system] 호불호가 갈릴 듯 하다 (호감도-5)");
                    }
                }
            }
            case 2 -> {
                System.out.println(this.player.getPartnerName() + ": 오늘 어땠는지 솔직하게 얘기해줄 수 있어요?");
                System.out.println("1. 저희 잘 맞는 것 같아요! 나눈 대화들이 너무 좋았어요.");
                System.out.println("2. 처음엔 어색했는데, 더 알아보고 싶은 마음이에요");
                int sub = GT.getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        player.addAffection(5);
                        System.out.println("[system] 진솔한 소통 (호감도+5)");
                    }
                    case 2 -> {
                        player.addAffection(-5);
                        System.out.println("[system] 미묘한 실망감을 느낀 듯 하다. (호감도-5)");
                    }
                }
            }
            case 3 -> {
                System.out.println(this.player.getPartnerName() + ": 그럼 조금 더 천천히 갈게요. OO씨의 이상형은 어떤 사람이에요?");
                System.out.println("1. 따뜻하고 배려심 많은 사람이 좋아요, 저도 그렇게 되려고 노력하고 있거든요.");
                System.out.println("2. 이상형은 차은우! 세상에나 너무 완벽하지 않나요?");
                int sub = GT.getInput(1, 2);
                switch (sub) {
                    case 1 -> {
                        player.addAffection(5);
                        System.out.println("[system] 상대방이 당신의 성격에 끌립니다. (호감도+5)");
                    }
                    case 2 -> {
                        player.addAffection(-5);
                        System.out.println("[system] 남자의 머릿속에 후회가 밀려온다. (호감도-5)");
                    }
                }
            }
        }
        System.out.printf("최종 호감도: %d\n\n", player.getAffection());

        // 엔딩
        System.out.println("===== [최종 엔딩] =====");
        int aff = player.getAffection();
        if (aff < 20) {
            System.out.println("실패 엔딩: 관계가 이어지지 않습니다.");
        } else if (aff < 40) {
            System.out.println("지인 엔딩: 매너는 있었지만 연애는 없었다.");
        } else if (aff < 70) {
            System.out.println("여사친 엔딩: 좋은 친구로 남고 싶어요.");
        } else {
            System.out.println("여친 엔딩: 해피 엔딩! 다음 주말에 또 만날래요?");
            player.setClearStage(3);
            DB.updatePlayer(player.getPlayerName(), player.getGender(),player.getAffection(), player.getPartnerName(), player.getClearStage());
        }
        System.out.println("=========================\n");
    }
}