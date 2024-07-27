package com.guilhermesantana.hltv.repositories;

import com.guilhermesantana.hltv.domain.championship.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, UUID> {

    @Query("SELECT e FROM Championship e JOIN e.address a")
    List<Championship> findChampionshipsAndAddress();

    @Query("SELECT e FROM Championship e WHERE e.lan = false")
    List<Championship> findChampionshipRemote();
}
