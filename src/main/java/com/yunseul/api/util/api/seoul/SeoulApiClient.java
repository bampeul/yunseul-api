package com.yunseul.api.util.api.seoul;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunseul.api.util.api.seoul.dto.AirQuality;
import com.yunseul.api.util.api.seoul.dto.Toilet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SeoulApiClient {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    // Todo 테스트용 토큰.. 우선 static 하게 박아놓고 작업 차후 분리
    private static String SEOUL_API_DOMAIN = "http://openAPI.seoul.go.kr:8088/4a5a7778646c696837357273424975/json";
    private static String SLASH = "/";

    public AirQuality dailyAverageAirQuality() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        String jsonStr = restTemplate.getForObject(
                SEOUL_API_DOMAIN + SLASH + "DailyAverageAirQuality/1/5" + SLASH + now.format(formatter) + SLASH + "중구",
                String.class);
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonStr).get("DailyAverageAirQuality").get("row").get(0);
            return objectMapper.convertValue(jsonNode, AirQuality.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new AirQuality();
    }

    public List<Toilet> searchPublicToiletPOIService() {
        List<Toilet> toilets = new ArrayList();
        for (int i = 1, j = 1000; j <= 5000; i += 1000, j += 1000) {
            try {
                Spliterator<JsonNode> jsonNodeSpliterator = Spliterators.spliteratorUnknownSize(
                        objectMapper.readTree(
                                restTemplate.getForObject(SEOUL_API_DOMAIN + SLASH + "SearchPublicToiletPOIService" + SLASH + i + SLASH + j, String.class))
                                    .get("SearchPublicToiletPOIService")
                                    .get("row")
                                    .elements()
                        , Spliterator.ORDERED);

                toilets.addAll(StreamSupport.stream(jsonNodeSpliterator, false)
                                            .map(x -> objectMapper.convertValue(x, Toilet.class))
                                            .collect(Collectors.toList()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return toilets;
    }
}
