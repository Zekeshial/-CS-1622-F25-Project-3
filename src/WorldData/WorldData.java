package WorldData;

import java.util.Collection;
import java.util.Random;

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

    public void removeDebris(int tx, int ty) {
        this.debrisMap[tx][ty] = 0;
    }

    public void addDebris(int tx, int ty, int amt) {
        this.debrisMap[tx][ty] = amt;
    }

    public int clamp(int val) {
        return Math.max(0, Math.min(c.getMapSize() - 1, val));
    }
}
