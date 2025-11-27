import SudokuVerifiers.SudokuVerifier;
import SudokuVerifiers.VerifierFactory;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int mode = 0;
        try {
            SudokuVerifier game =  VerifierFactory.getVerifier(SudokuLoader.loadFromCSV(new File("input.csv")), mode);
            System.out.println(game.verify());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//        try {
//            int[][] grid = SudokuLoader.loadFromCSV(new File("input.csv"));
//            int[] column = Arrays.stream(grid, 0, 9).mapToInt(row -> row[2]).toArray();
//            int[] box = Arrays.stream(grid, 0, 3)
//                    .flatMapToInt(row -> Arrays.stream(row, 0, 3))
//                    .toArray();
//            System.out.println(Arrays.toString(column));
//            System.out.println(Arrays.toString(box));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}
