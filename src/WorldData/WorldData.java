package WorldData;

import java.util.Collection;
import java.util.Random;

/**
 * The information regarding the WorldData or map of the program.
 */
public class WorldData {
    private int[][] debrisMap;
    private int tickCount;
    private Random rng;
    private Config c;

    public WorldData(int[][] debrisMap, int tickCount, Random rng) {
        this.debrisMap = debrisMap;
        this.tickCount = tickCount;
        this.rng = rng;
    }

    public WorldData() {
        this.c = new Config();
        this.debrisMap = new int[c.getMapSize()][c.getMapSize()];
        this.tickCount = 0;
        this.rng = new Random(c.getSeed());
    }

    public int[][] getDebrisMap() {
        return debrisMap;
    }

    public void setDebrisMap(int[][] debrisMap) {
        this.debrisMap = debrisMap;
    }

    public int getTickCount() {
        return tickCount;
    }

    public void addTick() {
        tickCount++;
    }

    public void setTickCount(int tickCount) {
        this.tickCount = tickCount;
    }

    public Random getRng() {
        return rng;
    }

    public void setRng(Random rng) {
        this.rng = rng;
    }

    /**
     * Removes debris from the map when given an x and y.
     * @param tx the x value location you wish to remove from
     * @param ty the y value location you wish to remove from
     */
    public void removeDebris(int tx, int ty) {
        this.debrisMap[tx][ty] = 0;
    }

    /**
     * sets debris to a specific value at a specific location
     * @param tx the x value location you wish to add to
     * @param ty the y value location you wish to add to
     * @param amt the amount you want to set for tha specific location
     */
    public void addDebris(int tx, int ty, int amt) {
        this.debrisMap[tx][ty] = amt;
    }

    /**
     * reduces a value to be within the size of the map
     * @param val value you wish to make sure fits inside of the map
     * @return a int value that is within the map
     */
    public int clamp(int val) {
        return Math.max(0, Math.min(c.getMapSize() - 1, val));
    }
}
