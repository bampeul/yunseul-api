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
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SeoulApiClient {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private static String tids = "659,670,658,383,384,385,388,389,391,393,394,395,396,398,399,400,401,390,1194,1196,1197,1201,1202,1203,1205,1206,1207,1208,1210,1211,1212,1214,1216,1223,1213,1409,1397,1398,1399,1400,1403,1404,1405,1406,1407,1410,1402,1412,1519,1527,1945,1459,1460,1462,1463,1464,1465,1467,1501,1502,1503,1505,1506,1507,1509,1510,1511,1512,1514,1515,1516,1517,1520,1521,1522,1524,1525,1526,1528,1908,1909,1910,1912,1913,1914,1915,1916,1917,1918,1920,1921,1923,1924,1925,1926,1928,1929,1930,1931,1933,1934,1935,1937,1938,1939,1940,1942,1943,1944,1946,1948,1949,2569,2574,2575,2576,2577,2602,2603,2605,2607,2608,2609,2610,2612,2613,2614,2616,2604,2617,2619,2623,2624,2625,2626,2627,2212,2214,2215,2216,2217,2235,2221,2249,2956,2957,2958,2961,2962,2966,2967,2969,2970,2754,2755,2756,2758,2759,2760,2762,2764,2765,2766,2767,2770,2771,2772,2775,2776,2761,2768,2778,2779,2781,2782,2783,2971,2972,2974,2960,2975,2976,2977,2978,2980,2981,2982,2983,2986,2987,2988,2620,3386,3391,2774,2790,2622,3143,3231,3232,3233,3234,3236,3237,3238,3239,3241,3242,3243,3244,3246,3247,3248,3250,3251,3252,3253,3588,3589,3571,3585,3591,3592,3593,3595,3596,3597,3598,3587,3599,3600,3601,3603,3565,3566,3567,3568,3570,3572,3573,3575,3576,3577,3578,3581,3582,3583,3586,4673,4680,4729,4744,4752,4148,4149,4150,4151,4026,4033,4034,4230,4231,4233,4234,5448,387,392,397,402,504,1195,1204,1209,1215,3235,3240,3245,3249,3569,3574,3579,3584,3590,1461,1466,3594,3580,3602,4725,1401,1408,1411,4226,4232,4236,1508,1513,1518,1523,1504,1911,1919,1922,5126,1927,1932,1936,1941,1947,2213,4035,2606,2611,2621,2959,2968,2973,2979,2984,2985,2757,2763,2769,2773,2777,2780,2789";

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

    public List<Toilet> geoInfoPublicToilet() {
        String[] tidArr = tids.split(",");

        List<Toilet> results = Arrays.stream(tidArr)
                                 .map(tid -> restTemplate.getForObject(
                                         SEOUL_API_DOMAIN + SLASH + "GeoInfoPublicToilet/1/5/" + tid,
                                         String.class))
                                 .map(t -> {
                                     try {
                                         return objectMapper.convertValue(objectMapper.readTree(t).get("GeoInfoPublicToilet").get("row").get(0), Toilet.class);
                                     } catch (IOException e) {
                                         e.printStackTrace();
                                     }
                                     return new Toilet();
                                 })
                                 .collect(toList());

        return results;
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
