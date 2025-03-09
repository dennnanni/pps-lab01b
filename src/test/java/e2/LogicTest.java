package e2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
