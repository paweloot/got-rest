package com.paweloot.gotrest.service;

import com.paweloot.gotrest.entity.Path;
import com.paweloot.gotrest.entity.Point;
import com.paweloot.gotrest.repository.PathRepository;
import com.paweloot.gotrest.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PathServiceImpl implements PathService {

    private PathRepository repository;
    private PointRepository pointRepository;

    @Autowired
    public PathServiceImpl(PathRepository repository, PointRepository pointRepository) {
        this.repository = repository;
        this.pointRepository = pointRepository;
    }

    @Override
    public List<Path> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Path> findAllWithinGroup(int mtnGroupId) {

        List<Path> paths = repository.findAll();

        return paths.stream().filter(p -> {
            int pointFromId = p.getId().getIdFrom();

            Point pointFrom = pointRepository.findById(pointFromId).orElse(null);

            return pointFrom != null && pointFrom.getMtnGroup().getId() == mtnGroupId;
        }).collect(Collectors.toList());
    }
}
