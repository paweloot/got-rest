package com.paweloot.gotrest.path;

import com.paweloot.gotrest.entity.Path;

import java.util.List;

public interface PathService {

    List<Path> findAll();

    List<Path> findAllWithinGroup(int mtnGroupId);
}
