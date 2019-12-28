package com.paweloot.gotrest;

import com.paweloot.gotrest.entity.*;
import com.paweloot.gotrest.mtngroup.MtnGroupRepository;
import com.paweloot.gotrest.mtnrange.MtnRangeRepository;
import com.paweloot.gotrest.path.PathRepository;
import com.paweloot.gotrest.point.PointRepository;
import com.paweloot.gotrest.trip.TripRepository;
import com.paweloot.gotrest.user.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private MtnRangeRepository mtnRangeRepository;
    private MtnGroupRepository mtnGroupRepository;
    private PathRepository pathRepository;
    private PointRepository pointRepository;
    private TouristRepository touristRepository;
    private TripRepository tripRepository;

    @Autowired
    public DatabaseLoader(MtnRangeRepository mtnRangeRepository, PathRepository pathRepository,
                          PointRepository pointRepository, MtnGroupRepository mtnGroupRepository,
                          TouristRepository touristRepository, TripRepository tripRepository) {
        this.mtnRangeRepository = mtnRangeRepository;
        this.mtnGroupRepository = mtnGroupRepository;
        this.pathRepository = pathRepository;
        this.pointRepository = pointRepository;
        this.touristRepository = touristRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        pathRepository.deleteAll();
        tripRepository.deleteAll();
        pointRepository.deleteAll();
        mtnGroupRepository.deleteAll();
        mtnRangeRepository.deleteAll();
        touristRepository.deleteAll();

        populateMtnRanges();
        populatePoints();
        populatePaths();
        populateTourists();
    }

    private void populateMtnRanges() {
        List<MtnRange> mtnRangeList = Arrays.asList(
                new MtnRange("Tatry i Podtatrze",
                        "https://www.tatry-przewodnik.com.pl/images/jaworowe-turnie-1.jpg"),
                new MtnRange("Beskidy Zachodnie",
                        "http://tour-guide.pl/wp-content/uploads/2015/11/beskidy-poland-1361735-1600x1200-1200x480.jpg"),
                new MtnRange("Góry Świętokrzyskie",
                        "https://mynaszlaku.pl/wp-content/uploads/2018/12/GorySwietokrzyskie11180031.jpg"),
                new MtnRange("Sudety",
                        "https://www.gazetasenior.pl/wp-content/uploads/2015/03/mountain-484542_640.jpg")
        );

        mtnRangeList.get(0).setMtnGroups(Arrays.asList(
                new MtnGroup("T.01", "Tatry Wysokie"),
                new MtnGroup("T.02", "Tatry Zachodnie"),
                new MtnGroup("T.03", "Podtatrze")
        ));

        mtnRangeList.get(1).setMtnGroups(Arrays.asList(
                new MtnGroup("BZ.01", "Beskid Śląski"),
                new MtnGroup("BZ.02", "Beskid Żywiecki"),
                new MtnGroup("BZ.03", "Beskid Mały"),
                new MtnGroup("BZ.04", "Beskid Średni"),
                new MtnGroup("BZ.05", "Gorce"),
                new MtnGroup("BZ.06", "Beskid Wyspowy"),
                new MtnGroup("BZ.07", "Orawa"),
                new MtnGroup("BZ.08", "Spisz i Pieniny"),
                new MtnGroup("BZ.09", "Beskid Sądecki"),
                new MtnGroup("BZ.10", "Pogórze Wielickie")
        ));

        mtnRangeList.get(2).setMtnGroups(Arrays.asList(
                new MtnGroup("Ł01", "Góry Świętokrzyskie"),
                new MtnGroup("Ł02", "Góry Świętokrzyskie"),
                new MtnGroup("Ł03", "Góry Świętokrzyskie"),
                new MtnGroup("Ł04", "Góry Świętokrzyskie"),
                new MtnGroup("Ł05", "Góry Świętokrzyskie")
        ));

        mtnRangeList.get(3).setMtnGroups(Arrays.asList(
                new MtnGroup("S.01", "Góry Izerskie"),
                new MtnGroup("S.02", "Pogórze Izerskie"),
                new MtnGroup("S.03", "Karkonosze"),
                new MtnGroup("S.04", "Kotlina Jeleniogórska"),
                new MtnGroup("S.05", "Rudawy Janowickie"),
                new MtnGroup("S.06", "Góry Kaczawskie"),
                new MtnGroup("S.07", "Pogórze Kaczawskie")
        ));

        mtnRangeRepository.saveAll(mtnRangeList);
    }

    private void populatePoints() {
        List<Point> points = Arrays.asList(
                new Point("Palenica Białczańska", 984),
                new Point("Polana pod Wołoszynem", 1250),
                new Point("Wierch Poroniec", 1101),
                new Point("Dolina Filipka", 944),
                new Point("Rusinowa Polana", 1210),
                new Point("Wodogrzmoty Mickiewicza", 1100),
                new Point("Schronisko PTTK w Roztoce", 1031),
                new Point("Schronisko PTTK nad Morskim Okiem", 1406)
        );

        MtnGroup mtnGroup = mtnGroupRepository.findByName("Tatry Wysokie");

        for (Point p : points) {
            mtnGroup.addPoint(p);
        }

        pointRepository.saveAll(points);
    }

    private void populatePaths() {

        Point p1 = pointRepository.findByName("Palenica Białczańska");
        Point p2 = pointRepository.findByName("Wodogrzmoty Mickiewicza");
        Point p3 = pointRepository.findByName("Rusinowa Polana");
        Point p4 = pointRepository.findByName("Polana pod Wołoszynem");


        List<Path> paths = Arrays.asList(
                new Path(p1.getId(), p2.getId(), 2900, 116, 4, 3),
                new Path(p1.getId(), p3.getId(), 2100, 226, 4, 2),
                new Path(p4.getId(), p3.getId(), 2200, -40, 3, 3)
        );

        pathRepository.saveAll(paths);
    }

    private void populateTourists() throws ParseException {

        Date dayOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("13/07/1998");

        User paweloot = new User("paweloot@gmail.com",
                "36A7FB9AAA2A91723D954C790FE4D14BFD2E318C8F21809A15CFBF9272952FF5",
                "Paweł", "Banaś", dayOfBirth);

        Tourist tourist = new Tourist(paweloot, 0);

        touristRepository.save(tourist);
    }
}
