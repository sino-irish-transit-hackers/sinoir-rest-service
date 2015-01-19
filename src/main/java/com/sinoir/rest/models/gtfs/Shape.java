package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

import javax.persistence.*;
import java.math.BigDecimal;

@CsvDataType
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"shape_id", "shape_pt_lat", "shape_pt_lon", "shape_dist_traveled"}))
public class Shape {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @CsvField(pos = 1, required = true)
    @Column(name = "shape_id")
    private String shapeId;
    @CsvField(pos = 2, required = true)
    @Column(name = "shape_pt_lat")
    private BigDecimal shapePtLat;
    @CsvField(pos = 3, required = true)
    @Column(name = "shape_pt_lon")
    private BigDecimal shapePtLon;
    @CsvField(pos = 4)
    @Column(name = "shape_dist_traveled", nullable = true)
    private BigDecimal shapeDistTraveled;

    public Shape() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShapeId() {
        return shapeId;
    }

    public void setShapeId(String shapeId) {
        this.shapeId = shapeId;
    }

    public BigDecimal getShapePtLat() {
        return shapePtLat;
    }

    public void setShapePtLat(BigDecimal shapePtLat) {
        this.shapePtLat = shapePtLat;
    }

    public BigDecimal getShapePtLon() {
        return shapePtLon;
    }

    public void setShapePtLon(BigDecimal shapePtLon) {
        this.shapePtLon = shapePtLon;
    }

    public BigDecimal getShapeDistTraveled() {
        return shapeDistTraveled;
    }

    public void setShapeDistTraveled(BigDecimal shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }
}
