package com.infotech.app.manager.state;

import com.infotech.app.dto.CityDto;
import com.infotech.app.dto.StateDto;

import java.util.List;

public interface StateManager {

    List<StateDto> getStates();
    List<StateDto> getStatesCitiesGroupByStates();

}