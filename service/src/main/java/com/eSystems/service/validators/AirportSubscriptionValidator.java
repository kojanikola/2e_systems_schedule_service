package com.eSystems.service.validators;

import com.eSystems.service.exceptions.CustomException;
import com.eSystems.service.models.AirportInfo;
import com.eSystems.service.repositories.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
@Slf4j
public class AirportSubscriptionValidator {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void validateMultipleSubscription(String icaoCode) throws CustomException {
        if (subscriptionRepository.existsById(icaoCode))
            throw new CustomException(HttpStatus.BAD_REQUEST, "Already subscribed!");
    }

}
