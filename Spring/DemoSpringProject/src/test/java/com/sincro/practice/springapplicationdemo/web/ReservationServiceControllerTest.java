package com.sincro.practice.springapplicationdemo.web;

import com.sincro.practice.springapplicationdemo.Utilities.DateUtils;
import com.sincro.practice.springapplicationdemo.business.domain.RoomReservation;
import com.sincro.practice.springapplicationdemo.business.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservationServiceControllerTest{
    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetReservations() throws Exception{
        String dateString = "2020-10-23";
        Date date = DateUtils.createDateFromString(dateString);
        List<RoomReservation> roomReservations = new ArrayList<>();
        RoomReservation roomReservation = setMockRoomReservation(date);

        roomReservations.add(roomReservation);
        given(reservationService.getRoomReservationsForDate(date)).willReturn(roomReservations);

        this.mockMvc.perform(get("/roomReservations?date=2020-10-23"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test, Junit")));
    }

    private RoomReservation setMockRoomReservation(Date date) {
        RoomReservation roomReservation = new RoomReservation();
        roomReservation.setLastName("Test");
        roomReservation.setFirstName("Junit");
        roomReservation.setGuestId(200);
        roomReservation.setDate(date);
        roomReservation.setRoomNumber("T1");
        roomReservation.setRoomName("TestRoom");
        roomReservation.setRoomId(100);
        return roomReservation;
    }
}