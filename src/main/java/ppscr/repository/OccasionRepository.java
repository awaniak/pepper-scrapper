package ppscr.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ppscr.model.Occasion;

public interface OccasionRepository extends ElasticsearchRepository<Occasion, String> {

}
