package game.database;

import java.sql.*;

public class RankingManager {
    private static final String URL = "jdbc:mysql://localhost:3306/gameDB";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void showRanking() {
        String query = "SELECT name, gender, affinity FROM players ORDER BY affinity DESC"; // 🏆 랭킹 기준: 마지막 호감도 (기준 변경 가능)

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("===== 랭킹 =====");
            while (rs.next()) {
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int affinity = rs.getInt("affinity");
                System.out.println(name + " (" + gender + ") - 호감도: " + affinity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
