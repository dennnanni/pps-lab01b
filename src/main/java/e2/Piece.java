package e2;

public interface Piece {

    /**
     * Checks if given row and column are a valid move for the piece
     *
     * @param row
     * @param col
     * @return true if the move is legal, false otherwise
     */
    boolean isValidMove(int row, int col);

    /**
     * Moves the piece in the given position and hit the other piece if it lies in that position
     *
     * @param row
     * @param col
     * @param piece the piece to check
     * @return true if the piece has hit the other, false otherwise
     */
    boolean hit(int row, int col, Piece piece);

    /**
     *
     * @return the position of the piece
     */
    Pair<Integer, Integer> getPosition();

    /**
     * Sets the position of the piece to the given one if it's valid
     *
     * @param x
     * @param y
     */
    void setPosition(int x, int y);
}
