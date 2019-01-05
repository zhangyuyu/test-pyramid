package example.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class WeatherClient {

    private final Logger LOGGER = LoggerFactory.getLogger(WeatherClient.class);

    private static final String LATITUDE = "39.90";
    private static final String LONGITUDE = "116.40";
    private final RestTemplate restTemplate;
    private final String weatherServiceUrl;
    private final String weatherServiceApiKey;

    @Autowired
    public WeatherClient(final RestTemplate restTemplate,
                         @Value("${weather.url}") final String weatherServiceUrl,
                         @Value("${weather.api_secret}") final String weatherServiceApiKey) {
        this.restTemplate = restTemplate;
        this.weatherServiceUrl = weatherServiceUrl;
        this.weatherServiceApiKey = weatherServiceApiKey;
    }

    public Optional<WeatherResponse> fetchWeather() {
        String url = String.format("%s/%s/%s,%s", weatherServiceUrl, weatherServiceApiKey, LATITUDE, LONGITUDE);

        try {
            LOGGER.info("Getting the weather of latitude: {}, longitude: {}...", LATITUDE, LONGITUDE);
            return Optional.ofNullable(restTemplate.getForObject(url, WeatherResponse.class));
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
