package People;

import MallSystems.Mall;
import MallSystems.PowerSystem;
import Stores.Store;
import WorldData.WorldData;

import java.util.ArrayList;

public class VIP extends Person {

    private double money;
    private int stress;
    private int hunger;

    public VIP(VIPBuilder builder) {
        super(builder);
        this.money = builder.money;
        this.stress = builder.stress;
        this.hunger = builder.hunger;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getStress() {
        return stress;
    }

    public void setStress(int stress) {
        this.stress = stress;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void addHunger(int amt) {
        this.hunger += amt;
    }

    public void updateVIP(WorldData wd, PowerSystem ps, ArrayList<Store> sl, Mall m) {
        // Behavior Logic
        if (hunger > 50) {
            // Seek Food
            Store target = null;
            for (Store s : sl) { // Hardcoded search range
                if (ps.isMallPower() && s.isOpen()) {
                    target = s;
                    break;
                }
            }
            if (target != null) {
                moveToward(target.getX(), target.getY(), wd);
                if (x == target.getX() && y == target.getY()) {
                    double cost = 50.0;
                    if (money >= cost && target.getStock() > 0) {
                        money -= cost;
                        target.addMoneyToVault(cost);
                        target.removeStock(1);
                        hunger = 0;
                        m.addMallReputation(.5);
                    }
                }
            }
        } else {
            x += wd.getRng().nextInt(3) - 1;
            y += wd.getRng().nextInt(3) - 1;
            hunger++;
            // VIPs move an extra step (Double Speed)
            x += wd.getRng().nextInt(3) - 1;
            y += wd.getRng().nextInt(3) - 1;
        }

        // Blackout stress
        if (ps.isMallPower()) {
            stress += 2;
        }

        //Dirt Generation could be a potential source of error look into.
        // Dirt generation
        if (wd.getRng().nextInt(100) < 5) {
            wd.getDebrisMap()[wd.clamp(y)][wd.clamp(x)]++;
        }

        // Stress from dirt
        if (wd.getDebrisMap()[wd.clamp(y)][wd.clamp(x)] > 2) {
            stress += 10; // VIPs hate dirt more
        }
    }
}
