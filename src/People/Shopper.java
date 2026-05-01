package People;

import MallSystems.PowerSystem;
import Stores.Store;
import WorldData.WorldData;

import java.util.ArrayList;

public class Shopper extends Person {
    private double money;
    private int stress;
    private int hunger;
    /**
     * Constructor for this class
     * @param builder the builder for the constructor
     */
    public Shopper(ShopperBuilder builder) {
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

    /**
     * adds hunger to a shopper
     * @param amt the amount you wish to add
     */
    public void addHunger(int amt) {
        this.hunger += amt;
    }

    /**
     * The functionality of a shopper in the program
     * @param wd thw world data of the program
     * @param ps the power system of the program
     * @param sl the list of stores for the program
     */
    public void updateShopper(WorldData wd, PowerSystem ps, ArrayList<Store> sl) {
        if (active) {
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
                        double cost = 10.0;
                        if (money >= cost && target.getStock() > 0) {
                            money -= cost;
                            target.addMoneyToVault(cost);
                            target.removeStock(1);
                            hunger = 0;
                        }
                    }
                }
            } else {
                x += wd.getRng().nextInt(3) - 1;
                y += wd.getRng().nextInt(3) - 1;
                hunger++;
            }

            // Blackout stress
            if (!ps.isMallPower()) {
                stress += 2;
            }

            //Dirt Generation could be a potential source of error look into.
            // Dirt generation
            if (wd.getRng().nextInt(100) < 5) {
                wd.getDebrisMap()[wd.clamp(x)][wd.clamp(y)]++;
            }

            // Stress from dirt
            if (wd.getDebrisMap()[wd.clamp(x)][wd.clamp(y)] > 2) {
                stress += 5;
            }
        }
    }

    @Override
    public String toString() {
        return "Shopper{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", stress=" + stress +
                ", hunger=" + hunger +
                '}';
    }
}
