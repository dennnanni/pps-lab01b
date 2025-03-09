package e2;

public interface Logics{
    
    /**
     * attempt to move active piece on position row,col, if possible
     * 
     * @param row
     * @param col
     * @return whether the passive piece has been hit
     */
    boolean hit(int row, int col);
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the active piece
     */
    boolean hasActivePiece(int row, int col);
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the passive piece
     */
    boolean hasPassivePiece(int row, int col);

    /**
     *
     * @return the position of the active piece
     */
    Pair<Integer, Integer> getActivePiecePosition();

    /**
     * Check if the given position lies within the boundaries of the field
     *
     * @param row
     * @param col
     * @throws IndexOutOfBoundsException if the position is not within the field
     */
    void isInBound(int row, int col) throws IndexOutOfBoundsException;
}
