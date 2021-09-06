package me.adhokshaja.adventofcode.Year2020.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle_1Test {

    long[] testInput = new long[] {1721l,979l,366l,299l,675l,1456l};
    long targetSum = 2020;

    @Test
    void findTwoProductOfTargetSum() {
        long expectedOutput = 514579;
        long actualOutput = Puzzle_1.FindTwoProductOfTargetSum(testInput,targetSum);
        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    void findThreeProductOfTargetSum(){
        long expectedOutput = 241861950;
        long actualOutput = Puzzle_1.FindThreeProductOfTargetSum(testInput, targetSum);
        assertEquals(expectedOutput, actualOutput);
    }
}