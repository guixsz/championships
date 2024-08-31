package com.guilhermesantana.hltv.domain.team;

import com.guilhermesantana.hltv.domain.championship.Championship;
import com.guilhermesantana.hltv.domain.championship.ChampionshipTeamResponse;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record TeamResponse(UUID id, String name, String ceo, Integer cnpj, LocalDate foundedYear, String founded, Set<ChampionshipTeamResponse> nameChampionship){
}
