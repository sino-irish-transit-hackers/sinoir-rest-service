package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

import javax.persistence.*;

@CsvDataType
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"route_id", "agency_id"}))
public class Route {
    @CsvField(pos = 1, required = true)
    @Id
    @Column(name = "route_id")
    private String routeId;
    @CsvField(pos = 2)
    @Column(name = "agency_id", nullable = true)
    private String agencyId;
    @CsvField(pos = 3, required = true)
    @Column(name = "route_short_name")
    private String routeShortName;
    @CsvField(pos = 4, required = true)
    @Column(name = "route_long_name")
    private String routeLongName;
    @CsvField(pos = 5)
    @Column(name = "route_desc", length = 1000, nullable = true)
    private String routeDesc;
    @CsvField(pos = 6, required = true)
    @Column(name = "route_type")
    private Integer routeType;
    @CsvField(pos = 7)
    @Column(name = "route_url", nullable = true)
    private String routeUrl;
    @CsvField(pos = 8)
    @Column(name = "route_color", nullable = true)
    private String routeColor;
    @CsvField(pos = 9)
    @Column(name = "route_text_color", nullable = true)
    private String routeTextColor;

    public Route() {
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
        this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public String getRouteDesc() {
        return routeDesc;
    }

    public void setRouteDesc(String routeDesc) {
        this.routeDesc = routeDesc;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public void setRouteType(Integer routeType) {
        this.routeType = routeType;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public void setRouteColor(String routeColor) {
        this.routeColor = routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    public void setRouteTextColor(String routeTextColor) {
        this.routeTextColor = routeTextColor;
    }
}
