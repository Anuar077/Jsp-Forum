package com.example.Jsp_Forum.dbConnection;

import com.example.Jsp_Forum.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserConnection {
    private static String url = "jdbc:postgres://localhost/forum";
    private static String driverName = "com.postgres.jdbc.Driver";
    private static String login = "postgres";
    private static String dbpassword = "1020";
    static Connection connection;
    static Statement statement;

    public static void connect() {
        if (connection == null) {
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(url, login, dbpassword);
                statement = connection.createStatement();
            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static User getUser(String username, String password) {
        connect();

        String sqlString = "SELECT * FROM users WHERE username='" + username + "' AND " + "password='" + password + "'";
        User user = new User();
        try {
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public static User getUserById(int userId) {
        connect();

        String sqlString = "SELECT * FROM users WHERE user_id=" + userId;
        User user = new User();
        try {
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public static int createUser(User user) {
        connect();

        String sqlString = "insert into users (email, username, password) values('"
                + user.getEmail() + "', '"
                + user.getUsername() + "', '"
                + user.getPassword() + "')";

        int result = 0;
        try {
            result = statement.executeUpdate(sqlString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public static List<User> getUsers() {
        connect();

        String sqlString = "SELECT * FROM users";
        List<User> userList = new ArrayList<User>();
        try {
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
}
