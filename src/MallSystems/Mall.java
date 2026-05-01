package MallSystems;

import People.*;
import Stores.ClothStore;
import Stores.FoodStore;
import Stores.Store;
import Stores.StoreBuilder;
import WorldData.WorldData;
import WorldData.Config;

import java.util.ArrayList;

public class Mall {
    private double mallReputation;

    public Mall(double mallReputation) {
        this.mallReputation = mallReputation;
    }

    public Mall() {
        this.mallReputation = 100;
    }

    public double getMallReputation() {
        return mallReputation;
    }

    public void setMallReputation(double mallReputation) {
        this.mallReputation = mallReputation;
    }

    /**
     * Adds rep to the malls reputation
     * @param amt amount you wish to add
     */
    public void addMallReputation(double amt) {
        this.mallReputation += amt;
    }

    /**
     * removes rep from the malls reputation
     * @param amt amount you wish to remove
     */
    public void subtractMallReputation(double amt) {
        this.mallReputation -= amt;
    }

    /**
     * A print out of information regarding the status of the mall
     * @param wd the world data of the program
     * @param ps the power system of the program
     * @param pl the list of people in the program
     * @param sl the list of stores in the program
     * @param config the config of the program
     */
    public void printMallStatus(WorldData wd, PowerSystem ps, ArrayList<Person> pl, ArrayList<Store> sl, Config config) {
        System.out.println("=========================================");
        System.out.println("       OMNI-MALL EXECUTIVE SUMMARY       ");
        System.out.println("=========================================");

        // 1. System Health Section
        System.out.println("[SYSTEMS]");
        System.out.print("  Power Status: " + (ps.isMallPower() ? "STABLE" : "CRITICAL BLACKOUT"));
        System.out.println(" | Generator Health: " + ps.getGenHealth() + "%");
        System.out.println("  Mall Reputation Score: " + String.format("%.2f", mallReputation));

        // 2. Population Breakdown (Procedural headcount)
        int shoppers = 0, janitors = 0, guards = 0, vips = 0;
        for (Person p : pl) {
            if (!p.isActive()) continue;
            if (p instanceof Shopper) shoppers++;
            else if (p instanceof Janitor) janitors++;
            else if (p instanceof Security) guards++;
            else if (p instanceof VIP) vips++;
        }
        System.out.println("[POPULATION]");
        System.out.println("  Shoppers: " + shoppers + " | VIPs: " + vips);
        System.out.println("  Security: " + guards + " | Janitors: " + janitors);

        // 3. Environmental Analysis
        long totalDirt = 0;
        for (int y = 0; y < config.getMapSize(); y++) {
            for (int x = 0; x < config.getMapSize(); x++) {
                totalDirt += wd.getDebrisMap()[x][y];
            }
        }

        // Find the "Filthiest Store" (Nested search around every store coordinate)
        Store filthiestStore = null;
        int maxLocalDirt = -1;
        for (Store store : sl) {
            if (store.getName() == null) continue;
            int localDirt = 0;
            for (int r = -3; r <= 3; r++) {
                for (int c = -3; c <= 3; c++) {
                    localDirt += wd.getDebrisMap()[wd.clamp(store.getX() + r)][wd.clamp(store.getY() + c)];
                }
            }
            if (localDirt > maxLocalDirt) { maxLocalDirt = localDirt; filthiestStore = store; }
        }
        System.out.println("[ENVIRONMENT]");
        System.out.println("  Total Mall Debris: " + totalDirt + " units");
        if (filthiestStore != null) {
            System.out.println("  Cleanliness Alert: " + filthiestStore.getName() + " region is FILTHY (" + maxLocalDirt + " units)");
        }

        // 4. Financials Section
        double foodRev = 0, boutiqueRev = 0, totalRev = 0;
        Store beststore = sl.getFirst();
        for (Store store : sl) {
            if (store.getName() == null) continue;
            totalRev += store.getVault();
            if (store instanceof FoodStore) foodRev += store.getVault();
            else if (store instanceof ClothStore) boutiqueRev += store.getVault();
            if (store.getVault() > beststore.getVault()) beststore = store;
        }
        System.out.println("[FINANCIAL PERFORMANCE]");
        System.out.println("  Total Revenue: $" + String.format("%.2f", totalRev));
        System.out.println("  Category Breakdown -> Food: $" + foodRev + " | Boutiques: $" + boutiqueRev);
        if (beststore.getName() != null) {
            System.out.println("  Top Performer: " + beststore.getName() + " ($" + String.format("%.2f", beststore.getVault()) + ")");
        }
        System.out.println("=========================================\n");
    }


}
