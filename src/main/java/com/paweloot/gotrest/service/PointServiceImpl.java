package com.paweloot.gotrest.service;

import com.paweloot.gotrest.entity.Path;
import com.paweloot.gotrest.entity.Point;
import com.paweloot.gotrest.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PointServiceImpl implements PointService {

    private PointRepository pointRepository;
    private PathService pathService;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository, PathService pathService) {
        this.pointRepository = pointRepository;
        this.pathService = pathService;
    }

    @Override
    public List<Point> findAllReachableFrom(int pointFromId) {
        
        List<Path> paths = pathService.findAll();

        List<Integer> reachablePointsIds = new ArrayList<>();
        for (Path path : paths) {
            if (path.getId().getIdFrom() == pointFromId) {
                reachablePointsIds.add(path.getId().getIdTo());
            }

            if (path.getId().getIdTo() == pointFromId) {
                reachablePointsIds.add(path.getId().getIdFrom());
            }
        }

        return reachablePointsIds.stream().map(pointId ->
                pointRepository.findById(pointId).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
