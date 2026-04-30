package Stores;

import MallSystems.PowerSystem;
import WorldData.WorldData;
import WorldData.Config;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    @Test
    void updateStoreSystemTest() throws InterruptedException {

        Config config = new Config();
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ClothStore cs = (ClothStore) new ClothStoreBuilder()
                .name("Boutique_" + 1)
                .x(wd.getRng().nextInt(config.getMapSize()))
                .y(wd.getRng().nextInt(config.getMapSize()))
                .stock(50)
                .open(true)
                .build();

        while (wd.getTickCount() < 56) {
            cs.updateStoreSystem(wd,ps);
            wd.addTick();
            Thread.sleep(10);
        }

        int result = cs.getStock();

        assertEquals(60, result);

    }

    @Test
    void updateStoreSystemTest2() {

        Config config = new Config();
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ClothStore cs = (ClothStore) new ClothStoreBuilder()
                .name("Boutique_" + 1)
                .x(wd.getRng().nextInt(config.getMapSize()))
                .y(wd.getRng().nextInt(config.getMapSize()))
                .stock(50)
                .open(true)
                .build();

        cs.setStock(0);
        cs.updateStoreSystem(wd,ps);
        boolean result = cs.isOpen();

        assertEquals(false, result);

    }

    @Test
    void updateStoreSystemTest3() {

        Config config = new Config();
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ClothStore cs = (ClothStore) new ClothStoreBuilder()
                .name("Boutique_" + 1)
                .x(wd.getRng().nextInt(config.getMapSize()))
                .y(wd.getRng().nextInt(config.getMapSize()))
                .stock(50)
                .open(true)
                .build();

        int resultX = cs.getX();
        int resultY = cs.getY();

        assertEquals(99, resultX);
        assertEquals(50, resultY);



    }

}