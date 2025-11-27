package SudokuVerifiers;

public final class SingleThreadedVerifier extends StreamVerifier implements SudokuVerifier, Runnable {

    public SingleThreadedVerifier(int[][] grid) {
        super(grid);
    }

    public VerificationResult verify(){
return null;
    }

    @Override
    public void run() {}

}
