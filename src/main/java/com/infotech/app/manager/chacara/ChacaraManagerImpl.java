package com.infotech.app.manager.chacara;

import com.infotech.app.dto.ChacaraDto;
import com.infotech.app.entity.Chacara;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ChacaraManagerImpl implements ChacaraManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ChacaraDto getChacaraById(int chacaraId) {
        return entityManager.find(Chacara.class, chacaraId).asDto();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ChacaraDto> getAllChacaras() {

        List<ChacaraDto> result = entityManager.createNamedQuery("Chacara.getAllChacaras", ChacaraDto.class).getResultList();

        if(result.isEmpty()){
            result = new ArrayList<>();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ChacaraDto> getChacarasListByCity(String city, String state) {

        List<ChacaraDto> result = entityManager.createNamedQuery("Chacara.getAllChacarasByCity", ChacaraDto.class)
                .setParameter("city", city)
                .setParameter("state", state)
                .getResultList();

        if(result.isEmpty()){
            result = new ArrayList<>();
        }

        return result;
    }

    @Override
    public Chacara createChacara(Chacara event) {
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