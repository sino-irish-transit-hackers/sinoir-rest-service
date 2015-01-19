package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@CsvDataType
@Entity
public class Stop {
    @CsvField(pos = 1, required = true)
    @Id
    @Column(name = "stop_id")
    private String stopId;
    @CsvField(pos = 2)
    @Column(name = "stop_code", nullable = true)
    private String stopCode;
    @CsvField(pos = 3, required = true)
    @Column(name = "stop_name")
    private String stopName;
    @CsvField(pos = 4)
    @Column(name = "stop_desc", nullable = true)
    private String stopDesc;
    @CsvField(pos = 5, required = true)
    @Column(name = "stop_lat")
    private BigDecimal stopLat;
    @CsvField(pos = 6, required = true)
    @Column(name = "stop_long")
    private BigDecimal stopLong;
    @CsvField(pos = 7)
    @Column(name = "zone_id", nullable = true)
    private String zoneId;
    @CsvField(pos = 8)
    @Column(name = "stop_url", nullable = true)
    private String stopUrl;
    @CsvField(pos = 9)
    @Column(name = "location_type", nullable = true)
    private Integer locationType;
    @CsvField(pos = 10)
    @Column(name = "parent_station", nullable = true)
    private String parentStation;
    @CsvField(pos = 11)
    @Column(name = "stop_timezone", nullable = true)
    private String stopTimezone;
    @CsvField(pos = 12)
    @Column(name = "wheelchair_boarding", nullable = true)
    private Integer wheelchairBoarding;

    public Stop() {
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public BigDecimal getStopLat() {
        return stopLat;
    }

    public void setStopLat(BigDecimal stopLat) {
        this.stopLat = stopLat;
    }

    public BigDecimal getStopLong() {
        return stopLong;
    }

    public void setStopLong(BigDecimal stopLong) {
        this.stopLong = stopLong;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getStopUrl() {
        return stopUrl;
    }

    public void setStopUrl(String stopUrl) {
        this.stopUrl = stopUrl;
    }

    public Integer getLocationType() {
        return locationType;
    }

    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
    }

    public String getParentStation() {
        return parentStation;
    }

    public void setParentStation(String parentStation) {
        this.parentStation = parentStation;
    }

    public String getStopTimezone() {
        return stopTimezone;
    }

    public void setStopTimezone(String stopTimezone) {
        this.stopTimezone = stopTimezone;
    }

    public Integer getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    public void setWheelchairBoarding(Integer wheelchairBoarding) {
        this.wheelchairBoarding = wheelchairBoarding;
    }
}
