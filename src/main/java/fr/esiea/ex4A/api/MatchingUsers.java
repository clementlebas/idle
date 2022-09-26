package fr.esiea.ex4A.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchingUsers {
    public final String name;
    public final String twitter;

    public MatchingUsers(@JsonProperty("name") String name, @JsonProperty("twitter") String twitter) {
        this.name = name;
        this.twitter = twitter;
    }
}
