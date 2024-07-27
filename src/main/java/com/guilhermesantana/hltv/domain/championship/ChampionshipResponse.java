package com.guilhermesantana.hltv.domain.championship;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ChampionshipResponse (UUID id, String name, LocalDate startDate, LocalDate endDate, BigDecimal prizePool, Boolean lan, String city, String country, String province, String publicPLace){
}
