package com.paweloot.gotrest.user;

import com.paweloot.gotrest.entity.Tourist;
import com.paweloot.gotrest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {

    private final TouristRepository touristRepository;
    private UserRepository userRepository;

    @Autowired
    public TouristServiceImpl(TouristRepository touristRepository, UserRepository userRepository) {
        this.touristRepository = touristRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Tourist authorizeTourist(String email, String encodedPassword) {

        Optional<User> requestedUser = userRepository.findByEmail(email);

        if (requestedUser.isPresent()) {
            User user = requestedUser.get();

            if (user.getPassword().equalsIgnoreCase(encodedPassword)) {
                return touristRepository.findById(user.getId()).orElse(null);
            }
        }

        return null;
    }
}
