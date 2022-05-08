package com.eSystems.service.repositories;

import com.eSystems.service.models.AirportInfo;
import com.eSystems.service.models.MetarData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<AirportInfo, String> {

    @Query(value = "select ICAO_CODE from AIRPORT_INFO", nativeQuery = true)
    List<String> getAllSubscriptions();

    @Modifying
    @Transactional
    @Query(value = "update AIRPORT_INFO set data=:metarData where ICAO_CODE=:icaoCode", nativeQuery = true)
    Integer updateMetarData(String metarData, String icaoCode);
}
