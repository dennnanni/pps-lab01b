package e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    public static final int PAWN_X = 1;
    public static final int PAWN_Y = 2;
    private Logics logic;

    @Test
    public void test() {
        assert(true);
        // TODO: Add your test logic here
        // You can generate random inputs and assert the expected output
        // For example:
        // int result = Logic.someMethod(5, 10);
        // assertEquals(expectedResult, result);
    }

    @BeforeEach
    public void setUp() {
        logic = new LogicsImpl(5, 0, 0, PAWN_X, PAWN_Y);
    }

    @Test
    public void testAreInDifferentPositions() {
        logic = new LogicsImpl(5);
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
