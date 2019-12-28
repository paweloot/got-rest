package com.paweloot.gotrest.user;

import com.paweloot.gotrest.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Integer> {
}
