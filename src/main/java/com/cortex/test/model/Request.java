package com.cortex.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Request {
    private final List<Language> languages;

    @JsonCreator
    public Request(@JsonProperty("languages") List<Language> languages) {
        this.languages = languages;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
