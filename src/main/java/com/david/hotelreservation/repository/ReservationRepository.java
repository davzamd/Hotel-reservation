package com.david.hotelreservation.repository;

import com.david.hotelreservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query("select r from Reservation where r.checkin =:initDate and r.checkout =: finishDate")
    List<Reservation> find(@Param(value = "initDate") Date initDate ,@Param(value = "finishDate") Date finishDate);
}
