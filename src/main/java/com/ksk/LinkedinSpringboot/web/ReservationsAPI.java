package com.ksk.LinkedinSpringboot.web;


import com.ksk.LinkedinSpringboot.business.domain.RoomReservation;
import com.ksk.LinkedinSpringboot.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping
public class ReservationsAPI {

    private final ReservationService reservationService;

    @Autowired
    public ReservationsAPI(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/api/reservations")
    public List<RoomReservation> getReservations(@RequestParam(name = "date", required = false) String date){

        Date dates = DateUtils.createDateFromDateString(date);


        return reservationService.getRoomReservationsForDate(dates);

    }
}
