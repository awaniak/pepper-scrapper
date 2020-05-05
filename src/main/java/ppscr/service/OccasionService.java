package ppscr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ppscr.repository.OccasionRepository;
import ppscr.scrapper.PepperScrapper;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OccasionService {

    private final PepperScrapper pepperScrapper;
    private final OccasionRepository occasionRepository;

    public void scrapPepperAndSaveResults(int pageToScrap) {
        for (int pageNum = 1; pageNum <= pageToScrap; pageNum++) {
            occasionRepository.saveAll(pepperScrapper.scrapPepperPage(pageNum));
        }
    }

}
