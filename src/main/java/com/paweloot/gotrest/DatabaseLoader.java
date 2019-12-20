package com.paweloot.gotrest;

import com.paweloot.gotrest.entity.MtnRange;
import com.paweloot.gotrest.repository.MtnRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
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

        mtnRangeRepository.deleteAll();
        mtnRangeRepository.saveAll(mtnRangeList);
    }
}
