package com.paweloot.gotrest.service;

import com.paweloot.gotrest.entity.SummaryPath;

import java.util.List;

public interface SummaryPathService {

    List<SummaryPath> findAllForPathPoints(List<Integer> pointsIds);
}
