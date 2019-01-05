package example.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private Currently currently;

    public WeatherResponse() {
    }

    public WeatherResponse(String currentSummary) {
        this.currently = new Currently(currentSummary);
    }

    public Currently getCurrently() {
        return currently;
    }

    public String getSummary() {
        return currently.getSummary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WeatherResponse response = (WeatherResponse) o;

        return Objects.equals(currently, response.currently);
    }

    @Override
    public int hashCode() {
        return currently != null ? currently.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "currently=" + currently +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Currently {
        private String summary;

        public Currently() {
        }

        public Currently(String summary) {
            this.summary = summary;
        }

        public String getSummary() {
            return summary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Currently currently = (Currently) o;

            return Objects.equals(summary, currently.summary);
        }

        @Override
        public int hashCode() {
            return summary != null ? summary.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Currently{" +
                    "summary='" + summary + '\'' +
                    '}';
        }
    }
}
