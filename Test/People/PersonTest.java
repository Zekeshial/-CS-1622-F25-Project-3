package People;

import WorldData.WorldData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public void movableTest() {
        Person p = new Shopper(1, "Shopper_" + 1, 50, 50, 200, true);

        p.moveToward(0,0, );
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(49, xResult);
        assertEquals(49, yResult);

    }

    @Test
    public void movableTest2() {
        Person p = new Shopper(1, "Shopper_" + 1, 50, 50, 200, true);
        WorldData wd = new WorldData();

        p.moveToward(60,0, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(51, xResult);
        assertEquals(49, yResult);


    }

    @Test
    public void movableTest3() {
        Person p = new Shopper(1, "Shopper_" + 1, 502, 50, 200, true);
        WorldData wd = new WorldData();

        p.moveToward(60,0, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(499, xResult);
        assertEquals(49, yResult);


    }

    @Test
    public void movableTest4() {
        Person p = new Shopper(1, "Shopper_" + 1, 50, 502, 200, true);
        WorldData wd = new WorldData();

        p.moveToward(60,0, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(51, xResult);
        assertEquals(499, yResult);


    }

    @Test
    public void movableTest5() {
        Person p = new Shopper(1, "Shopper_" + 1, 50, 50, 200, true);
        WorldData wd = new WorldData();

        p.moveToward(0,60, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(49, xResult);
        assertEquals(51, yResult);


    }

}