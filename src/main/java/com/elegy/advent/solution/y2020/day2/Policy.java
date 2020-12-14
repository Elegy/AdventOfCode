package com.elegy.advent.solution.y2020.day2;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class Policy {

    private int min;
    private int max;
    private char character;

    static Policy fromString(String rawData) {
        PolicyBuilder builder = Policy.builder();

        String[] parts = rawData.split(" ");
        builder.character(parts[1].charAt(0));

        String[] bounds = parts[0].split("-");
        builder.min(Integer.parseInt(bounds[0]));
        builder.max(Integer.parseInt(bounds[1]));

        return builder.build();
    }
}