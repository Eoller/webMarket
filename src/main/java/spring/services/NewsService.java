package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.NewsDaoInterface;
import spring.entities.News;

import java.util.List;

/**
 * Created by Eoller on 11-Sep-17.
 */
@Service
public class NewsService implements NewsServiceInterface {

    @Autowired
    private NewsDaoInterface newsDaoInterface;

    @Override
    public List<News> getAllNews() {
        return newsDaoInterface.getAllNews();
    }

    @Override
    public void deleteNews(Long id) {
        newsDaoInterface.deleteNews(id);
    }

    @Override
    public News getNewsById(Long id) {
        return newsDaoInterface.getNewsById(id);
    }


}
