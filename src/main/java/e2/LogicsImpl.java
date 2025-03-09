package e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Piece pawn;
	private final Piece knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = new Pawn(size, this.randomEmptyPosition());
        this.knight = new Knight(size, this.randomEmptyPosition());
    }

	public LogicsImpl(int size, Piece activePiece, Piece passivePiece) {
		this.size = size;
		this.knight = new Knight(size, activePiece.getPosition());
		this.pawn = new Pawn(size, passivePiece.getPosition());
	}

	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		return this.knight.hit(row, col, this.pawn);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public Pair<Integer, Integer> getKnightPosition() {
		return this.knight.getPosition();
	}
}
