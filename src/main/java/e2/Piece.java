package e2;

public interface Piece {

    boolean isValidMove(int row, int col);

    boolean hit(int row, int col, Piece piece);

    Pair<Integer, Integer> getPosition();

    void setPosition(int x, int y);
}
