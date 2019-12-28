package com.paweloot.gotrest.point;

import com.paweloot.gotrest.entity.Point;

import java.util.List;

public interface PointService {
    List<Point> findAllReachableFrom(int pointFromId);
}
