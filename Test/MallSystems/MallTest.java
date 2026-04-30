package MallSystems;

import People.*;
import Stores.*;
import WorldData.Config;
import WorldData.WorldData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MallTest {

    @Test
    void addMallReputationTest() {
        Mall m = new Mall();
        m.addMallReputation(5);

        double result = m.getMallReputation();
        assertEquals(105, result);

    }

    @Test
    void addMallReputationTest2() {
        Mall m = new Mall();
        m.addMallReputation(0);

        double result = m.getMallReputation();
        assertEquals(100, result);

    }

    @Test
    void addMallReputationTest3() {
        Mall m = new Mall();
        m.addMallReputation(-5);

        double result = m.getMallReputation();
        assertEquals(95, result);

    }

    @Test
    void removeMallReputationTest() {
        Mall m = new Mall();
        m.subtractMallReputation(5);

        double result = m.getMallReputation();
        assertEquals(95, result);

    }

    @Test
    void removeMallReputationTest2() {
        Mall m = new Mall();
        m.subtractMallReputation(0);

        double result = m.getMallReputation();
        assertEquals(100, result);

    }

    @Test
    void removeMallReputationTest3() {
        Mall m = new Mall();
        m.subtractMallReputation(-5);

        double result = m.getMallReputation();
        assertEquals(105, result);

    }

}