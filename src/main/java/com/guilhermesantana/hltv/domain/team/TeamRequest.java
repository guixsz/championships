package com.guilhermesantana.hltv.domain.team;

import com.guilhermesantana.hltv.domain.championship.Championship;

import java.time.LocalDate;
import java.util.Set;

public record TeamRequest(String name, String ceo, Integer cnpj, LocalDate foundedYear, String founded, Set<Championship> championshipTeam) {
}
