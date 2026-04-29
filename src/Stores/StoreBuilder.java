package Stores;

import People.Person;
import People.PersonBuilder;

public abstract class StoreBuilder {

    protected int x, y, stock;
    protected double vault;
    protected String name;
    protected boolean open;


    public StoreBuilder() {
    }

    public StoreBuilder x(int x) {
        this.x = x;
        return this;
    }

    public StoreBuilder y(int y) {
        this.y = y;
        return this;
    }

    public StoreBuilder stock(int stock) {
        this.stock = stock;
        return this;
    }

    public StoreBuilder vault(double vault) {
        this.vault = vault;
        return this;
    }

    public StoreBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StoreBuilder open(boolean open) {
        this.open = open;
        return this;
    }

    public abstract Store build();

}
