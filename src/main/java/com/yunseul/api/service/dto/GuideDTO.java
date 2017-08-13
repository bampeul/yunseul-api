package com.yunseul.api.service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GuideDTO {
    private String pid;
    private String name;
    private String description;
    private String type;
    private Double x;
    private Double y;
}
