package misc;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constraints {

    public static final String PEPPER_ADDRESS = "https://www.pepper.pl/";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ElasticIndices {
        public static final String PEPPER_INDEX = "pepper";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Endpoints {
        public static final String START_SCRAPPING = "scrap";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Messages {
        public static final String SCRAPPING_SUCCESS = "Scraping ended with success!";
    }



}
