package com.elegy.advent.solution.y2020;

import com.elegy.advent.input.PuzzleInput;
import com.elegy.advent.solution.Day;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Policy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day2 extends Day {

    private List<Password> passwords;

    Day2(PuzzleInput input) {
        try {
            passwords = Files.readAllLines(Paths.get(input.toString())).stream()
                    .map(Password::build)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String part1() {
        int valid = 0;
        for (Password password : passwords) {
            int count = 0;
            PasswordPolicy policy = password.policy;
            for (char c : password.secret.toCharArray()) {
                if (c == policy.c) {
                    ++count;
                }
            }
            if (count >= policy.min && count <= policy.max) {
                ++valid;
            }
        }
        return String.valueOf(valid);
    }

    protected String part2() {
        int valid = 0;
        for (Password password : passwords) {
            PasswordPolicy policy = password.policy;
            String secret = password.secret;
            if (secret.charAt(policy.min - 1) == policy.c) {
                if (secret.charAt(policy.max - 1) != policy.c) {
                    ++valid;
                }
            } else if (secret.charAt(policy.max - 1) == policy.c) {
                ++valid;
            }
        }
        return String.valueOf(valid);
    }

    private static class PasswordPolicy {
        private int min;
        private int max;
        private char c;

        static PasswordPolicy build(String rawData) {
            PasswordPolicy result = new PasswordPolicy();

            String[] parts = rawData.split(" ");
            result.c = parts[1].charAt(0);

            String[] bounds = parts[0].split("-");
            result.min = Integer.parseInt(bounds[0]);
            result.max = Integer.parseInt(bounds[1]);
            return result;
        }
    }

    private static class Password {

        private PasswordPolicy policy;
        private String secret;

        static Password build(String rawData) {
            String[] parts = rawData.split(": ");

            Password result = new Password();
            result.policy = PasswordPolicy.build(parts[0]);
            result.secret = parts[1];
            return result;
        }
    }
}
