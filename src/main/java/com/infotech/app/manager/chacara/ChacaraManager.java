package com.infotech.app.manager.chacara;

import com.infotech.app.dto.ChacaraDto;
import com.infotech.app.entity.Chacara;

import java.util.List;

public interface ChacaraManager {

    List<ChacaraDto> getAllChacaras();
    List<ChacaraDto> getChacarasListByCity(String city, String state);
    ChacaraDto getChacaraById(int chacaraId);
    Chacara createChacara(Chacara event);


}