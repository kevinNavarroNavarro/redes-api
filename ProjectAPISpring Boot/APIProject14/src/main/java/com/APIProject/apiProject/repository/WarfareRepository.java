package com.APIProject.apiProject.repository;

import com.APIProject.apiProject.domain.business.Warfare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WarfareRepository extends JpaRepository<Warfare, Integer> {


    @Query("SELECT w FROM Warfare w WHERE w.warfareName=:warfare")
    List<Warfare> findByWarfareName(@Param("warfare") String warfare);


    @Query("SELECT s FROM Warfare s WHERE s.email=:email")
    List<Warfare> findByEmail(@Param("email") String email);


    @Query("SELECT s FROM Warfare s WHERE s.faction=:faction")
    List<Warfare> findByFaction(@Param("faction") String faction);

}
