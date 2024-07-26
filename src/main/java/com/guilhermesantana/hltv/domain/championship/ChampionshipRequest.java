package com.guilhermesantana.hltv.domain.championship;

import java.math.BigDecimal;
import java.time.LocalDate;
;

public record ChampionshipRequest(String name, LocalDate date, BigDecimal prizePool, Boolean lan, String city, String country, String province, String publicPLace) {
}
