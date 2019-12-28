package com.paweloot.gotrest.trip;

import com.paweloot.gotrest.entity.Trip;

public interface TripService {

    Trip save(TripPostBody tripPostBody);
}
