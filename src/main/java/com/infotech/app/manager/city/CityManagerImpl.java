package com.infotech.app.manager.city;

import com.infotech.app.dto.ChacaraDto;
import com.infotech.app.dto.CityDto;
import com.infotech.app.entity.Chacara;
import com.infotech.app.manager.chacara.ChacaraManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class CityManagerImpl implements CityManager {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<CityDto> getCities(){

//        List<CityDto> result = entityManager.createNamedQuery("City.getAllCityNames", CityDto.class).getResultList();
        List<CityDto> result = getFilledCitiesNativeQuery();

        if(result.isEmpty()){
            result = new ArrayList<>();
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CityDto> getCitiesByStateUFCode(Integer stateId){

        List<CityDto> result = getCitiesByStateUFCodeNativeQuery(stateId);

        if(result.isEmpty()){
            result = new ArrayList<>();
        }

        return result;
    }

    @Override
    public CityDto getCityByName(String city, String state){

        List<CityDto> result = entityManager.createNamedQuery("City.getCityByName", CityDto.class)
                .setParameter("cName", city)
                .setParameter("state", state)
                .getResultList();

        if(result.isEmpty()){
            return null;
        }
        return result.get(0);
    }


    private List<CityDto> getCitiesByStateUFCodeNativeQuery(Integer ufCode){
        List<Object[]> list = entityManager.createNativeQuery("SELECT c.id, c.name FROM city c WHERE c.uf_code = :uf_code AND (select count(ch.id) from Chacara ch where ch.city_id = c.id) > 0")
                .setParameter("uf_code", ufCode).getResultList();

        List<CityDto> resultList = new ArrayList<>();
        for(Object[] city : list){
            resultList.add( new CityDto( Integer.valueOf(city[0].toString()), city[1].toString()));
        }

        return resultList;
    }

    private List<CityDto> getFilledCitiesNativeQuery(){
        List<Object[]> list = entityManager.createNativeQuery("SELECT c.id, c.name, c.uf FROM city c " +
                "WHERE (select count(ch.id) from Chacara ch where ch.city_id = c.id) > 0").getResultList();

        List<CityDto> resultList = new ArrayList<>();
        for(Object[] city : list){
            resultList.add( new CityDto( Integer.valueOf(city[0].toString()), city[1].toString(), city[2].toString()));
        }

        return resultList;
    }
}