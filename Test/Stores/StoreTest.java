package Stores;

import MallSystems.PowerSystem;
import WorldData.WorldData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    @Test
    void updateStoreSystemTest() throws InterruptedException {

        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        Store cs = new ClothStore("Boutique_" + 1, 25, 25, 50, true);

        while (wd.getTickCount < 56) {
            cs.updateStoreSystem(wd,ps);
            wd.addTick();
            Thread.sleep(10);
        }

        int result = cs.getStock();

        assertEquals(55, result);

    }

    @Test
    void updateStoreSystemTest() {

        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        Store cs = new ClothStore("Boutique_" + 1, 25, 25, 50, true);

        cs.setStock(0);
        cs.updateStoreSystem(wd,ps);
        boolean result = cs.isOpen();

        assertEquals(false, result);

    }

}