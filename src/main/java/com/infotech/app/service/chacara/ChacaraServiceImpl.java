package com.infotech.app.service.chacara;

import com.infotech.app.dto.CityDto;
import com.infotech.app.dto.SearchDto;
import com.infotech.app.manager.chacara.ChacaraManager;
import com.infotech.app.dto.ChacaraDto;
import com.infotech.app.entity.Chacara;
import com.infotech.app.manager.city.CityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChacaraServiceImpl implements ChacaraService {

    @Autowired
    private ChacaraManager chacaraManager;

    @Autowired
    private CityManager cityManager;

    @Override
    public ChacaraDto getChacaraById(int articleId) {
        return chacaraManager.getChacaraById(articleId);
    }

    @Override
    public List<ChacaraDto> getChacarasList() {
        return chacaraManager.getAllChacaras();
    }

    @Override
    public SearchDto getChacarasListByCity(String city, String state, Integer limit) {

        List<ChacaraDto> chacaras = chacaraManager.getChacarasListByCity(city, state);
        CityDto cityDto = cityManager.getCityByName(city, state);

        return new SearchDto((cityDto != null ) ? cityDto.getLat() : null,(cityDto != null ) ? cityDto.getLng() : null,
                chacaras.subList(0, (limit >= chacaras.size() ? chacaras.size() : limit) ) , (limit >= chacaras.size()));
    }

    @Override
    public Chacara createChacara(Chacara chacara) {
        return chacaraManager.createChacara(chacara);
    }
}