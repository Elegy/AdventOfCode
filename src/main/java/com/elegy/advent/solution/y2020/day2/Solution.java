package com.elegy.advent.solution.y2020.day2;

import com.elegy.advent.input.PuzzleInput;
import com.elegy.advent.solution.AbstractSolution;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Solution extends AbstractSolution {

    private List<Password> passwords;

    Solution(PuzzleInput input) {
        try {
            passwords = Files.readAllLines(Paths.get(input.toString())).stream()
                    .map(Password::fromString)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String part1() {
        int valid = 0;
        for (Password password : passwords) {
            int count = 0;
            Policy policy = password.getPolicy();
            for (char c : password.getSecret().toCharArray()) {
                if (c == policy.getCharacter()) {
                    ++count;
                }
            }
            if (count >= policy.getMin() && count <= policy.getMax()) {
                ++valid;
            }
        }
        return String.valueOf(valid);
    }

    protected String part2() {
        int valid = 0;
        for (Password password : passwords) {
            if (validatePart2(password)) {
                ++valid;
            }
        }
        return String.valueOf(valid);
    }

    protected static boolean validatePart2(Password password) {
        Policy policy = password.getPolicy();
        String secret = password.getSecret();
        if (secret.charAt(policy.getMin() - 1) == policy.getCharacter()) {
            return secret.charAt(policy.getMax() - 1) != policy.getCharacter();
        }
        return secret.charAt(policy.getMax() - 1) == policy.getCharacter();
    }
}
