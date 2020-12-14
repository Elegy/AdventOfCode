package com.elegy.advent.solution;

public abstract class Day {

    public final void solve() {
        System.out.println("Part 1 Solution: " + part1());
        System.out.println("Part 2 Solution: " + part2());
    }

    protected abstract String part1();

    protected abstract String part2();
}
