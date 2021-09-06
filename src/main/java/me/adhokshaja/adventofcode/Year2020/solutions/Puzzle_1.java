package me.adhokshaja.adventofcode.Year2020.solutions;

import me.adhokshaja.adventofcode.Year2020.Puzzle_Year2020;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

/*
    Puzzle https://adventofcode.com/2020/day/1
*/
public class Puzzle_1 extends Puzzle_Year2020 {

    public static void Main(String[] args){
        new Puzzle_1().PrintOutputs();
        return;
    }
    private final long TARGET_SUM = 2020;

    long[]  input;

    public Puzzle_1(){
        super(1);
        input = this.getInputDelimitedStream().mapToLong(Long::parseLong).toArray();
    }

    @Override
    public Object solve_part1() {
        return FindTwoProductOfTargetSum(input);
    }

    @Override
    public Object solve_part2() {
       return FindThreeProductOfTargetSum(input);
    }

    protected long FindTwoProductOfTargetSum(long[] numArray){
        return FindTwoProductOfTargetSum(numArray, TARGET_SUM);
    }

    /**
     *   Given a list of numbers
     *         1. find two entries whose sum adds up to 2020
     *         2. return the product of those numbers
     * @param numArray Input array
     * @param targetSum Sum needed
     * @return
     */
    protected static long FindTwoProductOfTargetSum(long @NotNull [] numArray, long targetSum){
        HashSet<Long> visitedNums = new HashSet<>();
        for (long n:numArray) {
            long expDiff = targetSum-n;
            if(visitedNums.contains(expDiff)){
                return expDiff * n;
            }
            visitedNums.add(n);
        }
        return 0;
    }
    protected long FindThreeProductOfTargetSum(long[] numArray){
        return FindThreeProductOfTargetSum(numArray, TARGET_SUM);
    }

    /**
     *   Given a list of numbers
     *         1. find three entries whose sum adds up to 2020
     *         2. return the product of those numbers
     * @param numArray Input array
     * @param targetSum Sum needed
     * @return
     */
    protected static long FindThreeProductOfTargetSum(long @NotNull [] numArray, long targetSum){
        for(int i = 0; i<numArray.length; i++){
            for(int j = i+1; j<numArray.length; j++){
                for(int k = j+1; k<numArray.length; k++){
                    if(numArray[i]+numArray[j]+numArray[k] == targetSum){
                        return numArray[i]*numArray[j]*numArray[k];
                    }
                }
            }
        }
        return 0;
    }
}
