package com.infotech.app.entity;

import com.infotech.app.dto.ChacaraDto;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="chacara")
@NamedQueries({
        @NamedQuery(name="Chacara.getAllChacaras", query="SELECT new com.infotech.app.dto.ChacaraDto(c.id, c.name, c.imageUrl, ci.name, c.price) FROM Chacara c INNER JOIN c.city ci ORDER BY c.id"),
        @NamedQuery(name="Chacara.getAllChacarasByCity", query="SELECT new com.infotech.app.dto.ChacaraDto(c.id, c.name, c.imageUrl, c.lat, c.lng) FROM Chacara c " +
                "INNER JOIN c.city ci " +
                "INNER JOIN ci.state st " +
                "WHERE ci.name like :city AND st.uf like :state ORDER BY c.id")
})
public class Chacara implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="chacara_name")
    private String name;

    @Column(name="main_image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cidade city;

    @Column(name="lat")
    private Double lat;

    @Column(name="lng")
    private Double lng;

    @Column(name="price")
    private Double price;

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

    public Cidade getCity() {
        return city;
    }

    public void setCity(Cidade city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public ChacaraDto asDto(){
        return new ChacaraDto(id, name, imageUrl, city.getName(), price);
    }
}
