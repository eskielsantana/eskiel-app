package com.infotech.app.service.event;
import java.util.List;

import com.infotech.app.manager.event.EventManager;
import com.infotech.app.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventManager eventManager;

    @Override
    public Event getEventById(int articleId) {
        return eventManager.getArticleById(articleId);
    }

    @Override
    public List<Event> getEventsList(){
        return eventManager.getAllEvents();
    }

    @Override
    public Event createEvent(Event event){
        return eventManager.createEvent(event);
    }

//    @Override
//    public void updateArticle(Event event) {
//        articleDAO.updateArticle(event);
//    }
//
//    @Override
//    public void deleteArticle(int articleId) {
//        articleDAO.deleteArticle(articleId);
//    }
}