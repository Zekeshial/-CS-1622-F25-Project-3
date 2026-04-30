package MallSystems;

import WorldData.WorldData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerSystemTest {
    @Test
    void updatePowerGridTest() {
        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        ps.setBlackoutTicks(30);

        while (wd.getTickCount() < 30) {
            ps.updatePowerGrid(wd);
            wd.addTick();
        }

        int result1 = ps.getBlackoutTicks();
        boolean result2 = ps.isMallPower();

        assertEquals(0, result1);
        assertTrue(result2);
    }

    @Test
    void updatePowerGridTest3() {
        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        while (wd.getTickCount() < 30) {
            ps.updatePowerGrid(wd);
            wd.addTick();
        }

        int result1 = ps.getGenHealth();


        assertEquals(99, result1);
    }


    @Test
    void addGenHealthTest4() {
        PowerSystem ps = new PowerSystem();

        ps.setGenHealth(49);
        ps.addGenHealth();

        int result = ps.getGenHealth();
        assertEquals(51, result);

    }


}