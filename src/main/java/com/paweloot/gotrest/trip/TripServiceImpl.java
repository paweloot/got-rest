package com.paweloot.gotrest.trip;

import com.paweloot.gotrest.entity.Point;
import com.paweloot.gotrest.entity.Tourist;
import com.paweloot.gotrest.entity.Trip;
import com.paweloot.gotrest.entity.TripPoint;
import com.paweloot.gotrest.point.PointRepository;
import com.paweloot.gotrest.user.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;
    private PointRepository pointRepository;
    private TouristRepository touristRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, PointRepository pointRepository,
                           TouristRepository touristRepository) {
        this.tripRepository = tripRepository;
        this.pointRepository = pointRepository;
        this.touristRepository = touristRepository;
    }

    @Override
    public Trip save(PostTripBody postTripBody) {

        List<TripPoint> tripPoints = new ArrayList<>();
        List<Integer> pointsIds = postTripBody.getPointsIds();

        for (int i = 0; i < pointsIds.size(); i++) {
            Point point = pointRepository.findById(pointsIds.get(i)).get();

            TripPoint tripPoint = new TripPoint();
            tripPoint.setPoint(point);
            tripPoint.setSerialNumber(i + 1);

            tripPoints.add(tripPoint);
        }

        Tourist tourist = touristRepository.findById(postTripBody.getUserId()).get();
        int prevGotPoints = tourist.getGotPoints();
        tourist.setGotPoints(prevGotPoints + postTripBody.getGotPoints());

        Trip trip = new Trip();
        trip.setTourist(tourist);
        trip.setDate(postTripBody.getDate());
        trip.setGotPoints(postTripBody.getGotPoints());
        trip.setTripPoints(tripPoints);

        tripRepository.save(trip);

        return trip;
    }
}
