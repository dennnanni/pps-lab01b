package e2;

public class Pawn extends PieceImpl {

    public Pawn(int size, Pair<Integer, Integer> position) {
        super(size, position);
    }

    @Override
    public boolean hit(int row, int col, Pair<Integer, Integer> otherPiecePosition) {
        return false;
    }
}
