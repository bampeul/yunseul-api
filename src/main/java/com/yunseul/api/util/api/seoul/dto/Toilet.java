package com.yunseul.api.util.api.seoul.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Toilet {
    @JsonProperty("POI_ID")
    private String poiId;
    @JsonProperty("FNAME")
    private String fName;
    @JsonProperty("ANAME")
    private String aName;
    @JsonProperty("CNAME")
    private String cName;
    @JsonProperty("CENTER_X1")
    private String centerX;
    @JsonProperty("CENTER_Y1")
    private String cetnerY;
    @JsonProperty("X_WGS84")
    private Double wgsX;
    @JsonProperty("Y_WGS84")
    private Double wgsY;
    @JsonProperty("INSERTDATE")
    private String insertDate;
    @JsonProperty("UPDATEDATE")
    private String updateDate;
}
