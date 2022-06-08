package com.example.t2009m1java.model.util;

import com.example.t2009m1java.entity.User;
import com.example.t2009m1java.service.ConnectionHelper;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ConnectionHelperTest {
    @Test
    public void test() {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from users where status = ?");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("passwordHash");
                int status = resultSet.getInt("status");
                User user = new User(id, username, passwordHash, status);
                users.add(user);
            }

            for (User user :
                    users) {
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}