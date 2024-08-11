package com.populationGrowthPerCountry.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Populations {
    private Double population;
    private Double populationUnder1;
    private Double populationUnder5;
    private Double populationUnder15;
    private Double populationUnder25;
    private Double population15to64;
    private Double populationOver15;
    private Double populationOver18;
    private Double populationAge1;
    private Double population1to4;
    private Double population5to9;
    private Double population10to14;
    private Double population15to19;
    private Double population20to29;
    private Double population30to39;
    private Double population40to49;
    private Double population50to59;
    private Double population60to69;
    private Double population70to79;
    private Double population80to89;
    private Double population90to99;
    private Double populationOver100;
}
