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
        wd.getDebrisMap()[0][99]++;

        while (wd.getTickCount() < 1000) {
            j.updateJanitors(ps, wd);
            wd.addTick();
        }

        int result = wd.getDebrisMap()[0][99];

        assertEquals(0,result);

    }

    @Test
    void updateJanitorTest2(){

        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        wd.getDebrisMap()[0][3]++;

        int x = 0;
        int y = 0;
        while (wd.getTickCount() < 1000) {
            boolean foundDirt = false;
            // Scans local grid
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 1; c++) {
                    int ty = wd.clamp(y + r);
                    int tx = wd.clamp(x + c);
                    if (wd.getDebrisMap()[tx][ty] > 0) {
                        if (x < tx) x++;
                        else if (x > tx) x--;
                        if (y < ty) y++;
                        else if (y > ty) y--;
                        x = wd.clamp(x);
                        y = wd.clamp(y);
                        if (x == tx && y == ty) {
                            wd.removeDebris(tx, ty);
                        }
                        foundDirt = true;
                        break;
                    }
                }
                if (foundDirt) break;
            }
            wd.addTick();
        }




        int result = wd.getDebrisMap()[0][3];

        assertEquals(0,result);

    }

    @Test
    void updateJanitorTest3(){

        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        Janitor j = (Janitor) new JanitorBuilder()
                .name("Janitor_" + (100))
                .x(50)
                .y(50)
                .active(true)
                .build();

        ps.setGenHealth(48);

        while (wd.getTickCount() < 1000) {
            j.updateJanitors(ps, wd);
            wd.addTick();
        }


        int result = ps.getGenHealth();

        assertEquals(50,result);

    }

    @Test
    void updateJanitorTest4(){

        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        Janitor j = (Janitor) new JanitorBuilder()
                .name("Janitor_" + (100))
                .x(0)
                .y(0)
                .active(true)
                .build();

        wd.addDebris(50, 50 ,5);
        wd.addDebris(10, 17 ,5);
        wd.addDebris(0, 99 ,5);
        wd.addDebris(25, 75 ,5);
        wd.addDebris(27, 2 ,5);
        wd.addDebris(75, 5 ,5);




        while (wd.getTickCount() < 1000) {
            j.updateJanitors(ps, wd);
            wd.addTick();
        }


        int result = wd.getDebrisMap()[50][50];
        int result2 = wd.getDebrisMap()[10][17];
        int result3 = wd.getDebrisMap()[0][99];
        int result4 = wd.getDebrisMap()[25][75];
        int result5 = wd.getDebrisMap()[75][5];

        assertEquals(0,result);
        assertEquals(0,result2);
        assertEquals(0,result3);
        assertEquals(0,result4);
        assertEquals(0,result5);



    }

    @Test
    void updateJanitorTest5(){

        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();

        Janitor j = (Janitor) new JanitorBuilder()
                .name("Janitor_" + (100))
                .x(50)
                .y(5)
                .active(true)
                .build();
        ps.setGenHealth(25);

        while (wd.getTickCount() < 1000) {
            j.updateJanitors(ps, wd);
            wd.addTick();
        }

        int result = ps.getGenHealth();

        assertEquals(51,result);

    }


}