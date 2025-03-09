package e2;

public class Knight extends PieceImpl {

    public Knight(int size, Pair<Integer, Integer> position) {
        super(size, position);
    }

    @Override
    public boolean hit(int row, int col, Piece piece) {
        checkInBound(row, col);
        // Below a compact way to express allowed moves for the knight
        int x = row-getPosition().getX();
        int y = col-getPosition().getY();
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            setPosition(row, col);
            return piece.getPosition().equals(getPosition());
        }
        return false;
    }

}
