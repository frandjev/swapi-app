package com.exam.swapi.model.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDetailDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private VehicleResultDTO result;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VehicleResultDTO {

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("description")
        private String description;

        @JsonProperty("properties")
        private VehiclePropertiesDTO properties;
    }
}
