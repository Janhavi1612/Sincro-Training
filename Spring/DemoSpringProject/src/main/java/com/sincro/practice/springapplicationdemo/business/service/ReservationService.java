package com.sincro.practice.springapplicationdemo.business.service;

import com.sincro.practice.springapplicationdemo.business.domain.RoomReservation;
import com.sincro.practice.springapplicationdemo.data.entity.Guest;
import com.sincro.practice.springapplicationdemo.data.entity.Reservation;
import com.sincro.practice.springapplicationdemo.data.entity.Room;
import com.sincro.practice.springapplicationdemo.data.repository.GuestRepository;
import com.sincro.practice.springapplicationdemo.data.repository.ReservationRepository;
import com.sincro.practice.springapplicationdemo.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
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

        rooms.forEach(room ->{
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setGuestId(reservation.getGuestId());
            roomReservation.setDate(reservation.getReservationDate());
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            System.out.println("Guest :"+ guest.getFirstName()+" "+guest.getLastName());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        List<RoomReservation> roomReservations = new ArrayList<>();
        for(Long id : roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(id));
        }

        return roomReservations;
    }
}
