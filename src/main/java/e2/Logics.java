package e2;

public interface Logics{
    
    /**
     * attempt to move Knight on position row,col, if possible
     * 
     * @param row
     * @param col
     * @return whether the pawn has been hit 
     */
    boolean hit(int row, int col);
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the knight
     */
    boolean hasKnight(int row, int col);
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the pawn
     */
    boolean hasPawn(int row, int col);

    /**
     *
     * @return the position of the knight
     */
    Pair<Integer, Integer> getKnightPosition();

    /**
     * Check if the given position lies within the boundaries of the field
     *
     * @param row
     * @param col
     * @throws IndexOutOfBoundsException if the position is not within the field
     */
    void isInBound(int row, int col) throws IndexOutOfBoundsException;
}
