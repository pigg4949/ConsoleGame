package util.color;

import com.googlecode.lanterna.TextColor;

import java.util.Map;

import static java.util.Map.entry;

public class FirstWomanArt {

    // 머리 + 피부 조합 (여 x 난이도)
    public enum CharacterStyle {
        EASY_WOMAN,
        NORMAL_WOMAN,
        HARD_WOMAN
    }
    public static Map<Character, TextColor> getColorMap(CharacterStyle style) {
        switch (style) {
            case EASY_WOMAN -> {
                return Map.ofEntries(
                        entry('B', new TextColor.RGB(180, 140, 100)), // 밝은 갈색
                        entry('r', new TextColor.RGB(245, 245, 245)), // 밝은 갈색  // 눈썹
                        entry('M', new TextColor.RGB(140,30,60)),    // 짙은 레드와 버건디
                        // 배경
                        entry(',', new TextColor.RGB(255,230,180)),  // 밝은 살구
                        entry('2', new TextColor.RGB(140,90,180)),   // 보라
                        entry('s', new TextColor.RGB(221,193,193)),// 짙은 살색1
                        // 피부색 - 밝은 살구/노란빛 피부
                        entry('9', new TextColor.RGB(255,180,80)),   // 연한 주황
                        // 의상/악세사리 - 노랑, 민트, 밝은 초록, 연두
                        entry('S',TextColor.ANSI.RED_BRIGHT),
                        entry('X', new TextColor.RGB(160,140,110)),
                        entry('G', new TextColor.RGB(70,40,20)),      // 진한 갈색

                        // 기타 중간톤 색상들 섞기
                        entry('5', new TextColor.RGB(190,200,130)),  // 올리브 옅은 초록
                        entry('i', new TextColor.RGB(221,193,193)), // 살색2
                        entry(':', new TextColor.RGB(255,190,210))  // 연한 핑크
                );
            }
            case NORMAL_WOMAN -> {
                return Map.ofEntries(
                        entry('B', TextColor.ANSI.MAGENTA),   // 머리
                        entry('r', new TextColor.RGB(245, 245, 245)),   // 눈썹
                        // 배경
                        entry(',', new TextColor.RGB(255, 200, 170)),
                        // 어두운 영역 (의상 테두리 등)
                        entry('G', new TextColor.RGB(140,30,60)),    // 짙은 레드와 버건디
                        entry('X', new TextColor.RGB(100,0,80)),     // 어두운 보라
                        entry('S', new TextColor.RGB(90,0,60)),      // 짙은 핑크 계열
                        entry('M', new TextColor.RGB(140,90,180)),   // 보라

                        // 피부 근처 명암톤
                        entry(':', new TextColor.RGB(255,190,210)),  // 연한 핑크

                        // 중간톤
                        entry('2', new TextColor.RGB(255,140,160)),  // 생기있는 핑크
                        entry('i', new TextColor.RGB(255,180,80)),   // 연한 주황
                        entry('5', new TextColor.RGB(230,120,150)),  // 다홍+핑크

                        // 밝은 하이라이트
                        entry('s', new TextColor.RGB(255,240,120))  // 노랑
                        //':', new TextColor.RGB(240,200,255)"))  // 라이트 퍼플 하이라이트
                );
            }
            case HARD_WOMAN -> {
                return Map.ofEntries(
                        entry('B', new TextColor.RGB(120,150,40)),
                        entry('r', new TextColor.RGB(245, 245, 245)), // 머리: 어두운 카키
                        entry('M', new TextColor.RGB(190,200,130)),
                        // 배경
                        entry(',', new TextColor.RGB(255, 245, 200)),
                        // 어두운 갈색 / 의상 테두리
                        entry('G', TextColor.ANSI.GREEN),
                        entry('X', new TextColor.RGB(45,35,90)),      // 어두운 남색
                        entry('S', new TextColor.RGB(55,30,75)),      // 짙은 보라

                        // 중간톤 초록
                        entry('9', new TextColor.RGB(20,90,60)),      // 어두운 초록
                        entry('2', new TextColor.RGB(60,120,90)),     // 중간 초록
                        entry('i', new TextColor.RGB(255,140,160)),

                        // 밝은 하이라이트 (옅은 갈색/베이지)
                        entry('5', new TextColor.RGB(180,160,130)),   // 밝은 갈색
                        entry('s', new TextColor.RGB(160,140,110)),   // 베이지톤 갈색
                        entry(':', new TextColor.RGB(255,218,230))  // 연한 분홍톤
                );
            }
            default -> throw new IllegalStateException("Unexpected value: " + style);
        }
    }
}
