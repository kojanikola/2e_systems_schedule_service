package com.eSystems.service.repositories;

import com.eSystems.service.models.AirportInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<AirportInfo, String> {

}
