package com.yunseul.api.service;

import com.yunseul.api.repository.PlaceRepository;
import com.yunseul.api.service.dto.GuideDTO;
import com.yunseul.api.util.api.seoul.SeoulApiClient;
import com.yunseul.api.util.api.seoul.dto.AirQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeoulApiClient seoulApiClient;

    @Override
    public List<GuideDTO> readPlaces() {
        return StreamSupport.stream(placeRepository.findAll().spliterator(), false)
                            .map(x -> GuideDTO.builder()
                                              .pid(x.getPid())
                                              .name(x.getName())
                                              .description(x.getDescription())
                                              .type(x.getType())
                                              .x(x.getX())
                                              .y(x.getY())
                                              .build())
                            .collect(Collectors.toList());
    }

    @Override
    public List<GuideDTO> readPlaces(String type) {
        return placeRepository.findByType(type).stream()
                              .map(x -> GuideDTO.builder()
                                                .pid(x.getPid())
                                                .name(x.getName())
                                                .description(x.getDescription())
                                                .type(x.getType())
                                                .x(x.getX())
                                                .y(x.getY())
                                                .build())
                              .collect(Collectors.toList());
    }

    @Override
    public AirQuality readTodayAirQuality() {
        return seoulApiClient.dailyAverageAirQuality();
    }

    @Override
    public List<GuideDTO> readNearestToilets(Double slLat, Double slLng, Double distance) {
        return placeRepository.findByType("P0003").stream()
                              .filter(x ->
                                      distance >=
                                              (6371 * Math.acos(Math.cos(
                                                      Math.toRadians(x.getX()))
                                                      * Math.cos(Math.toRadians(slLat))
                                                      * Math.cos(Math.toRadians(slLng)
                                                      - Math.toRadians(x.getY()))
                                                      + Math.sin(Math.toRadians(x.getX()))
                                                      * Math.sin(Math.toRadians(slLat)))))
                              .map(x -> GuideDTO.builder()
                                                .pid(x.getPid())
                                                .name(x.getName())
                                                .description(x.getDescription())
                                                .type(x.getType())
                                                .x(x.getX())
                                                .y(x.getY())
                                                .build())
                              .collect(Collectors.toList());
    }
}
