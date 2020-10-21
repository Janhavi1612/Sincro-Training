package com.sincro.practice.springapplicationdemo;

import com.sincro.practice.springapplicationdemo.data.entity.Guest;
import com.sincro.practice.springapplicationdemo.data.entity.Reservation;
import com.sincro.practice.springapplicationdemo.data.entity.Room;
import com.sincro.practice.springapplicationdemo.data.repository.GuestRepository;
import com.sincro.practice.springapplicationdemo.data.repository.ReservationRepository;
import com.sincro.practice.springapplicationdemo.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringApplicationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationDemoApplication.class, args);
    }

    @RestController
    @RequestMapping("/rooms")
    public class RoomController{
        @Autowired
        private RoomRepository roomRepository;

        @GetMapping
        public Iterable<Room> getRooms(){
            return this.roomRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/guests")
    public class GuestController{
        @Autowired
        private GuestRepository guestRepository;

        @GetMapping
        public Iterable<Guest> getGuests(){
            return this.guestRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/reservations")
    public class ReservationController{
        @Autowired
        private ReservationRepository reservationRepository;

        @GetMapping
        public Iterable<Reservation> getReservations(){
            return this.reservationRepository.findAll();
        }
    }

}
