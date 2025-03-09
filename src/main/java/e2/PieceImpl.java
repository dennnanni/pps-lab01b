package e2;

public abstract class PieceImpl implements Piece {

    private Pair<Integer, Integer> position;

    public PieceImpl(Pair<Integer, Integer> position) {
        this.position = new Pair<>(position.getX(), position.getY());
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return new Pair<>(position.getX(), position.getY());
    }

    @Override
    public void setPosition(int x, int y) {
        if (isValidMove(x, y)) {
            this.position = new Pair<>(x, y);
        }
    }
}
