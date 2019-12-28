package com.paweloot.gotrest.mtnrange;

import com.paweloot.gotrest.entity.MtnGroup;
import com.paweloot.gotrest.entity.MtnRange;

import java.util.List;

public interface MtnRangeService {

    List<MtnRange> findAll();

    MtnRange findById(int id);

    List<MtnGroup> findAllMtnGroupsById(int id);

    void save(MtnRange mtnRange);

    void deleteById(int id);
}
