package web;

import misc.Constraints.Endpoints;
import misc.Constraints.Messages;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping(Endpoints.START_SCRAPPING)
    public String startScrapping(@RequestParam(required = false, defaultValue = "10") int pageNum) {
        return Messages.SCRAPPING_SUCCESS;
    }

}
