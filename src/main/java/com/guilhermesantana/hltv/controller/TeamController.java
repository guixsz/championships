package com.guilhermesantana.hltv.controller;

import com.guilhermesantana.hltv.domain.team.Team;
import com.guilhermesantana.hltv.domain.team.TeamResponse;
import com.guilhermesantana.hltv.domain.team.TeamRequest;
import com.guilhermesantana.hltv.service.TeamService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/team")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamRequest teamRequest) {
        Team team = this.teamService.createTeam(teamRequest);
        return ResponseEntity.ok(team);
    }

    @PutMapping("/add")
    public ResponseEntity<Team> addChampionship(@RequestParam UUID teamId,
                                                @RequestParam UUID championshipId){

       Team team = teamService.addChampionship(teamId, championshipId);
       return ResponseEntity.ok(team);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TeamResponse>> findTeamAndChampionship(@PathVariable("id") UUID uuid){
        List<TeamResponse> teamAndChampionship = teamService.findChampionshipAndTeam(uuid);
        return ResponseEntity.ok(teamAndChampionship);
    }
}
