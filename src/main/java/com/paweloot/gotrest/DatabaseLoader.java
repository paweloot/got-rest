package com.paweloot.gotrest;

import com.paweloot.gotrest.entity.MtnGroup;
import com.paweloot.gotrest.entity.MtnRange;
import com.paweloot.gotrest.entity.Point;
import com.paweloot.gotrest.repository.MtnRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private MtnRangeRepository mtnRangeRepository;

    @Autowired
    public DatabaseLoader(MtnRangeRepository mtnRangeRepository) {
        this.mtnRangeRepository = mtnRangeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        populateMtnRanges();
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

        MtnGroup tatryWysokie = new MtnGroup("T.01", "Tatry Wysokie");
        tatryWysokie.setPoints(points);

        mtnRangeList.get(0).setMtnGroups(Arrays.asList(
                tatryWysokie,
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

        mtnRangeRepository.deleteAll();
        mtnRangeRepository.saveAll(mtnRangeList);
    }
}
