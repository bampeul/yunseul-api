package com.yunseul.api.controller;

import com.yunseul.api.service.GuideService;
import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.dto.AirQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/debug")
public class DebugControllerV1 {

    @Autowired
    private GuideService guideService;

    public String test() {
        return "test";
    }

    @RequestMapping(value = "places", method = RequestMethod.GET)
    public List<GuideDTO> placeTest() {
        return guideService.readGuides();
    }

    @RequestMapping(value = "airQuality", method = RequestMethod.GET)
    public AirQuality airQualityTest() {
        return guideService.readTodayAirQuality();
    }
}
