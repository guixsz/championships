package com.guilhermesantana.hltv.domain.address;

import com.guilhermesantana.hltv.domain.championship.Championship;
import jakarta.persistence.*;


import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String publicPlace;
    private String province;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Championship championship;

    public Address() {
    }

    public Address(UUID id, String publicPlace, String province, String city, String country, Championship championship) {
        this.id = id;
        this.publicPlace = publicPlace;
        this.province = province;
        this.city = city;
        this.country = country;
        this.championship = championship;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }
}
