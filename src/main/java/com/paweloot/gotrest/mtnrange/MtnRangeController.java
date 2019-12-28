package com.paweloot.gotrest.mtnrange;

import com.paweloot.gotrest.entity.MtnGroup;
import com.paweloot.gotrest.entity.MtnRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class MtnRangeController {

    private MtnRangeService mtnRangeService;

    @Autowired
    public MtnRangeController(MtnRangeService mtnRangeService) {
        this.mtnRangeService = mtnRangeService;
    }

    @GetMapping("/mtnRanges")
    public List<MtnRange> findAll() {
        return mtnRangeService.findAll();
    }

    @GetMapping("/mtnRanges/{mtnRangeId}")
    public MtnRange findById(@PathVariable int mtnRangeId) {
        return mtnRangeService.findById(mtnRangeId);
    }

    @GetMapping("/mtnRanges/{mtnRangeId}/mtnGroups")
    public List<MtnGroup> findAllMtnGroupsById(@PathVariable int mtnRangeId) {
        return mtnRangeService.findAllMtnGroupsById(mtnRangeId);
    }

    @PostMapping("/mtnRanges")
    public MtnRange save(@RequestBody MtnRange mtnRange) {

        mtnRange.setId(0);
        mtnRangeService.save(mtnRange);

        return mtnRange;
    }

    @PutMapping("/mtnRanges")
    public MtnRange update(@RequestBody MtnRange mtnRange) {

        mtnRangeService.save(mtnRange);

        return mtnRange;
    }

    @DeleteMapping("/mtnRanges/{mtnRangeId}")
    public MtnRange deleteById(@PathVariable int mtnRangeId) {

        MtnRange mtnRange = mtnRangeService.findById(mtnRangeId);

        if (mtnRange == null)
            return null;

        mtnRangeService.deleteById(mtnRangeId);

        return mtnRange;
    }
}
