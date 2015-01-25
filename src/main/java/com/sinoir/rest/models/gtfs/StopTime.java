package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@CsvDataType
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"trip_id", "arrival_time", "stop_id", "stop_sequence"}))
public class StopTime {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @CsvField(pos = 1, required = true)
    @Column(name = "trip_id")
    private String tripId;
    @CsvField(pos = 2, required = true)
    @Column(name = "arrival_time")
    private String arrivalTime;
    @CsvField(pos = 3, required = true)
    @Column(name = "departure_time")
    private String departureTime;
    @CsvField(pos = 4, required = true)
    @Column(name = "stop_id")
    private String stopId;
    @CsvField(pos = 5, required = true)
    @Column(name = "stop_sequence")
    private Integer stopSequence;
    @CsvField(pos = 6)
    @Column(name = "stop_headsign", nullable = true)
    private String stopHeadsign;
    @CsvField(pos = 7)
    @Column(name = "pickup_type", nullable = true)
    private Integer pickupType;
    @CsvField(pos = 8)
    @Column(name = "shape_dist_traveled", nullable = true)
    private BigDecimal shapeDistTraveled;

    public StopTime() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public Integer getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(Integer stopSequence) {
        this.stopSequence = stopSequence;
    }

    public String getStopHeadsign() {
        return stopHeadsign;
    }

    public void setStopHeadsign(String stopHeadsign) {
        this.stopHeadsign = stopHeadsign;
    }

    public Integer getPickupType() {
        return pickupType;
    }

    public void setPickupType(Integer pickupType) {
        this.pickupType = pickupType;
    }

    public BigDecimal getShapeDistTraveled() {
        return shapeDistTraveled;
    }

    public void setShapeDistTraveled(BigDecimal shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }
}
