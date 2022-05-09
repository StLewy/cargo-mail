package com.sl.cargomail.controller;

import com.sl.cargomail.model.DTO.CompanyDTO;
import com.sl.cargomail.service.OsmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/osm")
public class OsmController {
    private final OsmService osmService;

    public OsmController(OsmService osmService) {
        this.osmService = osmService;
    }

    @GetMapping("findCompanyAddress")
    public ResponseEntity<List<CompanyDTO>> findCompaniesAddress(@RequestParam("city") String city,
                                                                  @RequestParam(value = "houseNumber", required = false) String houseNumber,
                                                                  @RequestParam("street") String street){
        List<CompanyDTO> companies = osmService.findCompanies(city,street,houseNumber);
        return new ResponseEntity<>(companies, OK);
    }
}
