package ppscr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import ppscr.misc.Constraints;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = Constraints.ElasticIndices.PEPPER_INDEX)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Occasion {

    @Id
    String id;
    String title;
    Double price;
    Integer temp;

}
