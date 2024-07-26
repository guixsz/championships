package com.guilhermesantana.hltv.service;

import com.guilhermesantana.hltv.domain.address.Address;
import com.guilhermesantana.hltv.domain.championship.Championship;
import com.guilhermesantana.hltv.domain.championship.ChampionshipRequest;
import com.guilhermesantana.hltv.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public Address createAddress(ChampionshipRequest championshipRequest, Championship championship){
        Address address = new Address();
        address.setCity(championshipRequest.city());
        address.setCountry(championshipRequest.country());
        address.setProvince(championshipRequest.province());
        address.setPublicPlace(championshipRequest.publicPLace());
        address.setChampionship(championship);

        return addressRepository.save(address);
    }
}
