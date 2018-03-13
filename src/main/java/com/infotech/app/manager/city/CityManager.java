package com.infotech.app.manager.city;

import com.infotech.app.dto.CityDto;

import java.util.List;

public interface CityManager {

    List<CityDto> getCities();
    List<CityDto> getCitiesByStateUFCode(Integer stateId);
    CityDto getCityByName(String city, String state);

}