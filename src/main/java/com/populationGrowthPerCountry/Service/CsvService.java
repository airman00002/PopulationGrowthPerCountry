package com.populationGrowthPerCountry.Service;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.populationGrowthPerCountry.Model.PopulationGrowthPerCountryModel;
import com.populationGrowthPerCountry.Utils.ContinentOfCountry;

@Service
public class CsvService {

    // intialize response
    List<PopulationGrowthPerCountryModel> listModel = new ArrayList<>();

    @Autowired
    private ContinentOfCountry continentOfCounties;

    @PostConstruct
    public void init() {
        try {
            ClassPathResource resource = new ClassPathResource("inputFile/population-and-demography.csv");
            readCSVFile(resource);

        } catch (Exception e) {
            System.err.println("Path Error ❌");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void readCSVFile(ClassPathResource resource) {
        // try-with-resource
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream());
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setHeader().build())) {

            // loop each line of the CSV file
            for (CSVRecord csvRecord : csvParser) {

                // set country existing in continent ?
                String countryName = csvRecord.get("Country name");
                if (continentOfCounties.isExistingCountry(countryName)) {
                    // calculate the population each line
                    double totalDoublePopulation = Double.parseDouble(csvRecord.get("Population")) +
                            Double.parseDouble(csvRecord.get("Population of children under the age of 1")) +
                            Double.parseDouble(csvRecord.get("Population of children under the age of 5")) +
                            Double.parseDouble(csvRecord.get("Population of children under the age of 15")) +
                            Double.parseDouble(csvRecord.get("Population under the age of 25")) +
                            Double.parseDouble(csvRecord.get("Population aged 15 to 64 years")) +
                            Double.parseDouble(csvRecord.get("Population older than 15 years")) +
                            Double.parseDouble(csvRecord.get("Population older than 18 years")) +
                            Double.parseDouble(csvRecord.get("Population at age 1")) +
                            Double.parseDouble(csvRecord.get("Population aged 1 to 4 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 5 to 9 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 10 to 14 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 15 to 19 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 20 to 29 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 30 to 39 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 40 to 49 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 50 to 59 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 60 to 69 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 70 to 79 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 80 to 89 years")) +
                            Double.parseDouble(csvRecord.get("Population aged 90 to 99 years")) +
                            Double.parseDouble(csvRecord.get("Population older than 100 years"));

                    Long totalLongPopulation = (long) Math.ceil(totalDoublePopulation);

                    // set each line
                    PopulationGrowthPerCountryModel populationGrowthPerCountryModel = new PopulationGrowthPerCountryModel(
                            countryName,
                            continentOfCounties.findContinentOfCountry(countryName),
                            Integer.parseInt(csvRecord.get("Year")),
                            totalLongPopulation);

                    // add list per record
                    listModel.add(populationGrowthPerCountryModel);
                }
            }
        } catch (

        Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<PopulationGrowthPerCountryModel> getPopulationGrowthPerCountry() {
        return listModel;
    }

}
