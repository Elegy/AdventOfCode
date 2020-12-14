package com.elegy.advent.input;

import lombok.Value;

@Value
public class PuzzleInput {

    private static final String DEFAULT = "input";

    private int year;
    private int day;
    private String file;

    public PuzzleInput(int year, int day) {
        this(year, day, DEFAULT);
    }

    public PuzzleInput(int year, int day, String file) {
        this.year = year;
        this.day = day;
        this.file = file;
    }

    @Override
    public String toString() {
        return String.format("src/main/resources/%d/day%d/%s", year, day, file);
    }
}
