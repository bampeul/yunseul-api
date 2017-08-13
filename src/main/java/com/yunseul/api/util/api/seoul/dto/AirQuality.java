package com.yunseul.api.util.api.seoul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirQuality {
    @JsonProperty("MSRDT_DE")
    private String date;
    @JsonProperty("MSRSTE_NM")
    private String location;
    @JsonProperty("NO2")
    private String no2;
    @JsonProperty("O3")
    private String o3;
    @JsonProperty("CO")
    private String co;
    @JsonProperty("SO2")
    private String so2;
    @JsonProperty("PM10")
    private String pm10;
    @JsonProperty("PM25")
    private String pm25;
}
