package util.color;

import com.googlecode.lanterna.TextColor;

import java.util.Map;

import static java.util.Map.entry;

public class SecondManArt {
    // 머리 + 피부 조합 (남 x 난이도)
    public enum CharacterStyle {
        EASY_MAN,
        NORMAL_MAN,
        HARD_MAN
    }

    public static Map<Character, TextColor> getColorMap(CharacterStyle style) {
        switch (style) {
            case EASY_MAN -> {
                return Map.ofEntries(
                        entry('B', new TextColor.RGB(180, 140, 100)), // 밝은 갈색
                        entry('M', new TextColor.RGB(45,35,90)),      // 어두운 남색
                        entry(',', new TextColor.RGB(218,208, 162)), //흰색
                        entry('H', new TextColor.RGB(180,130,210)),  // 연보라
                        entry('S', new TextColor.RGB(140,90,180)),   // 보라


                        // 의상/악세사리 - 노랑, 민트, 밝은 초록, 연두
                        entry('X', new TextColor.RGB(160,140,110)),   // 베이지톤 갈색
                        entry('2', TextColor.ANSI.BLUE_BRIGHT),
                        entry('9', new TextColor.RGB(45,35,90)),
                        entry('s', new TextColor.RGB(255,255,255)),

                        // 기타 중간톤 색상들 섞기
                        entry('5', new TextColor.RGB(190,200,130)),  // 올리브 옅은 초록
                        entry('G', new TextColor.RGB(210,210,160)),  // 밝은 초록
                        entry('i', new TextColor.RGB(240,200,255)),  // 연한 민트톤
                        entry('r', new TextColor.RGB(154,165,203)), //회보라
                        entry(':', new TextColor.RGB(255, 200, 170))
                );
            }

            case NORMAL_MAN -> {
                return Map.ofEntries(
                        entry('B', TextColor.ANSI.MAGENTA),   // 머리
                        entry('M', new TextColor.RGB(160,140,110)),   // 베이지톤 갈색
                        entry(',', new TextColor.RGB(255, 200, 170)),
                        // 어두운 영역 (의상 테두리 등)
                        entry('G', new TextColor.RGB(140,30,60)),    // 짙은 레드와 버건디
                        entry('X', new TextColor.RGB(100,0,80)),     // 어두운 보라
                        entry('s', new TextColor.RGB(255,255,255)),

                        // 피부 근처 명암톤
                        entry('9', new TextColor.RGB(20,90,60)),  // 어두운 초록

                        // 중간톤
                        entry('2', new TextColor.RGB(255,140,160)),  // 생기있는 핑크
                        entry('i', new TextColor.RGB(255,180,80)),   // 연한 주황
                        entry('5', new TextColor.RGB(230,120,150)),  // 다홍+핑크
                        entry('r', new TextColor.RGB(190,200,130)),   // 베이지톤 갈색

                        // 밝은 하이라이트
                        entry(':', new TextColor.RGB(255, 200, 170))
                );
            }
            case HARD_MAN -> {
                return Map.ofEntries(
                        entry('M', new TextColor.RGB(230,120,150)), // 다홍+핑크

                        entry(',', new TextColor.RGB(255, 245, 200)),
                        // 어두운 갈색 / 의상 테두리
                        entry('r', new TextColor.RGB(70,40,20)),      // 진한 갈색
                        entry('X', new TextColor.RGB(45,35,90)),      // 어두운 남색
                        entry('s', new TextColor.RGB(255,255,255)),
                        // 중간톤 초록
                        entry('9', new TextColor.RGB(20,90,60)),      // 어두운 초록
                        entry('2', new TextColor.RGB(255,247,243)),
                        entry('B', new TextColor.RGB(170,230,200)),
                        // 중간톤 파랑
                        entry('i', new TextColor.RGB(255,190,210)),

                        // 밝은 하이라이트 (옅은 갈색/베이지)
                        entry('5', new TextColor.RGB(180,160,130)),   // 밝은 갈색
                        entry('G', new TextColor.RGB(160,140,110)),   // 베이지톤 갈색
                        entry(':', new TextColor.RGB(255, 200, 170))
                );
            }
            default -> throw new IllegalStateException("Unexpected value: " + style);
        }
    }
}
