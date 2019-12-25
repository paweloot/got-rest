package com.paweloot.gotrest.rest;

import com.paweloot.gotrest.entity.Point;
import com.paweloot.gotrest.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PointController {

    private PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/points/pointsFrom/{pointFromId}")
    public List<Point> findAllReachableFrom(@PathVariable int pointFromId) {
        return pointService.findAllReachableFrom(pointFromId);
    }
}
