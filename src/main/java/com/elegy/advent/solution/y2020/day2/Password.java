package com.elegy.advent.solution.y2020.day2;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class Password {

    private Policy policy;
    private String secret;

    static Password fromString(String rawData) {
        PasswordBuilder builder = Password.builder();

        String[] parts = rawData.split(": ");
        builder.policy(Policy.fromString(parts[0]));
        builder.secret(parts[1]);

        return builder.build();
    }
}
