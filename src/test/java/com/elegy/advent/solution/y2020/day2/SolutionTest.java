package com.elegy.advent.solution.y2020.day2;

import com.elegy.advent.input.PuzzleInput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest(name = "{0} - Part 1: {1} | Part 2: {2}")
    @CsvSource({
            "sample, 2, skip",
            "input, 572, 306"
    })
    void solve(String filename, String part1, String part2) {
        Solution solution = new Solution(new PuzzleInput(2020, 2, filename));
        if (!part1.equals("skip")) {
            assertEquals(part1, solution.part1());
        }
        if (!part2.equals("skip")) {
            assertEquals(part2, solution.part2());
        }
    }
}
