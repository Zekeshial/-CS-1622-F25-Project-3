package WorldData;

import org.junit.jupiter.api.Test;

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

        assertEquals(499, result);
    }

    @Test
    public void clampTest3(){
        WorldData wd = new WorldData();
        int result = wd.clamp(-5);

        assertEquals(0, result);
    }

}