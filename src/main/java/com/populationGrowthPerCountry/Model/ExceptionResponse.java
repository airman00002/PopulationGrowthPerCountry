package com.populationGrowthPerCountry.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private int status;
    private String message;
}
