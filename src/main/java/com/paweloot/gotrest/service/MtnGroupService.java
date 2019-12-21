package com.paweloot.gotrest.service;

import com.paweloot.gotrest.entity.MtnGroup;
import com.paweloot.gotrest.entity.Point;

import java.util.List;

public interface MtnGroupService {

    MtnGroup findById(int id);

    List<Point> findAllPointsById(int id);
}
