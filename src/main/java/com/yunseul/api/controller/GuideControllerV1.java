package com.yunseul.api.controller;

import com.yunseul.api.controller.model.ApiResponse;
import com.yunseul.api.service.GuideService;
import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.model.AirQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideControllerV1 {

    @Autowired
    private GuideService guideService;

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public ApiResponse<List<GuideDTO>> readPlaces() {
        return new ApiResponse(guideService.readPlaces());
    }

    @RequestMapping(value = "/places/{type}", method = RequestMethod.GET)
    public ApiResponse<List<GuideDTO>> readPlacesByType(@PathVariable String type) {
        return new ApiResponse(guideService.readPlaces(type));
    }

    @RequestMapping(value = "/air", method = RequestMethod.GET)
    public ApiResponse<AirQuality> readAirQuality() {
        return new ApiResponse(guideService.readTodayAirQuality());
    }

    @RequestMapping(value = "/toilets", method = RequestMethod.GET)
    public ApiResponse<List<GuideDTO>> readToilets(@RequestParam Double slLat, @RequestParam Double slLng, @RequestParam Double distance) {
        return new ApiResponse(guideService.readNearestToilets(slLat, slLng, distance));
    }
}
