package com.paweloot.gotrest.user;

import com.paweloot.gotrest.entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TouristController {

    private final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/tourists/authorize/{email}/{encodedPassword}")
    public Tourist authorizeTourist(@PathVariable String email, @PathVariable String encodedPassword) {
        return touristService.authorizeTourist(email, encodedPassword);
    }
}
