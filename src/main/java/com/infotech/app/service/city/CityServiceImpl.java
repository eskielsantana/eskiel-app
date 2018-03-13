package com.infotech.app.service.city;

import com.infotech.app.dto.CityDto;
import com.infotech.app.manager.city.CityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityManager cityManager;

    @Override
    public List<CityDto> getCities(){
        return cityManager.getCities();
    }
}