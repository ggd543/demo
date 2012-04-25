package com.ggd543.dbutil;

/**
 * User: 刘永健
 * Date: 12-3-26
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class City {
    private String cityCN;
    private String cityEN;
    private Boolean isDomestic;
    private Boolean isHotCity;
    private String cityCode;
    private String airportEN;
    private String airportCN;

    public String getCityCN() {
        return cityCN;
    }

    public void setCityCN(String cityCN) {
        this.cityCN = cityCN;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public Boolean getIsDomestic() {
        return isDomestic;
    }

    public void setIsDomestic(Boolean domestic) {
        isDomestic = domestic;
    }

    public Boolean getIsHotCity() {
        return isHotCity;
    }

    public void setIsHotCity(Boolean hotCity) {
        isHotCity = hotCity;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAirportEN() {
        return airportEN;
    }

    public void setAirportEN(String airportEN) {
        this.airportEN = airportEN;
    }

    public String getAirportCN() {
        return airportCN;
    }

    public void setAirportCN(String airportCN) {
        this.airportCN = airportCN;
    }
}
