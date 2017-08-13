package com.yunseul.api.util.api.seoul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Toilet {
    @JsonProperty("OBJECTID")
    private String tid;
    @JsonProperty("GU_NM")
    private String gu;
    @JsonProperty("HNR_NAM")
    private String dong;
    @JsonProperty("MTC_AT")
    private String mtc_at;
    @JsonProperty("MASTERNO")
    private String masterno;
    @JsonProperty("SLAVENO")
    private String slaveno;
    @JsonProperty("NEADRES_NM")
    private String neadres_nm;
    @JsonProperty("CREAT_DE")
    private String creat_de;
    @JsonProperty("X")
    private Double x;
    @JsonProperty("Y")
    private Double y;
}
