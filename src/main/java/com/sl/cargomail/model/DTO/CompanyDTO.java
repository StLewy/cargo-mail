package com.sl.cargomail.model.DTO;

public class CompanyDTO {

    private String placeId;
    private String osmId;
    private String addressCity;
    private String addressPostCode;
    private String addressStreet;
    private String addressHouseNumber;
    private String addressApartmentNumber;
    private String addressCountry;
    private String addressCountryCode;
    private String lat;
    private String lon;

    public CompanyDTO(String placeId, String osmId, String addressCity, String addressPostCode, String addressStreet, String addressHouseNumber, String addressApartmentNumber, String addressCountry, String addressCountryCode, String lat, String lon) {
        this.placeId = placeId;
        this.osmId = osmId;
        this.addressCity = addressCity;
        this.addressPostCode = addressPostCode;
        this.addressStreet = addressStreet;
        this.addressHouseNumber = addressHouseNumber;
        this.addressApartmentNumber = addressApartmentNumber;
        this.addressCountry = addressCountry;
        this.addressCountryCode = addressCountryCode;
        this.lat = lat;
        this.lon = lon;
    }

    public CompanyDTO() {
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getOsmId() {
        return osmId;
    }

    public void setOsmId(String osmId) {
        this.osmId = osmId;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPostCode() {
        return addressPostCode;
    }

    public void setAddressPostCode(String addressPostCode) {
        this.addressPostCode = addressPostCode;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressHouseNumber() {
        return addressHouseNumber;
    }

    public void setAddressHouseNumber(String addressHouseNumber) {
        this.addressHouseNumber = addressHouseNumber;
    }

    public String getAddressApartmentNumber() {
        return addressApartmentNumber;
    }

    public void setAddressApartmentNumber(String addressApartmentNumber) {
        this.addressApartmentNumber = addressApartmentNumber;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressCountryCode() {
        return addressCountryCode;
    }

    public void setAddressCountryCode(String addressCountryCode) {
        this.addressCountryCode = addressCountryCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
