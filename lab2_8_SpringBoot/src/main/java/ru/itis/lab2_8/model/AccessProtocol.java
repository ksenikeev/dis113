package ru.itis.lab2_8.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Entity
@Getter @Setter @ToString
public class AccessProtocol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "AccessProtocolGen")
    @SequenceGenerator(name = "AccessProtocolGen",
            sequenceName = "accessprotocol_seq", allocationSize = 1)
    private Long id;

    private String username;

    private Boolean success;

    @Temporal(TemporalType.TIMESTAMP)
    private Date accessTime;
}
