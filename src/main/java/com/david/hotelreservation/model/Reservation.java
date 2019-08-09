package com.david.hotelreservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid2")
    private String id;
    private Date checkin;
    private Date checkout;
    private int numPeople;
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_idClient")
    private Client client;

    public Reservation() {
    }

}
