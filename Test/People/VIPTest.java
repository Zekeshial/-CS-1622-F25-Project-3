package People;

import MallSystems.Mall;
import MallSystems.PowerSystem;
import Stores.*;
import WorldData.Config;
import WorldData.WorldData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VIPTest {
    @Test
    void addHungerTest() {
        VIP s = (VIP) new VIPBuilder()
                .money(200)
                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        s.addHunger(2);
        int result = s.getHunger();
        assertEquals(2,result);
    }

    @Test
    void addHungerTest2() {
        VIP s = (VIP) new VIPBuilder()
                .money(200)
                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        s.addHunger(0);
        int result = s.getHunger();
        assertEquals(0,result);
    }

    @Test
    void addHungerTest3() {
        VIP s = (VIP) new VIPBuilder()
                .money(200)
                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        s.addHunger(-1);
        int result = s.getHunger();
        assertEquals(-1,result);
    }

    @Test
    void addUpdateShopper() {


        Config config = new Config();
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ArrayList<Store> sl = new ArrayList<>();
        Mall m = new Mall();

        for (int i = 0; i < config.getMaxStores()/2; i++) {
            FoodStore f = (FoodStore) new FoodStoreBuilder()
                    .name("Food_Stall_" + i)
                    .x(wd.getRng().nextInt(config.getMapSize()))
                    .y(wd.getRng().nextInt(config.getMapSize()))
                    .stock(100)
                    .open(true)
                    .build();
            sl.add(f);
        }
        for (int i = 0; i < config.getMaxStores()/2; i++) {
            ClothStore c = (ClothStore) new ClothStoreBuilder()
                    .name("Boutique_" + i)
                    .x(wd.getRng().nextInt(config.getMapSize()))
                    .y(wd.getRng().nextInt(config.getMapSize()))
                    .stock(50)
                    .open(true)
                    .build();
            sl.add(c);
        }

        VIP v = (VIP) new VIPBuilder()
                .money(200)
                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();


        ps.setMallPower(false);
        while (wd.getTickCount() < 10) {
            v.updateVIP(wd, ps, sl, m);
            wd.addTick();
        }

        int result = v.getStress();

        assertEquals(20, result);

    }

}