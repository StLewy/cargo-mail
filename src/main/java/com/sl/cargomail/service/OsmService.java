package com.sl.cargomail.service;

import com.sl.cargomail.model.DTO.CompanyDTO;

import java.util.List;

public interface OsmService {

List<CompanyDTO> findCompanies(String city, String street, String houseNumber);
}
