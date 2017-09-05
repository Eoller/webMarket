package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.dao.ProducerDaoInterface;
import spring.entities.Producer;

import java.util.List;

/**
 * Created by Eoller on 05-Sep-17.
 */
@Service
public class ProducerService implements ProducerServiceInterface {
    @Autowired
    private ProducerDaoInterface producerDaoInterface;

    @Override
    public List<Producer> getProducers() {
        return producerDaoInterface.getProducers();
    }
}
