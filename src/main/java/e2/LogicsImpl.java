package e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Piece passivePiece;
	private final Piece activePiece;
	private final Random random = new Random();
	private final int size;

	public LogicsImpl(int size, Piece activePiece, Piece passivePiece, boolean keepPositions) {
		this.size = size;
		if (activePiece.getPosition().equals(passivePiece.getPosition())) {
			throw new IllegalArgumentException("Positions cannot be the same for two pieces");
		}
		isInBound(activePiece.getPosition().getX(), activePiece.getPosition().getY());
		isInBound(passivePiece.getPosition().getX(), passivePiece.getPosition().getY());
		this.activePiece = activePiece;
		this.passivePiece = passivePiece;
	}

	public LogicsImpl(int size, Piece activePiece, Piece passivePiece) {
		this.size = size;
		Pair<Integer, Integer> activePiecePosition = randomEmptyPosition();
		activePiece.setPosition(activePiecePosition.getX(), activePiecePosition.getY());
		Pair<Integer, Integer> passivePiecePosition = randomEmptyPosition();
		passivePiece.setPosition(passivePiecePosition.getX(), passivePiecePosition.getY());
		this.activePiece = activePiece;
		this.passivePiece = passivePiece;
	}

	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.passivePiece !=null && this.passivePiece.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		isInBound(row, col);
		return this.activePiece.hit(row, col, this.passivePiece);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.activePiece.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.passivePiece.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public Pair<Integer, Integer> getKnightPosition() {
		return this.activePiece.getPosition();
	}

	@Override
	public void isInBound(int row, int col) {
		if (row <0 || col <0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
	}
}
