package e2;

public class Pawn extends PieceImpl {

    public Pawn(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return false;
    }

    @Override
    public boolean hit(int row, int col, Piece piece) {
        return false;
    }
}
