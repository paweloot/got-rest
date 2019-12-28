package com.paweloot.gotrest.point;

import com.paweloot.gotrest.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Integer> {

    Point findByName(String name);
}
