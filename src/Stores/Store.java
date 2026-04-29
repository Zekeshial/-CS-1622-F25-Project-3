package Stores;

public class Store {

    protected int x, y, stock;
    protected double vault;
    protected String name;
    protected boolean open;

    public Store(StoreBuilder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.stock = builder.stock;
        this.vault = builder.vault;
        this.name = builder.name;
        this.open = builder.open;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getVault() {
        return vault;
    }

    public void setVault(double vault) {
        this.vault = vault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
