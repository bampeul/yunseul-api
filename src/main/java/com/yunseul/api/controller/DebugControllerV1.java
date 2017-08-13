package com.yunseul.api.controller;

import com.yunseul.api.service.GuideService;
import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.dto.AirQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/debug")
public class DebugControllerV1 {

    @Autowired
    private GuideService guideService;

    @RequestMapping(value = "places", method = RequestMethod.GET)
    public List<GuideDTO> placesTest() {
        return guideService.readPlaces();
    }

    @RequestMapping(value = "places/{type}", method = RequestMethod.GET)
    public List<GuideDTO> placesTypeTest(@PathVariable String type) {
        return guideService.readPlaces(type);
    }

    @RequestMapping(value = "air", method = RequestMethod.GET)
    public AirQuality airQualityTest() {
        return guideService.readTodayAirQuality();
    }

    @RequestMapping(value = "toilets", method = RequestMethod.GET)
    public List<GuideDTO> toiletTest(@RequestParam Double slLat, @RequestParam Double slLng, @RequestParam Double distance) {
        return guideService.readNearestToilets(slLat, slLng, distance);
    }
}
