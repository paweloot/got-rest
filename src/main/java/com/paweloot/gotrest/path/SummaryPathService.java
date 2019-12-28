package com.paweloot.gotrest.path;

import com.paweloot.gotrest.entity.SummaryPath;

import java.util.List;

public interface SummaryPathService {

    List<SummaryPath> findAllForPathPoints(List<Integer> pointsIds);
}
