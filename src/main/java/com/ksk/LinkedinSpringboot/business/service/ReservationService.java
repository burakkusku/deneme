package com.ksk.LinkedinSpringboot.business.service;

import com.ksk.LinkedinSpringboot.business.domain.RoomReservation;
import com.ksk.LinkedinSpringboot.data.GuestRepository;
import com.ksk.LinkedinSpringboot.data.ReservationRepository;
import com.ksk.LinkedinSpringboot.data.RoomRepository;
import com.ksk.LinkedinSpringboot.entity.Guest;
import com.ksk.LinkedinSpringboot.entity.Reservation;
import com.ksk.LinkedinSpringboot.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
//like Component
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }




    public List<RoomReservation> getRoomReservationsForDate(Date date){

        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(),roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findByResDate(new java.sql.Date(date.getTime()));

        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);

            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });

        List<RoomReservation> roomReservations = new ArrayList<>();

        for (Long id :
                roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }

        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if(o1.getRoomName()==o2.getRoomName()){
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomNumber().compareTo(o2.getRoomNumber());
            }
        });

        return roomReservations;
    }

    public List<Guest> getGuests(){
        HashMap<Long,Guest> guests = new HashMap<>();
        Iterable<Guest> guestList = this.guestRepository.findAll();
        guestList.forEach(guestObject ->
        {

            guests.put(guestObject.getGuestId(),guestObject);
        });

        List<Guest> guestList1 = new ArrayList<>();

        for (Long id :
                guests.keySet()) {
            guestList1.add(guests.get(id));
        }

        guestList1.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {

                    return o1.getLastName().compareTo(o2.getLastName());

            }
        });

        return guestList1;


    }
}

