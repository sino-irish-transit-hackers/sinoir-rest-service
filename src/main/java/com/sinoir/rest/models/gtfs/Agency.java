package com.sinoir.rest.models.gtfs;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;

@CsvDataType
@Entity
public class Agency {
    @CsvField(pos = 1, required = true)
    @Id
    private String agencyId;
    @CsvField(pos = 2, required = true)
    @Column(name = "agency_name")
    private String agencyName;
    @CsvField(pos = 3, required = true)
    @Column(name = "agency_url")
    private String agencyUrl;
    @CsvField(pos = 4, required = true)
    @Column(name = "agency_timezone")
    private String agencyTimezone;
    @CsvField(pos = 5)
    @Column(name = "agency_lang", nullable = true)
    private String agencyLang;
    @CsvField(pos = 6)
    @Column(name = "agency_phone", nullable = true)
    private String agencyPhone;
    @CsvField(pos = 7)
    @Column(name = "agency_fare_url", nullable = true)
    private String agencyFareUrl;

    public Agency() {
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    public String getAgencyTimezone() {
        return agencyTimezone;
    }

    public void setAgencyTimezone(String agencyTimezone) {
        this.agencyTimezone = agencyTimezone;
    }

    public String getAgencyLang() {
        return agencyLang;
    }

    public void setAgencyLang(String agencyLang) {
        this.agencyLang = agencyLang;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    public String getAgencyFareUrl() {
        return agencyFareUrl;
    }

    public void setAgencyFareUrl(String agencyFareUrl) {
        this.agencyFareUrl = agencyFareUrl;
    }
}
