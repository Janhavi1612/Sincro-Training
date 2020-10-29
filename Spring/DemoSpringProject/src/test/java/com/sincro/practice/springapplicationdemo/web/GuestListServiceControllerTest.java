package com.sincro.practice.springapplicationdemo.web;

import com.sincro.practice.springapplicationdemo.business.service.GuestListService;
import com.sincro.practice.springapplicationdemo.data.entity.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuestListServiceControllerTest {
    @MockBean
    private GuestListService guestListService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGuestListService() throws Exception {
        List<Guest> guestList = getMockGuestList();
        given(guestListService.getSortedGuestList()).willReturn(guestList);

    }

    private List<Guest> getMockGuestList() {
        List<Guest> guestList = new ArrayList<>();

        Guest guest1 = new Guest();
        guest1.setFirstName("Pqr");
        guest1.setLastName("Test");
        guest1.setGuestId(1);
        guest1.setEmailAddress("p@test.com");
        guestList.add(guest1);

        Guest guest2 = new Guest();
        guest2.setFirstName("Abc");
        guest2.setLastName("Test");
        guest2.setGuestId(2);
        guest2.setEmailAddress("a@test.com");
        guestList.add(guest2);

        return guestList;
    }

}