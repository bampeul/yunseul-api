package com.yunseul.api.service;

import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.dto.AirQuality;
import com.yunseul.api.util.api.seoul.dto.Toilet;

import java.util.List;

public interface GuideService {
    List<GuideDTO> readGuides();

    AirQuality readTodayAirQuality();

    List<Toilet> readToilets();
}
