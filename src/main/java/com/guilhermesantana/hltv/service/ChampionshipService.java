package com.guilhermesantana.hltv.service;

import com.guilhermesantana.hltv.domain.championship.Championship;
import com.guilhermesantana.hltv.domain.championship.ChampionshipRequest;
import com.guilhermesantana.hltv.domain.championship.ChampionshipResponse;
import com.guilhermesantana.hltv.repositories.ChampionshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionshipService {

    private ChampionshipRepository championshipRepository;
    private AddressService addressService;

    public ChampionshipService(ChampionshipRepository championshipRepository, AddressService addressService){
        this.championshipRepository = championshipRepository;
        this.addressService = addressService;
    }

    public Championship createChampionship(ChampionshipRequest championshipRequest){
        Championship championShip = new Championship();
        championShip.setName(championshipRequest.name());
        championShip.setStartDate(championshipRequest.startDate());
        championShip.setEndDate(championshipRequest.endDate());
        championShip.setLan(championshipRequest.lan());
        championShip.setPrizePool(championshipRequest.prizePool());

        this.championshipRepository.save(championShip);

        if(championShip.getLan()){
            this.addressService.createAddress(championshipRequest, championShip);
        }

        return championShip;
    }

    public List<ChampionshipResponse> findChampionshipsAndAddress() {
        List<Championship> championships = this.championshipRepository.findChampionshipsAndAddress();

        return championships.stream()
                .map(championship -> new ChampionshipResponse(
                        championship.getId(),
                        championship.getName(),
                        championship.getStartDate(),
                        championship.getEndDate(),
                        championship.getPrizePool(),
                        championship.getLan(),
                        championship.getAddress() != null ? championship.getAddress().getCity() : "",
                        championship.getAddress() != null ? championship.getAddress().getCountry() : "",
                        championship.getAddress() != null ? championship.getAddress().getProvince() : "",
                        championship.getAddress() != null ? championship.getAddress().getPublicPlace() : ""
                ))
                .toList();
    }

    public List<Championship> findChampionshipRemote(){
        List<Championship> championships = this.championshipRepository.findChampionshipRemote();
        return championships;
    }
}
