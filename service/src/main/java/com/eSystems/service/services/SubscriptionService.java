package com.eSystems.service.services;

import com.eSystems.service.exceptions.CustomException;
import com.eSystems.service.models.AirportInfo;
import com.eSystems.service.models.SubscriptionResponse;
import com.eSystems.service.repositories.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionResponse newSubscription(AirportInfo airportInfo) throws CustomException {
        try {

            subscriptionRepository.save(airportInfo);
            SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
            subscriptionResponse.setSuccessful(true);
            subscriptionResponse.setIcaoCode(airportInfo.getIcaoCode());
            return subscriptionResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(HttpStatus.METHOD_NOT_ALLOWED,
                    "We were unavailable to perform request. Please try again later");
        }
    }

}

