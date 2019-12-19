package com.paweloot.gotrest.service;

import com.paweloot.gotrest.entity.MtnRange;

import java.util.List;

public interface MtnRangeService {

    List<MtnRange> findAll();

    MtnRange findById(int id);

    void save(MtnRange mtnRange);

    void deleteById(int id);
}
