package spring.services;

import spring.entities.News;

import java.util.List;

/**
 * Created by Eoller on 11-Sep-17.
 */
public interface NewsServiceInterface {
    public List<News> getAllNews();
    public void deleteNews(Long id);
    public News getNewsById(Long id);
}
