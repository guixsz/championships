package com.guilhermesantana.hltv.domain.team;

import com.guilhermesantana.hltv.domain.championship.Championship;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String ceo;

    @Column(unique = true)
    private Integer cnpj;

    @Column(name = "founded_year")
    private LocalDate foundedYear;
    private String founded;

    @ManyToMany
    @JoinTable(
            name = "team_championship",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "championship_id")
    )
    private Set<Championship> championshipTeam;

    public Team() {
    }

    public Team(UUID id, String name, String ceo, Integer cnpj, LocalDate foundedYear, String founded, Set<Championship> championshipTeam) {
        this.id = id;
        this.name = name;
        this.ceo = ceo;
        this.cnpj = cnpj;
        this.foundedYear = foundedYear;
        this.founded = founded;
        this.championshipTeam = championshipTeam;
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

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(LocalDate foundedYear) {
        this.foundedYear = foundedYear;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public Set<Championship> getChampionshipTeam() {
        return championshipTeam;
    }

    public void setChampionshipTeam(Set<Championship> championshipTeam) {
        this.championshipTeam = championshipTeam;
    }
}
