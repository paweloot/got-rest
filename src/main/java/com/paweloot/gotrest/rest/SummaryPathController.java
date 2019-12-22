package com.paweloot.gotrest.rest;

import com.paweloot.gotrest.entity.SummaryPath;
import com.paweloot.gotrest.service.SummaryPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SummaryPathController {

    private SummaryPathService summaryPathService;

    @Autowired
    public SummaryPathController(SummaryPathService summaryPathService) {
        this.summaryPathService = summaryPathService;
    }

    @PostMapping("/summaryPaths")
    public List<SummaryPath> findAllForPathPoints(@RequestBody List<Integer> pointsIds) {
        return summaryPathService.findAllForPathPoints(pointsIds);
    }
}
