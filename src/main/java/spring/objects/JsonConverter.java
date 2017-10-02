package spring.objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spring.entities.Product;

/**
 * Created by Eoller on 01-Oct-17.
 */
public class JsonConverter {

    public static String toJson(Product product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(product);
    }
}
