package com.paweloot.gotrest.mtngroup;

import com.paweloot.gotrest.entity.MtnGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MtnGroupRepository extends JpaRepository<MtnGroup, Integer> {

    MtnGroup findByName(String name);
}
