package com.yunseul.api.service;

import com.yunseul.api.repository.PlaceRepository;
import com.yunseul.api.service.dto.GuideDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<GuideDTO> readGuides() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(placeRepository.findAll().iterator(), Spliterator.ORDERED), false)
                            .map(place ->
                                    GuideDTO.builder()
                                            .pid(place.getPid())
                                            .name(place.getName())
                                            .description(place.getDescription())
                                            .type(place.getType())
                                            .x(place.getX())
                                            .y(place.getY())
                                            .build()
                            )
                            .collect(Collectors.toList());
    }
}
