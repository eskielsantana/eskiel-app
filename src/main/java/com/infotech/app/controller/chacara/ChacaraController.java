package com.infotech.app.controller.chacara;

import com.infotech.app.dto.ChacaraDto;
import com.infotech.app.dto.CityDto;
import com.infotech.app.dto.SearchDto;
import com.infotech.app.dto.StateDto;
import com.infotech.app.entity.Chacara;
import com.infotech.app.entity.Event;
import com.infotech.app.service.chacara.ChacaraService;
import com.infotech.app.service.city.CityService;
import com.infotech.app.service.event.EventService;
import com.infotech.app.service.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("chacara")
public class ChacaraController {

    @Autowired
    private ChacaraService chacaraService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StateService stateService;

    @GetMapping("getChacara/{id}")
    public ResponseEntity<ChacaraDto> getChacarById(@PathVariable("id") Integer id) {
        ChacaraDto chacara = chacaraService.getChacaraById(id);
        return new ResponseEntity<>(chacara, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getAllChacaras")
    public ResponseEntity<List<ChacaraDto>> getChacarasList() {

        List<ChacaraDto> list = chacaraService.getChacarasList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getCities")
    public ResponseEntity<List<CityDto>> getCities() {
        List<CityDto> list = cityService.getCities();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getStatesAndCities")
    public ResponseEntity<List<StateDto>> getStatesAndCities() {
        List<StateDto> list = stateService.getStatesCitiesGroupByStates();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getChacarasByCity/{city}/{state}/{limit}")
    public ResponseEntity<SearchDto> getChacarasListByCity(@PathVariable("city") String city, @PathVariable("state") String state, @PathVariable("limit") Integer limit) {

        SearchDto result = chacaraService.getChacarasListByCity(city, state, limit);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("addChacara")
    public ResponseEntity<Void> addChacara(@RequestBody Chacara chacara, UriComponentsBuilder builder) {

        Chacara createdChacara = chacaraService.createChacara(chacara);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/event/{id}").buildAndExpand(createdChacara.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}