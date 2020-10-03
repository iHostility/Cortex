package com.cortex.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class State {
    private final String state;

    @JsonCreator
    public State(@JsonProperty("state") String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
