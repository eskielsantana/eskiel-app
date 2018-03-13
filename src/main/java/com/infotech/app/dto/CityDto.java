package com.infotech.app.dto;

import java.io.Serializable;

public class CityDto implements Serializable{

    private static final long serialVersionUID = 1L;

    Integer id;
    String name;
    String state;
    Double lat;
    Double lng;


    public CityDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDto(Integer id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public CityDto(Integer id, String name, Double lat, Double lng) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
