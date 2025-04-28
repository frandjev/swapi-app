package com.exam.swapi.model.people;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class PersonDetailDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private PersonResultDTO result;

    @Getter
    @Setter
    public static class PersonResultDTO {

        @JsonProperty("properties")
        private PersonPropertiesDTO properties;

        @JsonProperty("description")
        private String description;

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("__v")
        private int version;
    }

    @Getter
    @Setter
    public static class PersonPropertiesDTO {

        @JsonProperty("name")
        private String name;

        @JsonProperty("height")
        private String height;

        @JsonProperty("mass")
        private String mass;

        @JsonProperty("hair_color")
        private String hairColor;

        @JsonProperty("skin_color")
        private String skinColor;

        @JsonProperty("eye_color")
        private String eyeColor;

        @JsonProperty("birth_year")
        private String birthYear;

        @JsonProperty("gender")
        private String gender;
    }
}
