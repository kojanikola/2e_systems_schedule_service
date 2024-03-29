package com.eSystems.service.controllers;

import com.eSystems.service.exceptions.CustomException;
import com.eSystems.service.models.AirportInfo;
import com.eSystems.service.models.SubscriptionResponse;
import com.eSystems.service.services.SubscriptionService;
import com.eSystems.service.validators.AirportSubscriptionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private AirportSubscriptionValidator subscriptionValidator;

    @PostMapping(value = "/subscriptions")
    public ResponseEntity<SubscriptionResponse> newSubscription(@RequestBody AirportInfo airportInfo) throws CustomException {
        subscriptionValidator.validateMultipleSubscription(airportInfo.getIcaoCode());
        return new ResponseEntity<>(subscriptionService.newSubscription(airportInfo), HttpStatus.OK);
    }

    @GetMapping(value="/subscriptions")
    public ResponseEntity<List<String>> getAllSubscriptions() throws CustomException {
        return new ResponseEntity(subscriptionService.getAllSubscriptions(), HttpStatus.OK);
    }

    @DeleteMapping(value="/subscriptions/{icaoCode}")
    public ResponseEntity<SubscriptionResponse> deleteSubscription(@PathVariable String icaoCode) throws CustomException {
        return new ResponseEntity(subscriptionService.deleteSubscription(icaoCode), HttpStatus.OK);
    }
}
