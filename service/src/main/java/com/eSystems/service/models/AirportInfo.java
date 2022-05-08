package com.eSystems.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airportInfo")
public class AirportInfo {

    @Id
    @Column(name="ICAO_CODE", nullable = false)
    private String icaoCode;
    private String data;

}
