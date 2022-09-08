package ru.itis.db.lab2;

import java.util.ArrayList;
import java.util.List;

public class WorkData {

    public static void main(String ... args) {
        WorkData workData = new WorkData();
        workData.makeBooking();
    }

    public void makeBooking() {

        Db db = new Db();
        List<Booking> bookings = new ArrayList<>();
        db.setBookings(bookings);

        Booking booking = new Booking();
        // hotel
        Hotel hotel = new Hotel();
        hotel.setName("Grand Hostel");
        hotel.setAddress("RU, Kazan, Moscow st., 12");
        hotel.setCategory("***");

        booking.setHotel(hotel);
        // room
        Room room = new Room();
        room.setHotel(hotel);
        room.setRoomNumber("12");
        room.setCategory("econom");
        room.setPrice(1500);

        booking.setRoom(room);

        // client
        Client client = new Client();
        client.setName("Kamil");
        client.setPhone("12123123");
        client.setEmail("ksenikeev@mail.ru");

        booking.setClient(client);
        //
        booking.setArrivalDate("08.09.2022");
        booking.setStayingDate("10.09.2022");
        booking.setSumm(3000);

        bookings.add(booking);

        System.out.println(db.toJSON());
    }

}
