package com.infotech.app.service.state;

import com.infotech.app.dto.StateDto;

import java.util.List;

public interface StateService {

    List<StateDto> getStates();
    List<StateDto> getStatesCitiesGroupByStates();
}