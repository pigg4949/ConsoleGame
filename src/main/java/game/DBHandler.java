package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/consolegame?serverTimezone=Asia/Seoul";
    private static final String USER ="root";
    private static final String PASSWORD = "1234";


    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkProgress(String playerName, String gender) {
        String query = "SELECT COUNT(*) FROM user WHERE playerName = ? AND gender = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, playerName);
            stmt.setString(2, gender);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // 결과가 0보다 크면 기록이 있음
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Player findByPlayerName(String playerName, String gender) {
        String query = "SELECT * FROM user WHERE playerName = ? AND gender = ?";
        Player exPlayer = null;
        try (
                Connection conn = connect();
                PreparedStatement stmt = conn.prepareStatement((query));
        ) {
            stmt.setString(1, playerName);
            stmt.setString(2, gender);
            ResultSet player = stmt.executeQuery();

            while (player.next()){
                exPlayer = new Player(player.getString("playerName"), player.getString("gender"), player.getInt("affection"), player.getInt("clearStage"));
                exPlayer.setPartnerName(player.getString("partnerName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exPlayer;
    }

    public static void savePlayer(String playerName, String gender, int affection, String partnerName, int clearStage) {
        String query = "INSERT INTO user (playerName, gender, affection, partnerName, clearStage) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,playerName);
            stmt.setString(2,gender);
            stmt.setInt(3, affection);
            stmt.setString(4, partnerName);
            stmt.setInt(5, clearStage);
            stmt.executeUpdate();
            System.out.println("플레이어 정보가 저장되었습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlayer(String playerName, String gender, int affection, String partnerName, int clearStage) {
        String query = "UPDATE user SET affection = ?, clearStage = ? WHERE playerName = ? AND gender = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, affection);
            stmt.setInt(2, clearStage);
            stmt.setString(3, playerName);
            stmt.setString(4, gender);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("플레이어 정보가 수정되었습니다");
            } else {
                System.out.println("수정 대상 플레이어를 찾을 수 없습니다");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showRanking(String partnerName) {
        String query = "SELECT playerName, affection, partnerName  FROM user WHERE partnerName = ? order by affection desc";
        try(
                Connection conn = connect();
                PreparedStatement stmt = conn.prepareStatement(query)
                ){
            stmt.setString(1, partnerName);
            ResultSet rs = stmt.executeQuery();
            int rank = 0;
            while (rs.next()) {
                rank++;
                System.out.println(rank + "위 이름: " + rs.getString("playerName") + " 호감도(점수): " + rs.getInt("affection") + " 난이도: " + rs.getString("partnerName"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

}