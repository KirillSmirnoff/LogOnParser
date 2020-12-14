package dao;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DataBase {
    private Connection connection = null;
    private PreparedStatement statement = null;

    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/onelya";
    private static final String USER = "postgres";
    private static final String PASS = "0";
    private static final String SELECT = "select tag_mean from p62g62 where tag = ?";

    public static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loading");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    private void persist (String query, String [] values ) {
        try {
            statement = getConnection().prepareStatement(query);
            statement.setString(1, values[0]);
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            statement.setString(4, values[3]);

            statement.execute();
            connection.commit();

        } catch (SQLException e) {
            rollbackConnection();
            System.out.println("rollbackConnection");
            e.printStackTrace();
        } finally {
            closeConnection();
            System.out.println("closeConnection");
        }

    }

    public String getFromDB(String tag){
        String tag_mean = "";
        try {
            statement = getConnection().prepareStatement(SELECT);
            statement.setString(1,tag);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
                tag_mean = resultSet.getString("tag_mean");

            statement.execute();

        } catch (SQLException e) {
            rollbackConnection();
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return tag_mean;
    }

    private void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void rollbackConnection(){
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readFromFileAndPersist(File src, String query) {
        String[] values;
        try (Scanner scanner = new Scanner(src)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                values = line.split("%");
                persist(query, startInizialization(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] startInizialization(String[] originValues) {
        String[] mustValues = {"not value", "not value", "not value", "not value"};
        for (int i = 0; i < originValues.length; i++) {
            mustValues[i] = originValues[i];
        }
        return mustValues;
    }
}

