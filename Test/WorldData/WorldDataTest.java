package WorldData;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class WorldDataTest {
    @Test
    public void clampTest(){
        WorldData wd = new WorldData();
        int result = wd.clamp(60);


        assertEquals(60, result);
    }

    @Test
    public void clampTest2(){
        WorldData wd = new WorldData();
        int result = wd.clamp(600);

        assertEquals(99, result);
    }

    @Test
    public void clampTest3(){
        WorldData wd = new WorldData();
        int result = wd.clamp(-5);

        assertEquals(0, result);
    }

    @Test
    public void getRNGTest() {
        WorldData wd = new WorldData();
        int result = wd.getRng().nextInt(100);

        Random r = new Random(2026);
        int expected = r.nextInt(100);
        assertEquals(expected, result);
    }

    @Test
    public void getRNGTest2() {
        WorldData wd = new WorldData();
        int result = wd.getRng().nextInt(100);

        Random r = new Random(2026);
        int expected = r.nextInt(100);
        assertEquals(expected, result);
    }

    @Test
    public void getRNGTest3() {
        Config c = new Config();
        WorldData wd = new WorldData();
        int result = wd.getRng().nextInt(c.getMapSize());
        int result2 = wd.getRng().nextInt(c.getMapSize());

        Random r = new Random(2026);
        assertEquals(99, result);
        assertEquals(50, result2);
    }

    @Test
    public void addDebrisTest() {
        WorldData wd = new WorldData();
        wd.addDebris(50,50,5);
        int result = wd.getDebrisMap()[50][50];
        assertEquals(5,result);
    }

    @Test
    public void addDebrisTest2() {
        WorldData wd = new WorldData();
        wd.getDebrisMap()[50][50]++;
        int result = wd.getDebrisMap()[50][50];
        assertEquals(1,result);
    }

}