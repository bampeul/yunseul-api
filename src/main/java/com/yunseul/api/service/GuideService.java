package com.yunseul.api.service;

import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.model.AirQuality;

import java.util.List;

public interface GuideService {
    List<GuideDTO> readPlaces();
    List<GuideDTO> readPlaces(String type);

    AirQuality readTodayAirQuality();

    List<GuideDTO> readNearestToilets(Double slLat, Double slLng, Double distance);
}
