package com.eSystems.service.repositories;

import com.eSystems.service.models.AirportInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<AirportInfo, String> {

    @Query(value = "select ICAO_CODE from AIRPORT_INFO", nativeQuery = true)
    List<String> getAllSubscriptions();
}
