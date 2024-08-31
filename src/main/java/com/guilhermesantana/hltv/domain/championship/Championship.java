package com.guilhermesantana.hltv.domain.championship;

import com.guilhermesantana.hltv.domain.address.Address;
import com.guilhermesantana.hltv.domain.team.Team;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private  Boolean lan;
    private BigDecimal prizePool;

    @Enumerated(EnumType.STRING)
    private EnumLocation location;

    @OneToOne(mappedBy = "championship", cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(mappedBy = "championshipTeam")
    private List<Team> teams;

    public Championship() {
    }

    public Championship(UUID id, String name, LocalDate startDate, LocalDate endDate, Boolean lan, BigDecimal prizePool, EnumLocation location, Address address, List<Team> team) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lan = lan;
        this.prizePool = prizePool;
        this.location = location;
        this.address = address;
        this.teams = team;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public EnumLocation getLocation() {
        return location;
    }

    public void setLocation(EnumLocation location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Team> getTeam() {
        return teams;
    }

    public void setTeam(List<Team> team) {
        this.teams = team;
    }
}
