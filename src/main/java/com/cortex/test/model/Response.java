package com.cortex.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    private final String state;
    private final Body body;

    @JsonCreator
    public Response(@JsonProperty("state") String state,
                    @JsonProperty("body") Body body
    ) {
        this.state = state;
        this.body = body;
    }

    public String getState() {
        return state;
    }

    public Body getBody() {
        return body;
    }
}
