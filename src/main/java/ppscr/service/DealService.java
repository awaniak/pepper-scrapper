package ppscr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppscr.repository.DealRepository;
import ppscr.scrapper.PepperScrapper;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DealService {

    private final PepperScrapper pepperScrapper;
    private final DealRepository dealRepository;

    public void scrapPepperAndSaveResults(int pageToScrap) {
        for (int pageNum = 1; pageNum <= pageToScrap; pageNum++) {
            dealRepository.saveAll(pepperScrapper.scrapPepperPage(pageNum));
        }
    }

}
