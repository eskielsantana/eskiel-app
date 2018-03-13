package com.infotech.app.service.event;

import com.infotech.app.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> getEventsList();
    Event getEventById(int articleId);
    Event createEvent(Event event);
//    void updateArticle(Event event);
//    void deleteArticle(int articleId);

}