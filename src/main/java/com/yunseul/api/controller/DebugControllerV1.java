package com.yunseul.api.controller;

import com.yunseul.api.repository.PlaceRepository;
import com.yunseul.api.repository.entity.Place;
import com.yunseul.api.service.GuideService;
import com.yunseul.api.service.dto.GuideDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
}
