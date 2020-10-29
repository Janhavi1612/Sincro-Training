package com.sincro.practice.springapplicationdemo.web;

import com.sincro.practice.springapplicationdemo.business.service.GuestListService;
import com.sincro.practice.springapplicationdemo.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guestList")
public class GuestListServiceController {
    private final GuestListService guestListService;

    @Autowired
    public GuestListServiceController(GuestListService guestListService) {
        this.guestListService = guestListService;
    }

    @GetMapping
    public String getGuestList(Model model){
        List<Guest> guestList = guestListService.getSortedGuestList();
        model.addAttribute("guestList", guestList);
        return "guestList";
    }
}
