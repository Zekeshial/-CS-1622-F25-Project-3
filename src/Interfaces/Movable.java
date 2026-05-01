package Interfaces;

import WorldData.WorldData;

/**
 * An interface for items that move in the program
 */
public interface Movable {
    void moveToward(int tx, int ty, WorldData wd);
}
