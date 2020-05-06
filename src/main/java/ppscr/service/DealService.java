package ppscr.service;

import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppscr.repository.DealRepository;
import ppscr.scrapper.PepperScrapper;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DealService {

    private static final int FIRST_PAGE = 1;

    private final PepperScrapper pepperScrapper;
    private final DealRepository dealRepository;

    public void scrapPepperAndSaveResults(int pageToScrap) {
        IntStream.rangeClosed(FIRST_PAGE, pageToScrap).forEach(pageNum -> dealRepository.saveAll(pepperScrapper.scrapPepperPage(pageNum)));
    }

}
