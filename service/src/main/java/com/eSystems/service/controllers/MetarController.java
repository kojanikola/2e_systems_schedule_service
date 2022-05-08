package com.eSystems.service.controllers;

import com.eSystems.service.exceptions.CustomException;
import com.eSystems.service.models.AirportInfo;
import com.eSystems.service.models.MetarData;
import com.eSystems.service.models.SubscriptionResponse;
import com.eSystems.service.services.MetarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class MetarController {

    @Autowired
    private MetarService metarService;

    @PostMapping(value = "/airport/{icaoCode}/METAR")
    public ResponseEntity<SubscriptionResponse> updateMetarData(@PathVariable String icaoCode,
                                                                @RequestBody MetarData metarData) throws CustomException {
        return new ResponseEntity(metarService.updateMetarData(metarData, icaoCode), HttpStatus.OK);
    }

}
