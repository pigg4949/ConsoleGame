package game.database;

import java.sql.*;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/gameDB?serverTimezone=Asia/Seoul";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkProgress(String playerName, String gender) {
        String query = "SELECT * FROM players WHERE name = ? AND gender = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, playerName);
            stmt.setString(2, gender);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // 데이터가 있으면 true 반환
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void savePlayer(String playerName, String gender, int affection) {
        String query = "INSERT INTO players (name, gender, affinity) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, playerName);
            stmt.setString(2, gender);
            stmt.setInt(3, affection);
            stmt.executeUpdate();
            System.out.println("플레이어 정보가 저장되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
