package com.elegy.advent.solution.y2020.day1;

import com.elegy.advent.input.PuzzleInput;
import com.elegy.advent.solution.AbstractSolution;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution extends AbstractSolution {

    private Set<Integer> values;

    Solution(PuzzleInput input) {
        try {
            values = Files.readAllLines(Paths.get(input.toString())).stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(HashSet::new));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String part1() {
        for (int x : values) {
            int y = 2020 - x;
            if (values.contains(y)) {
                return String.valueOf(x * y);
            }
        }
        return "Unknown";
    }

    protected String part2() {
        Integer[] rawData = values.toArray(new Integer[0]);
        for (int i = 0; i < rawData.length - 2; ++i) {
            int x = rawData[i];
            for (int j = i + 1; j < rawData.length - 1; ++j) {
                int y = rawData[j];
                int diff = 2020 - x - y;
                if (values.contains(diff)) {
                    return String.valueOf(x * y * diff);
                }
            }
        }
        return "Unknown";
    }
}
