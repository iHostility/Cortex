package com.cortex.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {
    private final String name;
    private final String description;
    private final int rating;

    @JsonCreator
    public Body(@JsonProperty("name") String name,
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
}
