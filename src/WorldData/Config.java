package WorldData;

public class Config {
    int mapSize = 100;
    int maxPeople = 500;
    int maxStores = 50;
    int seed = 2026;

    public Config() {
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getMaxStores() {
        return maxStores;
    }

    public void setMaxStores(int maxStores) {
        this.maxStores = maxStores;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}
