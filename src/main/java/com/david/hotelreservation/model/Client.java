package com.david.hotelreservation.model;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid2")
    private String id;
    private String name;
    private String lastName;
    private String direction;
    private String telephoneNumber;
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;

    public Client() {
    }
}
