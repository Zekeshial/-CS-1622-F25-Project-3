package People;

public class ShopperBuilder extends PersonBuilder {

    protected double money;
    protected int stress;
    protected int hunger;

    public ShopperBuilder money(double money) {
        this.money = money;
        return this;
    }

    public ShopperBuilder stress(int stress) {
        this.stress = stress;
        return this;
    }

    public ShopperBuilder hunger(int hunger) {
        this.hunger = hunger;
        return this;
    }



    @Override
    public Person build() {
        return new Shopper(this);
    }
}
