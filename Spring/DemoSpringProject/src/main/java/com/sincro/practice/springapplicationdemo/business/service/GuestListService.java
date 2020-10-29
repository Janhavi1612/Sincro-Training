package com.sincro.practice.springapplicationdemo.business.service;

import com.sincro.practice.springapplicationdemo.data.entity.Guest;
import com.sincro.practice.springapplicationdemo.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestListService {
    private final GuestRepository guestRepository;


    @Autowired
    public GuestListService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getSortedGuestList(){
        List<Guest> sortedGuestList = new ArrayList<>();
        guestRepository.findAll().forEach(sortedGuestList::add);

        sortedGuestList.sort(Comparator.comparing(Guest::getLastName));

        return sortedGuestList;

    }
}
