package util;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

// 리소스 작명 규칙
// 첫 대문자는 npc 성별, 즉 플레이어 성별과는 반대.
// start, higher, final 순으로 1~3 단계 기본 배경음
// pointUp/Down은 선택지 좋은/틀린 거 구분, good은 변경 없음


public class SoundUtil {
    private static MediaPlayer bgmPlayer;
    private static String currentBGM;
    private static double currentPosition = 0.0; // 초 단위
    private static double bgmVolume = 0.5; // 기본 볼륨 (0.0 ~ 1.0)

    static {
        new JFXPanel(); // JavaFX 초기화
    }

    // 🎵 BGM 재생 (무한 반복)
    public static void playBGM(String fileName) {
        if (currentBGM != null && currentBGM.equals(fileName) && bgmPlayer != null) {
            // 재생 중이 아니면 이어서 재생
            if (bgmPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
                bgmPlayer.play();
            }
            return;
        }

        stopBGM(); // 이전 BGM 종료

        URL resource = SoundUtil.class.getResource("/sounds/" + fileName);
        if (resource == null) {
            System.err.println("BGM 파일 없음: " + fileName);
            return;
        }

        Media media = new Media(resource.toString());
        bgmPlayer = new MediaPlayer(media);
        bgmPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        bgmPlayer.setVolume(bgmVolume);
        currentBGM = fileName;
        currentPosition = 0.0;
        bgmPlayer.play();
    }

    // ⏸️ 일시정지
    public static void pauseBGM() {
        if (bgmPlayer != null && bgmPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            currentPosition = bgmPlayer.getCurrentTime().toSeconds(); // 현재 위치 저장
            bgmPlayer.pause();
        }
    }

    // ▶️ 이어 재생
    public static void resumeBGM() {
        if (bgmPlayer != null) {
            bgmPlayer.seek(javafx.util.Duration.seconds(currentPosition));
            bgmPlayer.play();
        }
    }

    // ⏹️ 종료
    public static void stopBGM() {
        if (bgmPlayer != null) {
            bgmPlayer.stop();
            bgmPlayer.dispose();
        }
        bgmPlayer = null;
        currentBGM = null;
        currentPosition = 0.0;
    }

    // 🔊 효과음 재생 (겹침 허용)
    public static void playEffect(String fileName) {
        URL resource = SoundUtil.class.getResource("/sounds/" + fileName);
        if (resource == null) {
            System.err.println("효과음 파일 없음: " + fileName);
            return;
        }

        MediaPlayer effect = new MediaPlayer(new Media(resource.toString()));
        effect.setVolume(1.0); // 효과음은 최대 볼륨
        effect.setOnEndOfMedia(effect::dispose);
        effect.play();
    }

    // 🔊 효과음 반복재생 (겹침 허용)
    public static void replayEffect(String fileName) {
        URL resource = SoundUtil.class.getResource("/sounds/" + fileName);
        if (resource == null) {
            System.err.println("효과음 파일 없음: " + fileName);
            return;
        }

        MediaPlayer effect = new MediaPlayer(new Media(resource.toString()));
        effect.setVolume(1.0); // 효과음은 최대 볼륨
        effect.setOnEndOfMedia(effect::dispose);
        effect.play();
    }

    // 📢 BGM 볼륨 설정 (0.0 ~ 1.0)
    public static void setBGMVolume(double volume) {
        bgmVolume = Math.max(0.0, Math.min(1.0, volume));
        if (bgmPlayer != null) {
            bgmPlayer.setVolume(bgmVolume);
        }
    }
}
