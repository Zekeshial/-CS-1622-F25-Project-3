package Interfaces;

import WorldData.WorldData;

public interface Movable {
    void moveToward(int tx, int ty, WorldData wd);
}
