package com.infotech.app.dto;
import java.util.List;

public class SearchDto {

    private Double lat;
    private Double lng;
    private List<ChacaraDto> chacaras;
    private Boolean shouldStopLoad = false;

    public SearchDto() {
    }

    public SearchDto(Double lat, Double lng, List<ChacaraDto> chacaras, Boolean shouldStopLoad) {
        this.lat = lat;
        this.lng = lng;
        this.chacaras = chacaras;
        this.shouldStopLoad = shouldStopLoad;
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

    public List<ChacaraDto> getChacaras() {
        return chacaras;
    }

    public void setChacaras(List<ChacaraDto> chacaras) {
        this.chacaras = chacaras;
    }

    public Boolean getShouldStopLoad() {
        return shouldStopLoad;
    }

    public void setShouldStopLoad(Boolean shouldStopLoad) {
        this.shouldStopLoad = shouldStopLoad;
    }
}
