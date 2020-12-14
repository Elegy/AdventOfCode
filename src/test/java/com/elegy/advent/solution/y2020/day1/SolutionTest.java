package com.elegy.advent.solution.y2020.day1;

import com.elegy.advent.input.PuzzleInput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest(name = "{0} - Part 1: {1} | Part 2: {2}")
    @CsvSource({
            "sample, 514579, 241861950",
            "input, 1010884, 253928438"
    })
    void solve(String filename, String part1, String part2) {
        Solution solution = new Solution(new PuzzleInput(2020, 1, filename));
        assertEquals(part1, solution.part1());
        assertEquals(part2, solution.part2());
    }
}
