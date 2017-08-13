package com.yunseul.api.service;

import com.yunseul.api.service.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    List<GuideDTO> readGuides();
}
