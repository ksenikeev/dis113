package ru.itis.semestr2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class Trip {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Client client;
    private Driver driver;
    private String addressFrom;
    private String addressTo;
    private Float tripCost;
    private TripStatus status;
}
