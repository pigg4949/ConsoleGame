package util.color;

import com.googlecode.lanterna.TextColor;

import java.util.Map;

import static java.util.Map.entry;

public class AccidentArt {
    public enum CharacterStyle {
        EASY_MAN,
        NORMAL_MAN,
        HARD_MAN,
        MINCHO,
        HORANG
    }

    public static Map<Character, TextColor> getColorMap(AccidentArt.CharacterStyle style) {
        switch (style) {
            case EASY_MAN -> {
                return Map.ofEntries(
                        entry('B', new TextColor.RGB(180, 140, 100)), // 밝은 갈색
                        entry('M', new TextColor.RGB(45,35,90)),      // 어두운 남색

                        entry(',', new TextColor.RGB(245, 245, 245)), //흰색
                        entry('H', new TextColor.RGB(180,130,210)),  // 연보라
                        entry('2', new TextColor.RGB(140,90,180)),   // 보라

                        // 피부색 - 밝은 살구/노란빛 피부
                        entry('9', new TextColor.RGB(255,230,180)),  // 밝은 살구

                        // 의상/악세사리 - 노랑, 민트, 밝은 초록, 연두
                        entry('G', new TextColor.RGB(140,210,120)),  // 밝은 초록
                        entry('X', TextColor.ANSI.BLUE_BRIGHT),
                        entry('s', new TextColor.RGB(255,255,255)),

                        // 기타 중간톤 색상들 섞기
                        entry('5', new TextColor.RGB(190,200,130)),  // 올리브 옅은 초록
                        entry('r', new TextColor.RGB(210,210,160)),  // 연한 베이지
                        entry('i', new TextColor.RGB(170,230,200)),  // 연한 민트톤

                        entry(':', new TextColor.RGB(255, 200, 170))
                );
            }

            case HORANG -> {
                return Map.ofEntries(
                        entry('B', TextColor.ANSI.MAGENTA),
                        entry('d', new TextColor.RGB(160,140,110)),   // 베이지톤 갈색
                        entry('p', new TextColor.RGB(180, 140, 100)), // 밝은 갈색
                        entry(',', new TextColor.RGB(255, 200, 170)),
                        entry('_', new TextColor.RGB(255,230,180)),  // 밝은 살구
                        entry('"', new TextColor.RGB(255,130,0)),
                        entry('.', new TextColor.RGB(210,210,160)),  // 연한 베이지
                        entry('`', new TextColor.RGB(140,30,60)),
                        entry('q', TextColor.ANSI.YELLOW),     // 어두운 보라
                        entry(';', new TextColor.RGB(90,0,60)),      // 짙은 핑크 계열
                        entry('-', new TextColor.RGB(255,255,255)),
                        entry('n', TextColor.ANSI.RED_BRIGHT),
                        entry('2', TextColor.ANSI.RED),
                        entry('9', TextColor.ANSI.YELLOW_BRIGHT),
                        entry('8', new TextColor.RGB(255,180,80)),   // 연한 주황
                        entry('6', new TextColor.RGB(230,120,150)),  // 다홍+핑크

                        // 밝은 하이라이트
                        entry('+', new TextColor.RGB(240,200,255)),
                        entry(':', new TextColor.RGB(255, 200, 170)),
                        entry('b', new TextColor.RGB(255, 182, 182)),
                        entry('j', new TextColor.RGB(170,230,200))
                );
            }
            case MINCHO -> {
                return Map.ofEntries(
                        entry('B', new TextColor.RGB(120,150,40)),   // 머리: 어두운 카키
                        entry('M', new TextColor.RGB(230,120,150)), // 다홍+핑크

                        entry(',', new TextColor.RGB(255, 245, 200)),
                        // 어두운 갈색 / 의상 테두리
                        entry('2', new TextColor.RGB(70,40,20)),      // 진한 갈색
                        entry('X', new TextColor.RGB(45,35,90)),      // 어두운 남색
                        entry('s', new TextColor.RGB(255,255,255)),
                        // 중간톤 초록
                        entry('9', new TextColor.RGB(20,90,60)),      // 어두운 초록
                        entry('i', new TextColor.RGB(170,230,200)),
                        // 중간톤 파랑
                        entry('G', new TextColor.RGB(255,190,210)),

                        // 밝은 하이라이트 (옅은 갈색/베이지)
                        entry('5', new TextColor.RGB(180,160,130)),   // 밝은 갈색
                        entry('r', new TextColor.RGB(160,140,110)),   // 베이지톤 갈색
                        entry(':', new TextColor.RGB(255, 200, 170)),
                        entry('S', new TextColor.RGB(190,200,130))  // 올리브 옅은 초록

                );
            }
            default -> throw new IllegalStateException("Unexpected value: " + style);
        }
    }
}
