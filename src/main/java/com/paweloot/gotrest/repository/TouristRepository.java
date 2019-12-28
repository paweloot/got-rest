package com.paweloot.gotrest.repository;

import com.paweloot.gotrest.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Integer> {
}
