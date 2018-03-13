package com.infotech.app.service.chacara;

import com.infotech.app.dto.ChacaraDto;
import com.infotech.app.dto.SearchDto;
import com.infotech.app.entity.Chacara;
import com.infotech.app.entity.Event;

import java.util.List;

public interface ChacaraService {

    List<ChacaraDto> getChacarasList();
    SearchDto getChacarasListByCity(String city, String state, Integer limit);
    ChacaraDto getChacaraById(int articleId);
    Chacara createChacara(Chacara event);
}