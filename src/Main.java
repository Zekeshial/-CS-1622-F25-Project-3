import MallSystems.ADDrone;
import MallSystems.Mall;
import MallSystems.PowerSystem;
import People.*;
import Stores.*;
import WorldData.WorldData;
import WorldData.Config;

import java.util.ArrayList;

public class Main {
    static void setupSimulation(ArrayList<Person> pl, ArrayList<Store> sl, ArrayList<ADDrone> dl, WorldData wd) {
        Config config = new Config();
        // Initialize Stores
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

        // Initialize People
        for (int i = 0; i < 100; i++) {
            Shopper s = (Shopper) new ShopperBuilder()
                    .money(200)
                    .id(i)
                    .x(50)
                    .y(50)
                    .active(true)
                    .name("Shopper_" + i)
                    .build();
            pl.add(s);
        }
        for (int i = 100; i < 110; i++) {
            Janitor j = (Janitor) new JanitorBuilder()
                    .name("Janitor_" + (i-100))
                    .x(0)
                    .y(0)
                    .active(true)
                    .build();
            pl.add(j);
        }
        for (int i = 110; i < 115; i++) {
            Security s = (Security) new SecurityBuilder()
                    .name("Guard_" + (i-110))
                    .x(25)
                    .y(25)
                    .active(true)
                    .build();
            pl.add(s);
        }
        // Initialize VIPs
        for (int i = 115; i < 120; i++) {
            VIP v = (VIP) new VIPBuilder()
                    .money(1000)
                    .name("VIP_" + (i-115))
                    .x(50)
                    .y(50)
                    .active(true)
                    .build();
            pl.add(v);
        }
        // Initialize Drones
        for (int i = 0; i < 5; i++) {
            ADDrone d = new ADDrone(
                    i,
                    i*20
                    ,0
                    ,wd.getRng().nextInt(20)
                    ,1);
            dl.add(d);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();

        ArrayList<Person> personList = new ArrayList<>(config.getMaxPeople());
        ArrayList<Store> storeList = new ArrayList<>(config.getMaxStores());
        ArrayList<ADDrone> droneList = new ArrayList<>(config.getMaxADDrone());

        PowerSystem ps = new PowerSystem();
        WorldData wd = new WorldData();
        Mall m = new Mall();






        setupSimulation(personList, storeList, droneList, wd);

        // Run for 1000 ticks
        while (wd.getTickCount() < 1000) {
            //Updating People in the List of people
            for (Person p : personList) {
                if (p instanceof Shopper) {
                    ((Shopper) p).updateShopper(wd, ps, storeList);
                } else if (p instanceof Janitor) {
                    ((Janitor) p).updateJanitors(ps, wd);
                } else if (p instanceof Security) {
                    ((Security) p).updateSecurity(personList, m, wd);
                } else if (p instanceof VIP) {
                    ((VIP) p).updateVIP(wd, ps, storeList, m);
                }
            }
            //Updating a Store in the List of Stores
            for (Store s : storeList) {
                s.updateStoreSystem(wd, ps);
            }
            //Updating the PowerGrid
            ps.updatePowerGrid(wd);

            //Updating a drone from the List of Drones
            for (ADDrone drone : droneList) {
                drone.updateAdDrone(wd, ps, personList, storeList);
            }

            if (wd.getTickCount() % 100 == 0) {
                m.printMallStatus(wd,ps,personList, storeList, config);
            }

            wd.addTick();
            Thread.sleep(10);
        }
        System.out.println("SIMULATION ENDED: Mall Closed.");
    }
}
