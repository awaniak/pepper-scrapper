package ppscr.scrapper;

import static java.lang.String.format;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ppscr.exception.DealScrapperException;
import ppscr.exception.ScrapperException;
import ppscr.misc.Constraints;
import ppscr.model.Deal;

@Component
@Slf4j
public class PepperScrapper {

    public List<Deal> scrapPepperPage(int pageNum) {
        try {
            List<Deal> deals = new LinkedList<>();
            Document document = Jsoup.connect(format("%s?page=%d", Constraints.PEPPER_ADDRESS, pageNum)).get();

            Elements rawOccasions = document.getElementsByTag("article");
            for (Element rawOccasion : rawOccasions) {
                Optional<Deal> mappedOccasion = mapRawOccasionToOccasion(rawOccasion);
                mappedOccasion.ifPresent(deals::add);
            }
            return deals;
        } catch (Exception e) {
            throw new ScrapperException(e);
        }
    }

    private Optional<Deal> mapRawOccasionToOccasion(Element rawOccasion) {
        try {
            Deal deal = new Deal();
            deal.setId(rawOccasion.id());
            deal.setTitle((getTitle(rawOccasion)));
            deal.setPrice(getPrice(rawOccasion));
            deal.setTemp(getTemp(rawOccasion));
            return Optional.of(deal);
        } catch (Exception e) {
            log.warn("Cannot scrap occasion", e);
            return Optional.empty();
        }
    }

    private String getTitle(Element rawOccasion) {
        Elements elements = rawOccasion.getElementsByClass("thread-title--card");
        if (elements.size() != 1) {
            throw new DealScrapperException("Cannot get title for occasion with id: " + rawOccasion.id());
        }
        return elements.first().attr("title");
    }

    private Double getPrice(Element rawOccasion) {
        Elements elements = rawOccasion.getElementsByClass("thread-price");
        if (elements.size() != 1) {
            throw new DealScrapperException("Cannot get price for occasion with id: " + rawOccasion.id());
        }
        String value = elements.first().text();
        if (value.equals("ZA DARMO")) {
            return 0.0;
        }
        value = value.replaceAll(",",".");
        value = value.replaceAll("zł","");
        return Double.parseDouble(value);
    }

    private Integer getTemp(Element rawOccasion) {
        Elements elements = rawOccasion.getElementsByClass("vote-temp");
        if (elements.size() != 1) {
            throw new DealScrapperException("Cannot get temp for occasion with id: " + rawOccasion.id());
        }
        String value = elements.get(0).text();
        value = value.replaceAll("\\D+","");
        return Integer.parseInt(value);
    }

}
