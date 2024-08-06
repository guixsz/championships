package com.guilhermesantana.hltv.service;

import com.guilhermesantana.hltv.domain.championship.Championship;
import com.guilhermesantana.hltv.domain.team.Team;
import com.guilhermesantana.hltv.domain.team.TeamReponse;
import com.guilhermesantana.hltv.domain.team.TeamRequest;
import com.guilhermesantana.hltv.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    private TeamRepository teamRepository;
    private ChampionshipService championshipService;

    public TeamService(TeamRepository teamRepository, ChampionshipService championshipService){
        this.teamRepository = teamRepository;
        this.championshipService = championshipService;
    }

    public Team createTeam(TeamRequest teamRequest){
        Team newTeam = new Team();
        newTeam.setName(teamRequest.name());
        newTeam.setCeo(teamRequest.ceo());
        newTeam.setCnpj(teamRequest.cnpj());
        newTeam.setFoundedYear(teamRequest.foundedYear());
        newTeam.setFounded(teamRequest.founded());

        this.teamRepository.save(newTeam);
        return newTeam;
    }

    public Team addChampionship(UUID teamId, UUID championshipId){
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("id not found"));
        Championship championship = this.championshipService.findById(championshipId);

        team.getChampionshipTeam().add(championship);
        return this.teamRepository.save(team);
    }

    public List<TeamReponse> findChampionshipAndTeam(){
        List<Team> teamList = this.teamRepository.findTeamAndChampionships();
        return teamList.stream()
                .map(team -> new TeamReponse(
                        team.getId(),
                        team.getName(),
                        team.getCeo(),
                        team.getCnpj(),
                        team.getFoundedYear(),
                        team.getFounded(),
                        team.getChampionshipTeam()
                ))
                .toList();
    }
}
