package spring.entities;

/**
 * Created by Eoller on 11-Sep-17.
 */
public class News {
    private long id;
    private String topic;
    private String newsText;

    public News(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (topic != null ? !topic.equals(news.topic) : news.topic != null) return false;
        if (newsText != null ? !newsText.equals(news.newsText) : news.newsText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (newsText != null ? newsText.hashCode() : 0);
        return result;
    }
}
