package ppscr.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ppscr.model.Deal;

public interface DealRepository extends ElasticsearchRepository<Deal, String> {

}
