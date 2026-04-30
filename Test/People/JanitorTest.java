package People;

import MallSystems.PowerSystem;
import WorldData.WorldData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JanitorTest {
    @Test
    void updateJanitorTest(){

        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        Janitor j = (Janitor) new JanitorBuilder()
                .name("Janitor_" + (100))
                .x(0)
                .y(0)
                .active(true)
                .build();
        wd.getDebrisMap()[0][5]++;
        while (wd.getTickCount() < 1000) {
            j.updateJanitors(ps, wd);
            wd.addTick();
        }

        int result = wd.getDebrisMap()[50][50];

        assertEquals(0,result);

    }

    @Test
    void updateJanitorTest2(){

        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        wd.getDebrisMap()[0][3]++;

        int x = 0;
        int y = 0;
        boolean foundDirt = false;
        // Scans local grid
        for (int r = -5; r < 5; r++) {
            for (int c = -5; c < 5; c++) {
                int ty = wd.clamp(y + r);
                int tx = wd.clamp(x + c);
                if (wd.getDebrisMap()[ty][tx] > 0) {
                    if (x < tx) x++; else if (x > tx) x--;
                    if (y < ty) y++; else if (y > ty) y--;
                    x = wd.clamp(x);
                    y = wd.clamp(y);
                    if (x == tx && y == ty) {
                        wd.removeDebris(tx,ty);
                    }
                    foundDirt = true;
                    break;
                }
            }
            if (foundDirt) break;
        }

        System.out.println(foundDirt);


        int result = wd.getDebrisMap()[0][3];

        assertEquals(0,result);

    }


}