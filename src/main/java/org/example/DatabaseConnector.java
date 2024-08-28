package org.example;
import java.sql.*;

public class DatabaseConnector {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\sqlite\\Bookstore";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to the SQLite database.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAllBooks() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = connect();
            String sql = "SELECT * FROM Books";
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("title") + "\t" +
                        rs.getString("author") + "\t" +
                        rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing SELECT statement");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
