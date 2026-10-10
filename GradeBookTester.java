/*
 * Name: Akene Crosse
 * Class: CMSC203 Computer Science I - Prof. Thai
 * Lab 6 - JUnit Lab
 * Date: 10/09/2026
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the GradeBook class.
 */
class GradeBookTester {

    private GradeBook g1;
    private GradeBook g2;

    /**
     * Makes two gradebooks that hold 5 scores and adds some scores to each.
     */
    @BeforeEach
    void setUp() throws Exception {
        g1 = new GradeBook(5);
        g1.addScore(50);
        g1.addScore(75);

        g2 = new GradeBook(5);
        g2.addScore(88);
        g2.addScore(92.5);
        g2.addScore(64);
        g2.addScore(100);
    }

    /**
     * Sets both gradebooks back to null.
     */
    @AfterEach
    void tearDown() throws Exception {
        g1 = null;
        g2 = null;
    }

    /**
     * Checks that addScore puts the scores in the array and updates the size.
     */
    @Test
    void testAddScore() {
        assertTrue(g1.toString().equals("50.0 75.0 "));
        assertEquals(2, g1.getScoreSize());

        assertTrue(g2.toString().equals("88.0 92.5 64.0 100.0 "));
        assertEquals(4, g2.getScoreSize());

        // g2 has room for one more, then it's full
        assertTrue(g2.addScore(70));
        assertEquals(5, g2.getScoreSize());
        assertFalse(g2.addScore(99));
        assertEquals(5, g2.getScoreSize());
    }

    /**
     * Checks the sum of the scores.
     */
    @Test
    void testSum() {
        assertEquals(125, g1.sum(), .0001);
        assertEquals(344.5, g2.sum(), .0001);
    }

    /**
     * Checks the lowest score.
     */
    @Test
    void testMinimum() {
        assertEquals(50, g1.minimum(), .001);
        assertEquals(64, g2.minimum(), .001);
    }

    /**
     * Checks the final score (sum with the lowest score dropped).
     */
    @Test
    void testFinalScore() {
        assertEquals(75, g1.finalScore(), .001);      // 125 - 50
        assertEquals(280.5, g2.finalScore(), .001);   // 344.5 - 64

        // only one score: nothing gets dropped
        GradeBook g3 = new GradeBook(5);
        g3.addScore(90);
        assertEquals(90, g3.finalScore(), .001);

        // no scores: final score is 0
        assertEquals(0, new GradeBook(5).finalScore(), .001);
    }

    /**
     * Checks the number of scores.
     */
    @Test
    void testGetScoreSize() {
        assertEquals(2, g1.getScoreSize());
        assertEquals(4, g2.getScoreSize());
    }

    /**
     * Checks that toString lists the scores separated by spaces.
     */
    @Test
    void testToString() {
        assertEquals("50.0 75.0 ", g1.toString());
        assertEquals("88.0 92.5 64.0 100.0 ", g2.toString());
    }
}
