package ppscr.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ppscr.misc.Constraints.Endpoints;
import ppscr.misc.Constraints.Messages;
import ppscr.service.DealService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppController {

    private final DealService dealService;

    @GetMapping(Endpoints.START_SCRAPPING)
    public String startScrapping(@RequestParam(required = false, defaultValue = "10") int pageNum) {
        dealService.scrapPepperAndSaveResults(pageNum);
        return Messages.SCRAPPING_SUCCESS;
    }

}
