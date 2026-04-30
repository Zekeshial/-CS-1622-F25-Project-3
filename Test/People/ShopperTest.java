package People;

import MallSystems.PowerSystem;
import Stores.*;
import WorldData.WorldData;
import WorldData.Config;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopperTest {
    @Test
    void addHungerTest() {
        Shopper s = (Shopper) new ShopperBuilder()
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
        Shopper s = (Shopper) new ShopperBuilder()
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
        Shopper s = (Shopper) new ShopperBuilder()
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

        Shopper s = (Shopper) new ShopperBuilder()
                .money(200)
                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();


        ps.setMallPower(false);
        while (wd.getTickCount() < 10) {
            s.updateShopper(wd, ps, sl);
            wd.addTick();
        }

        int result = s.getStress();

        assertEquals(20, result);

    }

    @Test
    void addUpdateShopper2() {


        Config config = new Config();
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ArrayList<Store> sl = new ArrayList<>();

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

        Shopper s = (Shopper) new ShopperBuilder()
                .money(200)
                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();


        ps.setMallPower(false);
        while (wd.getTickCount() < 10) {
            s.updateShopper(wd, ps, sl);
            wd.addTick();
        }

        int result = s.getStress();

        assertEquals(20, result);

    }

}