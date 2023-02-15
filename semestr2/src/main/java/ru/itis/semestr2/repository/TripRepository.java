package ru.itis.semestr2.repository;

import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.itis.semestr2.model.*;
import ru.itis.semestr2.weblistener.StartAppp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripRepository {

    public Trip findTrip(Integer id) {
        Trip trip = null;
        try {
            Connection connection = StartAppp.getConnection();

            String sql = " select t.id as tripid, t.address_from, t.address_to, "
                       + " t.start_date, t.end_date, t.client_id, t.driver_id, t.trip_cost, "
                       + " ui.phone, ds.name, c.carnumber, c.car_brand, c.color "
                       + "  from trip t "

                    + " join dict_status ds on t.status_id=ds.id "
                    + " join user_info ui on ui.id = t.client_id "
                    + " left join driver_data dd on dd.id = t.driver_id "
                    + " left join car c on c.id = dd.car_id "
                    + " WHERE t.id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                trip = new Trip();
                trip.setId(rs.getInt("tripid"));
                trip.setAddressFrom(rs.getString("address_from"));
                trip.setAddressTo(rs.getString("address_to"));
                // TODO add date
                Car car = new Car(rs.getString("carnumber"),
                        rs.getString("car_brand"), rs.getString("color"));
                Driver driver = new Driver(rs.getInt("driver_id"), car);
                trip.setClient(new Client(rs.getInt("client_id"),rs.getString("phone")));
                trip.setStatus(new TripStatus(rs.getString("name")));
                trip.setTripCost(rs.getFloat("trip_cost"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return trip;
    }

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

    public List<Trip> getFreeTrips() {

        List<Trip> result = new ArrayList<>();

        try {
            Connection connection = StartAppp.getConnection();

            String sql = " select t.id, t.address_from, t.address_to, ui.phone, ds.name from trip t "
                + " join dict_status ds on t.status_id=ds.id "
                + " join user_info ui on ui.id = t.client_id " +
                    " WHERE status_id = 1 ";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setInt(1, client_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setAddressFrom(rs.getString("address_from"));
                trip.setAddressTo(rs.getString("address_to"));
                trip.setClient(new Client(rs.getString("phone")));
                trip.setStatus(new TripStatus(rs.getString("name")));
                result.add(trip);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<Trip> getAll() {

        List<Trip> result = new ArrayList<>();

        try {
            Connection connection = StartAppp.getConnection();

            String sql = " select t.id, t.address_from, t.address_to, ui.phone, ds.name from trip t "
                    + " join dict_status ds on t.status_id=ds.id "
                    + " join user_info ui on ui.id = t.client_id ";
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps.setInt(1, client_id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setAddressFrom(rs.getString("address_from"));
                trip.setAddressTo(rs.getString("address_to"));
                trip.setClient(new Client(rs.getString("phone")));
                trip.setStatus(new TripStatus(rs.getString("name")));
                result.add(trip);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
