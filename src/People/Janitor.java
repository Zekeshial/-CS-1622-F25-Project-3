package People;

import MallSystems.PowerSystem;
import WorldData.WorldData;

public class Janitor extends Person{

    public Janitor(JanitorBuilder builder) {
        super(builder);
    }

    public void updateJanitors(PowerSystem ps, WorldData wd) {

        if (ps.getGenHealth() < 50) {
            moveToward(0, 0, wd); // Generator located at 0,0
            if (x == 0 && y == 0) ps.setGenHealth(Math.min(100, ps.getGenHealth() + 2));
        }

        boolean foundDirt = false;
        // Scans local grid
        for (int r = -5; r < 5; r++) {
            for (int c = -5; c < 5; c++) {
                int ty = wd.clamp(y + r);
                int tx = wd.clamp(x + c);
                if (wd.getDebrisMap()[ty][tx] > 0) {
                    moveToward(tx, ty, wd);
                    if (x == tx && y == ty) {
                        wd.getDebrisMap()[ty][tx] = 0;
                    }
                    foundDirt = true;
                    break;
                }
            }
            if (foundDirt) break;
        }
    }
}
