package com.yunseul.api.controller;

import com.yunseul.api.controller.model.ApiResponse;
import com.yunseul.api.service.GuideService;
import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.model.AirQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/debug")
public class DebugControllerV1 {

    @Autowired
    private GuideService guideService;

    @RequestMapping(value = "places", method = RequestMethod.GET)
    public ApiResponse<List<GuideDTO>> placesTest() {
        return new ApiResponse(guideService.readPlaces());
    }

    @RequestMapping(value = "places/{type}", method = RequestMethod.GET)
    public ApiResponse<List<GuideDTO>> placesTypeTest(@PathVariable String type) {
        return new ApiResponse(guideService.readPlaces(type));
    }

    @RequestMapping(value = "air", method = RequestMethod.GET)
    public ApiResponse<AirQuality> airQualityTest() {
        return new ApiResponse(guideService.readTodayAirQuality());
    }

    @RequestMapping(value = "toilets", method = RequestMethod.GET)
    public ApiResponse<List<GuideDTO>> toiletTest(@RequestParam Double slLat, @RequestParam Double slLng, @RequestParam Double distance) {
        return new ApiResponse(guideService.readNearestToilets(slLat, slLng, distance));
    }
}
