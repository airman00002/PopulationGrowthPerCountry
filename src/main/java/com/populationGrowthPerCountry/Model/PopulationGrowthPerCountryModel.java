package com.populationGrowthPerCountry.Model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PopulationGrowthPerCountryModel {
    private String countryName;
    private Integer year;
    private Populations populations;

}
    