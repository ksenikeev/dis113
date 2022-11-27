package ru.itis.lab12;

import org.springframework.security.crypto.codec.Hex;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class UserService {

    public void saveUser(User user) {
        Connection connection = StartAppp.getConnection();

        try {
            // add new USER:

            // begin transaction;
            connection.setAutoCommit(false);

            Integer id = null;
            String sql1 =
                    "insert into users (username,password) values (?,?) returning id";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, user.getUsername());
            ps1.setString(2, user.getPassword());
            // Query 1
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }

            if (id != null) {
                String sql2 =
                        "insert into user_info (id,phone, photo) values (?, '876897696',?)";
                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, id);
                ps2.setBytes(2, user.getPhoto());
                //Query 2
                ps2.executeUpdate();
                ps2.close();
            } else {
                connection.rollback();
            }

            rs.close();
            ps1.close();

            // end transaction;
            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        Connection connection = StartAppp.getConnection();

        String sql = "select u.id, username, phone from users u left join user_info ui on u.id = ui.id ";
        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery())
        {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public User getUserById(Integer id) {
        Connection connection = StartAppp.getConnection();
        User user = null;
        String sql = "select u.id, username, phone, photo from users u left join user_info ui on u.id = ui.id where u.id = ? ";
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPhone(rs.getString("phone"));
                byte[] photo = rs.getBytes("photo");
                user.setBase64Photo(Base64.getEncoder().encodeToString(photo));
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(user);
        return user;
    }

    public byte[] getPhoto(Integer id) {
        Connection connection = StartAppp.getConnection();
        byte[] result = null;
        String sql = "select photo from user_info where id = ? ";
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getBytes("photo");
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
        return result;
    }
}
