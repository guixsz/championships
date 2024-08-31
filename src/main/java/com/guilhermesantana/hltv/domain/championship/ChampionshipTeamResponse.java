package com.guilhermesantana.hltv.domain.championship;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ChampionshipTeamResponse(String name, LocalDate startDate, LocalDate endDate, BigDecimal prizePool, EnumLocation location) {
}
