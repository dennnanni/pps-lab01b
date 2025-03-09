package e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    @Test
    public void test() {
        assert(true);
        // TODO: Add your test logic here
        // You can generate random inputs and assert the expected output
        // For example:
        // int result = Logic.someMethod(5, 10);
        // assertEquals(expectedResult, result);
    }

    @Test
    public void testAreInDifferentPositions() {
        Logics logic = new LogicsImpl(5);
        Pair<Integer, Integer> knight = logic.getKnightPosition();
        assertFalse(logic.hit(knight.getX(), knight.getY()));
    }

    @Test
    public void testHit() {
        Logics logic = new LogicsImpl(5, 0, 0, 1, 2);
        assertTrue(logic.hit(1, 2));
    }
}
