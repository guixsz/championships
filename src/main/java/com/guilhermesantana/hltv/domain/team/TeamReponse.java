package com.guilhermesantana.hltv.domain.team;

import com.guilhermesantana.hltv.domain.championship.Championship;
import com.guilhermesantana.hltv.domain.championship.ChampionshipResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record TeamReponse(UUID id, String name, String ceo, Integer cnpj, LocalDate foundedYear, String founded, Set<Championship> nameChampionship){
}
