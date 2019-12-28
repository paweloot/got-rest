package com.paweloot.gotrest.path;

import com.paweloot.gotrest.entity.Path;
import com.paweloot.gotrest.entity.Point;
import com.paweloot.gotrest.entity.SummaryPath;
import com.paweloot.gotrest.point.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SummaryPathServiceImpl implements SummaryPathService {

    private PathService pathService;
    private PointRepository pointRepository;

    @Autowired
    public SummaryPathServiceImpl(PathService pathService, PointRepository pointRepository) {
        this.pathService = pathService;
        this.pointRepository = pointRepository;
    }

    @Override
    public List<SummaryPath> findAllForPathPoints(List<Integer> pointsIds) {

        List<SummaryPath> summaryPaths = new ArrayList<>();

        Point p = pointRepository.findById(pointsIds.get(0)).orElse(null);
        int mtnGroupId = p.getMtnGroup().getId();
        List<Path> paths = pathService.findAllWithinGroup(mtnGroupId);

        for (int i = 0; i < pointsIds.size() - 1; i++) {
            Point pointFrom = pointRepository.findById(pointsIds.get(i)).orElse(null);
            Point pointTo = pointRepository.findById(pointsIds.get(i + 1)).orElse(null);

            int gotPoints = resolveGotPoints(pointFrom.getId(), pointTo.getId(), paths);
            summaryPaths.add(new SummaryPath(pointFrom.getName(), pointTo.getName(), gotPoints));
        }

        return summaryPaths;
    }

    private int resolveGotPoints(int idFrom, int idTo, List<Path> paths) {

        for (Path path : paths) {
            if (path.getId().getIdFrom() == idFrom &&
                    path.getId().getIdTo() == idTo) {
                return path.getGotPoints();
            }

            if (path.getId().getIdFrom() == idTo &&
                    path.getId().getIdTo() == idFrom) {
                return path.getGotPointsReturn();
            }
        }

        return 0;
    }
}
