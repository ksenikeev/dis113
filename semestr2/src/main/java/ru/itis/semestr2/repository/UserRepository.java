package ru.itis.semestr2.repository;

import ru.itis.semestr2.model.Car;
import ru.itis.semestr2.model.Driver;
import ru.itis.semestr2.model.User;
import ru.itis.semestr2.weblistener.StartAppp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public User saveUser(User user) {

        Connection connection = StartAppp.getConnection();

        try {
            // start transaction
            connection.setAutoCommit(false);

            String sql1 = "insert into users (username,password) values (?, ?) returning id ";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1,user.getUsername());
            statement1.setString(2,user.getPassword());

            Integer userid = null;
            ResultSet rs1 = statement1.executeQuery();
            if (rs1.next()) {
                userid = rs1.getInt("id");
            }
            rs1.close();

            String sql2 = "insert into user_info " +
                    "(id,name, phone, card_number, role_id) values " +
                    " (?, ?, ?, ?, ?)";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setInt(1, userid);
            statement2.setString(2,user.getName());
            statement2.setString(3,user.getPhone());
            statement2.setString(4,user.getCardNumber());
            statement2.setInt(5, user.getRole().getId());
            statement2.executeUpdate();

            if (user instanceof Driver) {
                Driver driver = (Driver) user;
                Car car = driver.getCar();
                String sql3 = "insert into car " +
                        "(carnumber, car_brand, color) values " +
                        " (?, ?, ?) returning id ";
                PreparedStatement statement3 = connection.prepareStatement(sql3);
                statement3.setString(1,car.getCarNumber());
                statement3.setString(2,car.getCarBrand());
                statement3.setString(3,car.getColor());
                ResultSet rs3 = statement3.executeQuery();
                Integer car_id = null;
                if (rs3.next()) {
                    car_id = rs3.getInt("id");
                }
                rs3.close();

                String sql4 = "insert into driver_data (id, car_id) values (?, ?) ";
                PreparedStatement statement4 = connection.prepareStatement(sql4);
                statement4.setInt(1,userid);
                statement4.setInt(2,car_id);
                statement4.executeUpdate();

                statement1.close();
                statement2.close();
                statement3.close();
                statement4.close();
            }

            connection.commit();
            connection.setAutoCommit(true);

            user.setId(userid);

        } catch (SQLException e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }

        return user;
    }

}
