package spring.dao;

import spring.entities.Producer;
import spring.entities.Product;

import java.util.List;

/**
 * Created by Eoller on 05-Sep-17.
 */
public interface ProducerDaoInterface {
    public List<Producer> getProducers();
    public void addProducer(Producer producer);
    public void deleteProducer(Long id);
}
