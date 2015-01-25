package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.util.Date;

@CsvDataType
@Entity
public class Calendar {
    @CsvField(pos = 1, required = true)
    @Id
    private String serviceId;
    @CsvField(pos = 2, required = true)
    @Column
    private Integer monday;
    @CsvField(pos = 3, required = true)
    @Column
    private Integer tuesday;
    @CsvField(pos = 4, required = true)
    @Column
    private Integer wednesday;
    @CsvField(pos = 5, required = true)
    @Column
    private Integer thursday;
    @CsvField(pos = 6, required = true)
    @Column
    private Integer friday;
    @CsvField(pos = 7, required = true)
    @Column
    private Integer saturday;
    @CsvField(pos = 8, required = true)
    @Column
    private Integer sunday;
    @CsvField(pos = 9, format = "yyyyMMdd", required = true)
    @Column(name = "start_date")
    private Date startDate;
    @CsvField(pos = 10, format = "yyyyMMdd", required = true)
    @Column(name = "start_end")
    private Date startEnd;

    public Calendar() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getMonday() {
        return monday;
    }

    public void setMonday(Integer monday) {
        this.monday = monday;
    }

    public Integer getTuesday() {
        return tuesday;
    }

    public void setTuesday(Integer tuesday) {
        this.tuesday = tuesday;
    }

    public Integer getWednesday() {
        return wednesday;
    }

    public void setWednesday(Integer wednesday) {
        this.wednesday = wednesday;
    }

    public Integer getThursday() {
        return thursday;
    }

    public void setThursday(Integer thursday) {
        this.thursday = thursday;
    }

    public Integer getFriday() {
        return friday;
    }

    public void setFriday(Integer friday) {
        this.friday = friday;
    }

    public Integer getSaturday() {
        return saturday;
    }

    public void setSaturday(Integer saturday) {
        this.saturday = saturday;
    }

    public Integer getSunday() {
        return sunday;
    }

    public void setSunday(Integer sunday) {
        this.sunday = sunday;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartEnd() {
        return startEnd;
    }

    public void setStartEnd(Date startEnd) {
        this.startEnd = startEnd;
    }
}
