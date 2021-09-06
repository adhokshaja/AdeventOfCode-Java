package me.adhokshaja.adventofcode.common;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.apache.commons.io.FileUtils.readFileToString;

public abstract class Puzzle {

    protected final int year;
    protected final int day;
    private static final String DEFAULT_DELIMITER = "\n";

    public Puzzle(int year, int day){
        this.year = year;
        this.day = day;
    }

    public void PrintOutputs(){
        System.out.println(String.format("Year {0} | Day {1}", year, day));
        System.out.println("Part 1 :  "+solve_part1());
        System.out.println("Part 2 :  "+solve_part2());
    }

    // Returns the filename
    private String getInputFileName() {
        return "inputs/"+this.year+"/day"+this.day+".txt";
    }

    protected String getInputFile(String fileName) {
        try {
            java.net.URL fileResourceUrl = Puzzle.class.getClassLoader().getResource(fileName);
            File inputFile = new File(fileResourceUrl.getFile());
            return readFileToString(inputFile);
        }catch(IOException ex){
            throw new IllegalStateException(ex);
        }
    }

    protected String[] getDelimitedInput(){
        return this.getDelimitedInput(DEFAULT_DELIMITER);
    }

    protected String[] getDelimitedInput(String delimiter){
        return getInputDelimitedStream(delimiter).toArray(String[]::new);
    }

    protected Stream<String> getInputDelimitedStream(){
        return this.getInputDelimitedStream(DEFAULT_DELIMITER);
    }

    private Stream<String> getInputDelimitedStream(String delimiter) {
        return Arrays.stream(getInputFile(getInputFileName()).split(delimiter));
    }


    public abstract Object solve_part1();
    public abstract Object solve_part2();

}
