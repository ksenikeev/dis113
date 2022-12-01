package ru.itis.semestr2.repository;

import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.itis.semestr2.model.User;
import ru.itis.semestr2.model.UserRole;
import ru.itis.semestr2.weblistener.StartAppp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCheckRepository {
    public User checkUser(String username, String password) {
        User user = null;
        try {
            Connection connection = StartAppp.getConnection();

            String sql = "select u.id, ui.name, ui.role_id, u.password " +
                    "FROM users u " +
                    "JOIN user_info ui ON u.id = ui.id " +
                    "WHERE u.username = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hash = rs.getString("password");
                if (BCrypt.checkpw(password, hash)) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setRole(new UserRole(rs.getInt("role_id")));
                    user.setName(rs.getString("name"));
                }
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
