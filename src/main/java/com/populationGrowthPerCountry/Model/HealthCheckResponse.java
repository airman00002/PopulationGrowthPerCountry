package com.populationGrowthPerCountry.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthCheckResponse {
    private Integer status;
    private String description;
}
