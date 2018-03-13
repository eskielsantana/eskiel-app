package com.infotech.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="city")
@NamedQueries({
        @NamedQuery(name="City.getAllCityNames", query="SELECT new com.infotech.app.dto.CityDto(c.id, c.name, c.state.name) FROM Cidade c ORDER BY c.id"),
        @NamedQuery(name="City.getCityByName", query="SELECT new com.infotech.app.dto.CityDto(c.id, c.name, c.lat, c.lng) FROM Cidade c " +
                "INNER JOIN c.state st " +
                "WHERE c.name like :cName AND st.uf like :state ORDER BY c.id"),
        @NamedQuery(name="City.getCitiesByStateUFCode", query="SELECT new com.infotech.app.dto.CityDto(c.id, c.name) FROM Cidade c INNER JOIN c.state e WHERE e.ufCode = :ufCode ORDER BY c.id"),

})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="ibge_code")
    private int ibgeCode;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "uf_code", referencedColumnName = "uf_code")
    private Estado state;

    @Column(name="uf")
    private String uf;

    @Column(name="state")
    private String stateName;

    @Column(name="lat")
    private Double lat;

    @Column(name="lng")
    private Double lng;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(int ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Estado getState() {
        return state;
    }

    public void setState(Estado state) {
        this.state = state;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
