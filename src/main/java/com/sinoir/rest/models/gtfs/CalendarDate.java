package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.util.Date;

@CsvDataType
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"service_id", "date", "exception_type"}))
public class CalendarDate {
    public static interface Repository extends CrudRepository<CalendarDate, Integer> {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @CsvField(pos = 1, required = true)
    @Column(name = "service_id")
    private String serviceId;
    @CsvField(pos = 2, format = "yyyyMMdd", required = true)
    @Column
    private Date date;
    @CsvField(pos = 3, required = true)
    @Column(name = "exception_type")
    private Integer exceptionType;

    public CalendarDate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(Integer exceptionType) {
        this.exceptionType = exceptionType;
    }
}
