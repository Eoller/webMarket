package spring.dao;

import spring.entities.News;

import java.util.List;

/**
 * Created by Eoller on 11-Sep-17.
 */
public interface NewsDaoInterface {
    public List<News> getAllNews();
    public News getNewsById(Long id);
    public void addNews(News news);
    public void deleteNews(Long id);
}
