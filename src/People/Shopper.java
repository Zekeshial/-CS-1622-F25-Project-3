package People;

public class Shopper extends Person {
    private double money;
    private int stress;
    private int hunger;

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

    public void addHunger(int amt) {
        this.hunger += amt;
    }




}
