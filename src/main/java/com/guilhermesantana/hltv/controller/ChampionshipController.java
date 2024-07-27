package com.guilhermesantana.hltv.controller;

import com.guilhermesantana.hltv.domain.championship.Championship;
import com.guilhermesantana.hltv.domain.championship.ChampionshipRequest;
import com.guilhermesantana.hltv.domain.championship.ChampionshipResponse;
import com.guilhermesantana.hltv.service.ChampionshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListResourceBundle;

@RestController
@RequestMapping("/championship")
public class ChampionshipController {

    private ChampionshipService championshipService;

    public ChampionshipController(ChampionshipService championshipService){
        this.championshipService = championshipService;
    }

    @PostMapping
    public ResponseEntity<Championship> createChampionship(@RequestBody ChampionshipRequest data){
        Championship newChampionship = this.championshipService.createChampionship(data);
        return ResponseEntity.ok(newChampionship);
    }

    @GetMapping("/lan")
    public ResponseEntity<List<ChampionshipResponse>> findChampionshipsAndAddress(){
        List<ChampionshipResponse> championshipResponses = this.championshipService.findChampionshipsAndAddress();
        return ResponseEntity.ok(championshipResponses);
    }

    @GetMapping
    public ResponseEntity<List<Championship>> findChampionshipRemote(){
        List<Championship> championships = this.championshipService.findChampionshipRemote();
        return ResponseEntity.ok(championships);
    }
}
