package People;

import WorldData.WorldData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public void movableTest() {
        Person p = (Shopper) new ShopperBuilder()
                .money(200)




                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        WorldData wd = new WorldData();

        p.moveToward(0,0, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(49, xResult);
        assertEquals(49, yResult);

    }

    @Test
    public void movableTest2() {
        Person p = (Shopper) new ShopperBuilder()
                .money(200)




                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        WorldData wd = new WorldData();

        p.moveToward(60,0, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(51, xResult);
        assertEquals(49, yResult);


    }

    @Test
    public void movableTest3() {
        Person p = (Shopper) new ShopperBuilder()
                .money(200)




                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        WorldData wd = new WorldData();

        p.moveToward(60,0, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(499, xResult);
        assertEquals(49, yResult);


    }

    @Test
    public void movableTest4() {
        Person p = (Shopper) new ShopperBuilder()
                .money(200)




                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        WorldData wd = new WorldData();

        p.moveToward(60,0, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(51, xResult);
        assertEquals(499, yResult);


    }

    @Test
    public void movableTest5() {
        Person p = (Shopper) new ShopperBuilder()
                .money(200)




                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        WorldData wd = new WorldData();

        p.moveToward(0,60, wd);
        int yResult = p.getY();
        int xResult = p.getX();

        assertEquals(49, xResult);
        assertEquals(51, yResult);


    }

}