package com.yunseul.api.service;

import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.dto.AirQuality;

import java.util.List;

public interface GuideService {
    List<GuideDTO> readGuides();

    AirQuality readTodayAirQuality();
}
