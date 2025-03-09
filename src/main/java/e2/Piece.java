package e2;

public interface Piece {

    boolean hit(int row, int col, Piece piece);

    Pair<Integer, Integer> getPosition();

    void setPosition(int x, int y);
}
