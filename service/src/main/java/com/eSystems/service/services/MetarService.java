package com.eSystems.service.services;

import com.eSystems.service.exceptions.CustomException;
import com.eSystems.service.models.AirportInfo;
import com.eSystems.service.models.MetarData;
import com.eSystems.service.models.SubscriptionResponse;
import com.eSystems.service.repositories.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MetarService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionResponse updateMetarData(MetarData metarData, String icaoCode) throws CustomException {
        Integer rowsAffected = subscriptionRepository.updateMetarData(metarData.getData(),icaoCode);

        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.setIcaoCode(icaoCode);

        if(rowsAffected!=0){
            subscriptionResponse.setSuccessful(true);
        }else{
            throw new CustomException(HttpStatus.BAD_REQUEST, "No subscription for this Airport!");
        }

        return subscriptionResponse;
    }
}
