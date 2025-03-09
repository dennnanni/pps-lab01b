package e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private static final int SIZE = 5;
    public static final int PAWN_X = 1;
    public static final int PAWN_Y = 2;
    private Logics logic;

    @BeforeEach
    public void setUp() {
        Piece activePiece = new Knight(SIZE, new Pair<>(0, 0));
        Piece passivePiece = new Pawn(SIZE, new Pair<>(PAWN_X, PAWN_Y));
        logic = new LogicsImpl(SIZE, activePiece, passivePiece);
    }

    @Test
    public void testAreInDifferentPositions() {
        logic = new LogicsImpl(SIZE);
        Pair<Integer, Integer> knight = logic.getKnightPosition();
        assertFalse(logic.hit(knight.getX(), knight.getY()));
    }

    @Test
    public void testHit() {
        assertTrue(logic.hit(PAWN_X, PAWN_Y));
    }

    @Test
    public void testCannotMoveInWrongPosition() {
        logic.hit(0, 1);
        assertFalse(logic.hasKnight(0, 1));
    }

    @Test
    public void testCanMoveInRightPosition() {
        assertAll(
                () -> assertFalse(logic.hit(2, 1)),
                () -> assertTrue(logic.hasKnight(2, 1))
        );
    }

}
