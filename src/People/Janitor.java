package People;

import MallSystems.PowerSystem;
import WorldData.WorldData;
import WorldData.Config;

public class Janitor extends Person{

    public Janitor(JanitorBuilder builder) {
        super(builder);
    }

    public void updateJanitors(PowerSystem ps, WorldData wd) {

        Config config = new Config();

        if (ps.getGenHealth() < 50) {
            moveToward(0, 0, wd); // Generator located at 0,0
            if (x == 0 && y == 0) ps.addGenHealth();
        }

        boolean foundDirt = false;
        // Scans local grid
        for (int r = -config.getMapSize(); r < config.getMapSize(); r++) {
            for (int c = -config.getMapSize(); c < config.getMapSize(); c++) {
                int ty = wd.clamp(y + r);
                int tx = wd.clamp(x + c);
                if (wd.getDebrisMap()[tx][ty] > 0) {
                    moveToward(tx, ty, wd);
                    if (x == tx && y == ty) {
                        wd.removeDebris(tx,ty);
                    }
                    foundDirt = true;
                    break;
                }
            }
            if (foundDirt) break;
        }
    }
}
