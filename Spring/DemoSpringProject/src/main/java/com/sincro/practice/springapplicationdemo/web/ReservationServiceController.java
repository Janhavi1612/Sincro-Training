package com.sincro.practice.springapplicationdemo.web;

import com.sincro.practice.springapplicationdemo.business.domain.RoomReservation;
import com.sincro.practice.springapplicationdemo.business.service.ReservationService;
import com.sincro.practice.springapplicationdemo.data.entity.Room;
import com.sincro.practice.springapplicationdemo.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/roomReservations")
public class ReservationServiceController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false)String dateString, Model model){
        Date date = DateUtils.createDateFromString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);

        model.addAttribute("roomReservations", roomReservations);

        return "reservations";
    }
}
