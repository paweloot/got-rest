package com.paweloot.gotrest.mtngroup;

import com.paweloot.gotrest.entity.MtnGroup;
import com.paweloot.gotrest.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MtnGroupServiceImpl implements MtnGroupService {

    private MtnGroupRepository repository;

    @Autowired
    public MtnGroupServiceImpl(MtnGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public MtnGroup findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Point> findAllPointsById(int id) {
        return repository.findById(id).map(MtnGroup::getPoints).orElse(null);
    }
}
