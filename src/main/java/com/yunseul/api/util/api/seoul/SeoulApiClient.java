package com.yunseul.api.util.api.seoul;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunseul.api.util.api.seoul.dto.AirQuality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

/*    public void sendByPost(String domain, int apiPort, String appId, String authKey, String channelName, String event, String message) {
        String serverUrl = getApiServerUrl(domain, apiPort);

        Map<String, Object> params = new HashMap<>();
        params.put("channels", Arrays.asList(channelName));
        params.put("event", event);
        params.put("data", message);

        String body = null;
        try {
            body = objectMapper.writeValueAsString(params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (body != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

            HttpEntity entity = new HttpEntity(body, headers);

            restTemplate.postForEntity(
                    serverUrl + "/channel/{app}?auth_key={auth_key}",
                    entity,
                    String.class,
                    appId, authKey);
        }
    }

    public void sendByGet(String domain, int apiPort, Map<String, Object> params) {
        String serverUrl = getApiServerUrl(domain, apiPort);

        URLEncoderUtils

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(params.keySet());

        params.keySet()

        restTemplate.getForObject(
                serverUrl + "/channel/{app_id}?channels={channels}&event={event}&auth_key={auth_key}&data={data}",
                String.class,
                params);
    }*/
}
