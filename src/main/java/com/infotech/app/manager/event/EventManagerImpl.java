package com.infotech.app.manager.event;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.infotech.app.entity.Event;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EventManagerImpl implements EventManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Event getArticleById(int articleId) {
        return entityManager.find(Event.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> getAllEvents() {

        List<Event> result = entityManager.createNamedQuery("Event.returnAllEvents", Event.class).getResultList();

        if(result.isEmpty()){
            result = new ArrayList<>();
        }

        return result;
    }

    @Override
    public Event createEvent(Event event) {
         entityManager.persist(event);
         return event;
    }
//
//    @Override
//    public void updateArticle(Event event) {
////        Event artcl = getEventById(event.getArticleId());
////        artcl.setTitle(event.getTitle());
////        artcl.setCategory(event.getCategory());
////        entityManager.flush();
//    }
//
//    @Override
//    public void deleteArticle(int articleId) {
//        entityManager.remove(getArticleById(articleId));
//    }
//
//    @Override
//    public boolean articleExists(String title, String category) {
//        String hql = "FROM Event as atcl WHERE atcl.title = ? and atcl.category = ?";
//        int count = entityManager.createQuery(hql).setParameter(1, title)
//                .setParameter(2, category).getResultList().size();
//        return count > 0 ? true : false;
//    }
}