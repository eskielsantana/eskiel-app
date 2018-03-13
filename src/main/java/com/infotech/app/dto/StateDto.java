package com.infotech.app.dto;

import java.io.Serializable;
import java.util.List;

public class StateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    Integer id;
    String name;
    Integer ufCode;
    List<CityDto> cities;

    public StateDto(Integer id, String name, Integer ufCode) {
        this.id = id;
        this.name = name;
        this.ufCode = ufCode;
    }

    public StateDto(Integer id, String name, List<CityDto> cities) {
        this.id = id;
        this.name = name;
        this.cities = cities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUfCode() {
        return ufCode;
    }

    public void setUfCode(Integer ufCode) {
        this.ufCode = ufCode;
    }

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }
}
