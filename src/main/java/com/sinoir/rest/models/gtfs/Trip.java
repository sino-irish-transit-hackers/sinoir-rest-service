package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

import javax.persistence.*;

@CsvDataType
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"route_id", "service_id", "trip_id"}))

public class Trip {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @CsvField(pos = 1, required = true)
    @Column(name = "route_id")
    private String routeId;
    @CsvField(pos = 2, required = true)
    @Column(name = "service_id")
    private String serviceId;
    @CsvField(pos = 3, required = true)
    @Column(name = "trip_id")
    private String tripId;
    @CsvField(pos = 4)
    @Column(name = "trip_headsign", nullable = true)
    private String tripHeadsign;
    @CsvField(pos = 5)
    @Column(name = "trip_short_name", nullable = true)
    private String tripShortName;
    @CsvField(pos = 6)
    @Column(name = "direction_id", nullable = true)
    private Integer directionId;
    @CsvField(pos = 7)
    @Column(name = "block_id", nullable = true)
    private String blockId;
    @CsvField(pos = 8)
    @Column(name = "shape_id", nullable = true)
    private String shapeId;
    @CsvField(pos = 9)
    @Column(name = "wheelchair_accessible", nullable = true)
    private Integer wheelchairAccessible;
    @CsvField(pos = 10)
    @Column(name = "bikes_allowed", nullable = true)
    private Integer bikesAllowed;

    public Trip() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
        this.tripHeadsign = tripHeadsign;
    }

    public String getTripShortName() {
        return tripShortName;
    }

    public void setTripShortName(String tripShortName) {
        this.tripShortName = tripShortName;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getShapeId() {
        return shapeId;
    }

    public void setShapeId(String shapeId) {
        this.shapeId = shapeId;
    }

    public Integer getWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public void setWheelchairAccessible(Integer wheelchairAccessible) {
        this.wheelchairAccessible = wheelchairAccessible;
    }

    public Integer getBikesAllowed() {
        return bikesAllowed;
    }

    public void setBikesAllowed(Integer bikesAllowed) {
        this.bikesAllowed = bikesAllowed;
    }
}
