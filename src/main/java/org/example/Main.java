package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnector connector = new DatabaseConnector();

        connector.selectAllBooks();
    }
}