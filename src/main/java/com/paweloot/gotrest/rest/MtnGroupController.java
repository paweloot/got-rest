package com.paweloot.gotrest.rest;

import com.paweloot.gotrest.entity.Point;
import com.paweloot.gotrest.service.MtnGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MtnGroupController {

    private MtnGroupService mtnGroupService;

    @Autowired
    public MtnGroupController(MtnGroupService mtnGroupService) {
        this.mtnGroupService = mtnGroupService;
    }

    @GetMapping("/mtnGroups/{mtnGroupId}/points")
    public List<Point> findAllPointsById(@PathVariable int mtnGroupId) {
        return mtnGroupService.findAllPointsById(mtnGroupId);
    }
}
