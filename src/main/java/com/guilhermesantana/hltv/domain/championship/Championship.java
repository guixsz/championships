package com.guilhermesantana.hltv.domain.championship;

import com.guilhermesantana.hltv.domain.address.Address;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private LocalDate date;
    private  Boolean lan;
    private BigDecimal prizePool;

    @OneToOne(mappedBy = "championship", cascade = CascadeType.ALL)
    private Address address;

    public Championship() {
    }

    public Championship(UUID id, String name, LocalDate date, Boolean lan, BigDecimal prizePool, Address address) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.lan = lan;
        this.prizePool = prizePool;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getLan() {
        return lan;
    }

    public void setLan(Boolean lan) {
        this.lan = lan;
    }

    public BigDecimal getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(BigDecimal prizePool) {
        this.prizePool = prizePool;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
