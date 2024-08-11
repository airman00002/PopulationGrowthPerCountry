package com.populationGrowthPerCountry.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.populationGrowthPerCountry.Model.HealthCheckResponse;

@RestController
public class HealthCheck {

    
    @GetMapping("/healthCheck")
    public ResponseEntity<HealthCheckResponse> healthCheck() {

        HealthCheckResponse response = new HealthCheckResponse(200, "Success");

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
