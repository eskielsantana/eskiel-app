package com.infotech.app.manager.event;
import java.util.List;
import com.infotech.app.entity.Event;

public interface EventManager {

    List<Event> getAllEvents();
    Event getArticleById(int articleId);
    Event createEvent(Event event);
//    void updateArticle(Event event);
//    void deleteArticle(int articleId);
//    boolean articleExists(String title, String category);

}