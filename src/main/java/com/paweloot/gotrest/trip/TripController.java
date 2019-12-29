package com.paweloot.gotrest.trip;

import com.paweloot.gotrest.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TripController {

    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/trips")
    public Trip save(@RequestBody PostTripBody postTripBody) {
        return tripService.save(postTripBody);
    }
}
