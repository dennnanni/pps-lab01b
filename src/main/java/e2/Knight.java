package e2;

public class Knight extends PieceImpl {

    public Knight(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        int x = row-getPosition().getX();
        int y = col-getPosition().getY();
        return x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3;
    }

    @Override
    public boolean hit(int row, int col, Piece piece) {
        if (isValidMove(row, col)) {
            setPosition(row, col);
            return piece.getPosition().equals(getPosition());
        }
        return false;
    }

}
