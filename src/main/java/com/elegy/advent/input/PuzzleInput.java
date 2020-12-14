package com.elegy.advent.input;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PuzzleInput {

    private int year;
    private int day;

    @Builder.Default
    private String file = "input";

    @Override
    public String toString() {
        return String.format("src/main/resources/%d/day%d/%s", year, day, file);
    }
}
