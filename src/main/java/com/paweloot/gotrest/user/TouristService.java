package com.paweloot.gotrest.user;

import com.paweloot.gotrest.entity.Tourist;

public interface TouristService {

    Tourist authorizeTourist(String email, String encodedPassword);
}
