package com.infotech.app.service.state;

import com.infotech.app.dto.CityDto;
import com.infotech.app.dto.StateDto;
import com.infotech.app.manager.city.CityManager;
import com.infotech.app.manager.state.StateManager;
import com.infotech.app.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateManager stateManager;

    @Override
    public List<StateDto> getStates(){
        return stateManager.getStates();
    }

    @Override
    public List<StateDto> getStatesCitiesGroupByStates(){
        return stateManager.getStatesCitiesGroupByStates();
    }

}