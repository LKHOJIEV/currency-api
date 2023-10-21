package com.currency.api.domain.models;


import com.currency.api.domain.Auditable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currencies")
public class Currency extends Auditable {


    private String code;
    private String ccy;
    private String ccyNmRU;
    private String ccyNmUZ;
    private String ccyNmUZC;
    private String ccyNmEN;
    private String nominal;
    private String rate;
    private String diff;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("Ccy")
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @JsonProperty("CcyNm_RU")
    public String getCcyNmRU() {
        return ccyNmRU;
    }

    public void setCcyNmRU(String ccyNmRU) {
        this.ccyNmRU = ccyNmRU;
    }

    @JsonProperty("CcyNm_UZ")
    public String getCcyNmUZ() {
        return ccyNmUZ;
    }

    public void setCcyNmUZ(String ccyNmUZ) {
        this.ccyNmUZ = ccyNmUZ;
    }

    @JsonProperty("CcyNm_UZC")
    public String getCcyNmUZC() {
        return ccyNmUZC;
    }

    public void setCcyNmUZC(String ccyNmUZC) {
        this.ccyNmUZC = ccyNmUZC;
    }

    @JsonProperty("CcyNm_EN")
    public String getCcyNmEN() {
        return ccyNmEN;
    }

    public void setCcyNmEN(String ccyNmEN) {
        this.ccyNmEN = ccyNmEN;
    }

    @JsonProperty("Nominal")
    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    @JsonProperty("Rate")
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @JsonProperty("Diff")
    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    @JsonProperty("Date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
