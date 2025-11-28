import SudokuVerifiers.SudokuVerifier;
import SudokuVerifiers.VerifierFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        int mode = 0;
//        try {
//            SudokuVerifier game =  VerifierFactory.getVerifier(SudokuLoader.loadFromCSV(new File("input.csv")), mode);
//            System.out.println(game.verify());
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        try {
            int[][] grid = SudokuLoader.loadFromCSV(new File("input.csv"));
            var mappedGrid = new ArrayList<int[]>();
//            for(int i = 0; i < 9; i++) {
//                int finalI = i;
//                mappedGrid.add(Arrays.stream(grid, 0, 9).mapToInt(row -> row[finalI]).toArray());
//            }
//            IntStream.range(0, 9).forEach(i -> mappedGrid.add(Arrays.stream(grid).mapToInt(row -> row[i]).toArray()));
            IntStream.range(0, 9).forEach(box -> {
                int startRow = (box / 3) * 3;
                int startCol = (box % 3) * 3;
                mappedGrid.add(IntStream.range(0, 3)
                        .flatMap(i -> IntStream.range(0, 3)
                        .map(j -> grid[startRow + i][startCol + j]))
                        .toArray()
                );
            });

            System.out.println(Arrays.deepToString((mappedGrid).toArray(int[][]::new)));
//            int[] column = Arrays.stream(grid, 0, 9).mapToInt(row -> row[2]).toArray();
//            int[] box = Arrays.stream(grid, 0, 3)
//                    .flatMapToInt(row -> Arrays.stream(row, 0, 3))
//                    .toArray();
//            System.out.println(Arrays.toString(column));
//            System.out.println(Arrays.toString(box));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
