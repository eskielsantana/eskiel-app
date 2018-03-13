package com.infotech.app.dto;

import java.io.Serializable;

public class ChacaraDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String imageUrl;
    private String city;
    private Double lat;
    private Double lng;
    private Double price;

    public ChacaraDto(){ }

    public ChacaraDto(int id, String name, String imageUrl, String city, Double price) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.city = city;
        this.price = price;
    }

    public ChacaraDto(int id, String name, String imageUrl, Double lat, Double lng) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
