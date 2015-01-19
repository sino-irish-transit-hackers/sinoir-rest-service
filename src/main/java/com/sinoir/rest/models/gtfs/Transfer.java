package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

import javax.persistence.*;

@CsvDataType
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"from_stop_id", "to_stop_id"}))
public class Transfer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @CsvField(pos = 1, required = true)
    @Column(name = "from_stop_id")
    private String fromStopId;
    @CsvField(pos = 2, required = true)
    @Column(name = "to_stop_id")
    private String toStopId;
    @CsvField(pos = 3, required = true)
    @Column(name = "transfer_type")
    private Integer transferType;
    @CsvField(pos = 4)
    @Column(name = "min_transfer_time")
    private Integer minTransferTime;

    public Transfer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromStopId() {
        return fromStopId;
    }

    public void setFromStopId(String fromStopId) {
        this.fromStopId = fromStopId;
    }

    public String getToStopId() {
        return toStopId;
    }

    public void setToStopId(String toStopId) {
        this.toStopId = toStopId;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Integer getMinTransferTime() {
        return minTransferTime;
    }

    public void setMinTransferTime(Integer minTransferTime) {
        this.minTransferTime = minTransferTime;
    }
}
