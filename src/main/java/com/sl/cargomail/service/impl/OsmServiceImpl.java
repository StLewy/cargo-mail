package com.sl.cargomail.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sl.cargomail.constant.OsmConstant;
import com.sl.cargomail.model.DTO.CompanyDTO;
import com.sl.cargomail.service.OsmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OsmServiceImpl implements OsmService {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public List<CompanyDTO> findCompanies(String city, String street, String houseNumber) {

        String url = OsmConstant.OSM_URL + "&city=" + city + "&street=" + houseNumber + " " + street;
        List<CompanyDTO> companies = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response;

        try {
            response = restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            LOGGER.error(OsmConstant.OSM_ERROR_CONNECTION);
            throw new ResponseStatusException(HttpStatus.valueOf(e.getRawStatusCode()), e.getMessage());
        }

        JsonElement element = new JsonParser().parse(Objects.requireNonNull(response.getBody()));
        JsonArray list = element.getAsJsonArray();

        for (JsonElement company : list) {
            CompanyDTO findCompany = new CompanyDTO();
            if (!company.getAsJsonObject().get("place_id").toString().equals("null")){
                findCompany.setPlaceId(company.getAsJsonObject().get("place_id").toString());
            }
            if (!company.getAsJsonObject().get("osm_id").toString().equals("null")){
                findCompany.setOsmId(company.getAsJsonObject().get("osm_id").toString());
            }
            if (!company.getAsJsonObject().get("lat").toString().equals("null")){
                findCompany.setLat(company.getAsJsonObject().get("lat").getAsString());
            }
            if (!company.getAsJsonObject().get("lon").toString().equals("null")){
                findCompany.setLon(company.getAsJsonObject().get("lon").getAsString());
            }
            if (!company.getAsJsonObject().get("address").getAsJsonObject().get("road").toString().equals("null")){
                findCompany.setAddressStreet(company.getAsJsonObject().get("address").getAsJsonObject().get("road").getAsString());
            }
            if (!company.getAsJsonObject().get("address").getAsJsonObject().get("postcode").toString().equals("null")){
                findCompany.setAddressPostCode(company.getAsJsonObject().get("address").getAsJsonObject().get("postcode").getAsString());
            }
            if (!company.getAsJsonObject().get("address").getAsJsonObject().get("country").toString().equals("null")){
                findCompany.setAddressCountry(company.getAsJsonObject().get("address").getAsJsonObject().get("country").getAsString());
            }
            if (!company.getAsJsonObject().get("address").getAsJsonObject().get("country_code").toString().equals("null")){
                findCompany.setAddressCountryCode(company.getAsJsonObject().get("address").getAsJsonObject().get("country_code").getAsString());
            }
            companies.add(findCompany);
        }
        return companies;
    }
}
