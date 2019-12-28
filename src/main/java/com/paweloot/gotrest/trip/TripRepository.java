package com.paweloot.gotrest.trip;

import com.paweloot.gotrest.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
