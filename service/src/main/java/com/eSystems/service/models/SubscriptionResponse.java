package com.eSystems.service.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscriptionResponse {
    private String icaoCode;
    private Boolean successful;
}
