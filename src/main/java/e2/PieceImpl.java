package e2;

public abstract class PieceImpl implements Piece {

    private Pair<Integer, Integer> position;
    private final int size;

    public PieceImpl(int size, Pair<Integer, Integer> position) {
        this.size = size;
        this.position = new Pair<>(position.getX(), position.getY());
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return new Pair<>(position.getX(), position.getY());
    }

    @Override
    public void setPosition(int x, int y) {
        this. position = new Pair<>(x, y);
    }

    public int getFieldSize() {
        return this.size;
    }

    protected void checkInBound(int row, int col) {
        if (row <0 || col <0 || row >= getFieldSize() || col >= getFieldSize()) {
            throw new IndexOutOfBoundsException();
        }
    }
}
