package People;

public class VIPBuilder extends PersonBuilder{

    protected double money;
    protected int stress;
    protected int hunger;

    public VIPBuilder money(double money) {
        this.money = money;
        return this;
    }

    public VIPBuilder stress(int stress) {
        this.stress = stress;
        return this;
    }

    public VIPBuilder hunger(int hunger) {
        this.hunger = hunger;
        return this;
    }



    @Override
    public Person build() {
        return new VIP(this);
    }
}
