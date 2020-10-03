package com.cortex.test.model;

import com.cortex.test.service.LanguageNameValidation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Language {
    @LanguageNameValidation(message = "One of the following \"Java, JavaScript, C#, C++, Python\"")
    private String name;
    private String description;
    @Min(value = 1, message = "Rating must not be less than 1")
    @Max(value = 5, message = "Rating must not be greater than 5")
    private int rating;

    @JsonCreator
    public Language(@JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("rating") int rating
    ) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
