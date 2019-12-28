package com.paweloot.gotrest.path;

import com.paweloot.gotrest.entity.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PathController {

    private PathService pathService;

    @Autowired
    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping("/paths")
    public List<Path> findAll() {
        return pathService.findAll();
    }

    @GetMapping("/paths/{mtnGroupId}")
    public List<Path> findAllWithinGroup(@PathVariable int mtnGroupId) {
        return pathService.findAllWithinGroup(mtnGroupId);
    }
}
