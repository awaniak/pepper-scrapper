package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import misc.Constraints;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = Constraints.ElasticIndices.PEPPER_INDEX)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pepper {

    String title;
    Double price;
    Integer temp;

}
