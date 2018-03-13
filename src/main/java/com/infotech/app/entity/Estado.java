package com.infotech.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="state")
@NamedQueries({
        @NamedQuery(name="State.getAllStatesWithCities", query="SELECT new com.infotech.app.dto.StateDto(e.id, e.name, e.ufCode) FROM Estado e ORDER BY e.id"),
})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="uf_code")
    private int ufCode;

    @Column(name="name")
    private String name;

    @Column(name="uf")
    private String uf;

    @Column(name="region")
    private int region;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUfCode() {
        return ufCode;
    }

    public void setUfCode(int ufCode) {
        this.ufCode = ufCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }
}
