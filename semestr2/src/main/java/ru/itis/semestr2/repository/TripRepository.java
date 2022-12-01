package ru.itis.semestr2.repository;

import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.itis.semestr2.model.Client;
import ru.itis.semestr2.model.User;
import ru.itis.semestr2.model.UserRole;
import ru.itis.semestr2.weblistener.StartAppp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TripRepository {

    public void addTrip(String addressFrom, String addressTo, Integer client_id) {
        try {
            Connection connection = StartAppp.getConnection();

            String sql = "INSERT INTO trip " +
                    "(client_id, address_from, address_to, status_id) " +
                    " values (?, ?, ?, 1) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, client_id);
            ps.setString(2, addressFrom);
            ps.setString(3, addressTo);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
