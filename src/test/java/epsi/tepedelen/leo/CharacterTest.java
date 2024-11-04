package epsi.tepedelen.leo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Character c;

    @BeforeEach
    void setUp() {
        c = new Character("Cname", "Ctype");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void characterTest_creation() {
        assertEquals(1, c.getLevel());
    }

    @Test
    void test_LevelUp() {
        c.levelUp();
        assertEquals(2, c.getLevel());
    }
}