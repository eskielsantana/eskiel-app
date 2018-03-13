package com.infotech.app.manager.state;

import com.infotech.app.dto.CityDto;
import com.infotech.app.dto.StateDto;
import com.infotech.app.manager.city.CityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class StateManagerImpl implements StateManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CityManager cityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<StateDto> getStates(){

        List<StateDto> result = entityManager.createNamedQuery("State.getAllStates", StateDto.class).getResultList();

        if(result.isEmpty()){
            result = new ArrayList<>();
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StateDto> getStatesCitiesGroupByStates(){

        List<StateDto> states = entityManager.createNamedQuery("State.getAllStatesWithCities", StateDto.class).getResultList();

        List<StateDto> resultList = new ArrayList();
        List<CityDto> cities;
        for(StateDto state : states){
            cities = cityManager.getCitiesByStateUFCode(state.getUfCode());
            if(cities.size() > 0){
                state.setCities(cities);
                resultList.add(state);
            }
        }

        if(resultList.isEmpty()){
            resultList = new ArrayList<>();
        }

        return resultList;
    }

}