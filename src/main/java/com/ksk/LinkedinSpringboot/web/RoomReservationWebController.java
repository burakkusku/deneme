package com.ksk.LinkedinSpringboot.web;


import com.ksk.LinkedinSpringboot.business.domain.RoomReservation;
import com.ksk.LinkedinSpringboot.business.service.ReservationService;
import com.ksk.LinkedinSpringboot.entity.Guest;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller

public class RoomReservationWebController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String getReservations(@RequestParam(value = "date", required = false)String dateString, Model model){
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations",roomReservations);
        return "reservations";// What this is going to do is tell TimeLeaf to find a template named reservations,
        // use that template, pass this model that came into the method but pass it too the reservations template and merge with the TimeLeaf engine.
    }

    @GetMapping("/guests")
    public String getGuests(Model model){

        List<Guest> guests = this.reservationService.getGuests();

        model.addAttribute("guests",guests);
        return "guests";
    }
}
