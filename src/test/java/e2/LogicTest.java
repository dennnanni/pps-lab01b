package e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int SIZE = 5;
    public static final int PAWN_X = 1;
    public static final int PAWN_Y = 2;
    private Logics logic;
    private Piece activePiece;
    private Piece passivePiece;

    @BeforeEach
    public void setUp() {
        activePiece = new Knight(new Pair<>(0, 0));
        passivePiece = new Pawn(new Pair<>(PAWN_X, PAWN_Y));
        logic = new LogicsImpl(SIZE, activePiece, passivePiece, true);
    }

    @Test
    public void testAreInDifferentPositions() {
        logic = new LogicsImpl(SIZE, activePiece, passivePiece);
        Pair<Integer, Integer> knight = logic.getActivePiecePosition();
        assertFalse(logic.hit(knight.getX(), knight.getY()));
    }

    @Test
    public void testHit() {
        assertTrue(logic.hit(PAWN_X, PAWN_Y));
    }

    @Test
    public void testCannotMoveInWrongPosition() {
        logic.hit(0, 1);
        assertFalse(logic.hasActivePiece(0, 1));
    }

    @Test
    public void testCanMoveInRightPosition() {
        assertAll(
                () -> assertFalse(logic.hit(2, 1)),
                () -> assertTrue(logic.hasActivePiece(2, 1))
        );
    }

    @Test
    public void testCannotMoveOutsideField() {
        assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(-2, -1));
    }

}
