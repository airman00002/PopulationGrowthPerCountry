package com.populationGrowthPerCountry.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.populationGrowthPerCountry.Model.PopulationGrowthPerCountryModel;
import com.populationGrowthPerCountry.Service.CsvService;

@RestController
public class PopulationController {

    @Autowired
    private CsvService csvService;

    @GetMapping("/populationGrowthPerCountry")
    public ResponseEntity<List<PopulationGrowthPerCountryModel>> getPopulation() {

        List<PopulationGrowthPerCountryModel> response = csvService.getPopulationGrowthPerCountry();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    
}