package SudokuVerifiers;

import java.util.*;

public abstract class StreamVerifier {
    protected VerificationResult result;
    protected int[][] grid;
    protected List<int[]> mappedGrid;

    public StreamVerifier(int[][] grid) {
        this.grid = grid;
        mappedGrid = new ArrayList<int[]>();
        //map then reduce
        //map:
        mappedGrid.addAll(Arrays.asList(grid));
        int[] column = Arrays.stream(grid, 0, 9).mapToInt(row -> row[2]).toArray();
        int[] box = Arrays.stream(grid, 0, 3)
                .flatMapToInt(row -> Arrays.stream(row, 0, 3))
                .toArray();
        System.out.println(Arrays.toString(column));
        System.out.println(Arrays.toString(box));

    }

    protected Map<Integer, List<Integer>> verifyStream(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.computeIfAbsent(arr[i], e -> new ArrayList<Integer>()).add(i);
        map.entrySet().removeIf(entry -> entry.getValue().size() < 2);
        //same thing below
//        for(Iterator<Map.Entry<Integer, List<Integer>>> it = map.entrySet().iterator(); it.hasNext(); ) {
//            Map.Entry<Integer, List<Integer>> entry = it.next();
//            if(entry.getValue().size() < 2) {
//                it.remove();
//            }
        return map;
    }

    public VerificationResult getVerificationResult() {
        return result;
    }
}
