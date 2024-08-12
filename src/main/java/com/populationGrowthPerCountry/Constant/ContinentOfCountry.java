package com.populationGrowthPerCountry.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class ContinentOfCountry {

        private final Map<String, List<String>> continentCountries;

        public ContinentOfCountry() {
                continentCountries = new HashMap<>();
                initializeContinents();
        }

        private void initializeContinents() {
                continentCountries.put("Asia", Arrays.asList(
                                "Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh", "Bhutan", "Brunei",
                                "Cambodia",
                                "China", "Cyprus", "Georgia", "Hong Kong", "India", "Indonesia", "Iran", "Iraq",
                                "Israel", "Japan",
                                "Jordan", "Kazakhstan", "Kuwait", "Kyrgyzstan", "Laos", "Lebanon", "Macao", "Malaysia",
                                "Maldives",
                                "Mongolia", "Myanmar", "Nepal", "North Korea", "Oman", "Pakistan", "Palestine",
                                "Philippines",
                                "Qatar", "Saudi Arabia", "Singapore", "South Korea", "Sri Lanka", "Syria", "Taiwan",
                                "Tajikistan",
                                "Thailand", "East Timor", "Turkey", "Turkmenistan", "United Arab Emirates",
                                "Uzbekistan", "Vietnam",
                                "Yemen"));

                continentCountries.put("Europe", Arrays.asList(
                                "Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia and Herzegovina",
                                "Bulgaria",
                                "Croatia", "Czechia", "Denmark", "Estonia", "Faroe Islands", "Finland", "France",
                                "Germany",
                                "Gibraltar", "Greece", "Guernsey", "Hungary", "Iceland", "Ireland", "Isle of Man",
                                "Italy",
                                "Jersey", "Kosovo", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Malta",
                                "Moldova",
                                "Monaco", "Montenegro", "Netherlands", "North Macedonia", "Norway", "Poland",
                                "Portugal",
                                "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden",
                                "Switzerland", "Ukraine", "United Kingdom"));

                continentCountries.put("Africa", Arrays.asList(
                                "Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cameroon",
                                "Cape Verde",
                                "Central African Republic", "Chad", "Comoros", "Congo", "Cote d'Ivoire",
                                "Democratic Republic of Congo",
                                "Djibouti", "Egypt", "Equatorial Guinea", "Eritrea", "Eswatini", "Ethiopia", "Gabon",
                                "Gambia",
                                "Ghana", "Guinea", "Guinea-Bissau", "Kenya", "Lesotho", "Liberia", "Libya",
                                "Madagascar", "Malawi",
                                "Mali", "Mauritania", "Mauritius", "Morocco", "Mozambique", "Namibia", "Niger",
                                "Nigeria", "Rwanda",
                                "Sao Tome and Principe", "Senegal", "Seychelles", "Sierra Leone", "Somalia",
                                "South Africa",
                                "South Sudan", "Sudan", "Tanzania", "Togo", "Tunisia", "Uganda", "Western Sahara",
                                "Zambia",
                                "Zimbabwe"));

                continentCountries.put("Oceania", Arrays.asList(
                                "American Samoa", "Australia", "Cook Islands", "Fiji", "French Polynesia", "Guam",
                                "Kiribati",
                                "Marshall Islands", "Micronesia", "Nauru", "New Caledonia", "New Zealand", "Niue",
                                "Northern Mariana Islands", "Palau", "Papua New Guinea", "Samoa", "Solomon Islands",
                                "Tokelau",
                                "Tonga", "Tuvalu", "Vanuatu", "Wallis and Futuna"));

                continentCountries.put("Americas", Arrays.asList(
                                "Antigua and Barbuda", "Argentina", "Aruba", "Bahamas", "Barbados", "Belize", "Bermuda",
                                "Bolivia",
                                "Bonaire Sint Eustatius and Saba", "Brazil", "British Virgin Islands", "Canada",
                                "Cayman Islands",
                                "Chile", "Colombia", "Costa Rica", "Cuba", "Curacao", "Dominica", "Dominican Republic",
                                "Ecuador",
                                "El Salvador", "Falkland Islands", "French Guiana", "Greenland", "Grenada",
                                "Guadeloupe", "Guatemala",
                                "Guyana", "Haiti", "Honduras", "Jamaica", "Martinique", "Mexico", "Montserrat",
                                "Nicaragua", "Panama",
                                "Paraguay", "Peru", "Puerto Rico", "Saint Barthelemy", "Saint Kitts and Nevis",
                                "Saint Lucia",
                                "Saint Martin (French part)", "Saint Pierre and Miquelon",
                                "Saint Vincent and the Grenadines",
                                "Sint Maarten (Dutch part)", "Suriname", "Trinidad and Tobago",
                                "Turks and Caicos Islands",
                                "United States", "United States Virgin Islands", "Uruguay", "Venezuela"));
        }

        // Summary CountryName
        public int getTotalCountries() {
                return continentCountries.values().stream()
                                .mapToInt(List::size)
                                .sum();
        }

        // Get All countryName
        public List<String> getCounties() {
                return continentCountries.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        }

        // Check Country Existing in Continent
        public boolean isExistingCountry(String inputCountry) {
                return continentCountries.values().stream()
                                .flatMap(List::stream)
                                .anyMatch(country -> country.equalsIgnoreCase(inputCountry));
        }

        public String findContinentOfCountry(String inputCountry) {

                return continentCountries.entrySet().stream().filter(entry -> entry.getValue().contains(inputCountry))
                                .map(Map.Entry::getKey).findFirst().orElse("None");
        }
}