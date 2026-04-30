package Stores;

import Exceptitons.InsufficientFundsException;
import MallSystems.PowerSystem;
import WorldData.WorldData;

public abstract class Store {

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

    public void addMoneyToVault(double amt){
        try {
            if (amt <= 0) {
                throw new IllegalArgumentException("You tried to add a negative amount or no money");
            }
            this.vault += amt;
        } catch (IllegalArgumentException e) {
            System.out.println("Error message: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void removeMoneyFromVault(double amt){
        try {
            if (amt > vault) {
                throw new InsufficientFundsException("You tried to take out more money then was allowed");
            }
            if (amt <= 0) {
                throw new IllegalArgumentException("You tried to remove a negative amount or no money");
            }
            this.vault += amt;
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Error message: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void addStock(int amt) {
        try {
            if (amt <= 0) {
                throw new IllegalArgumentException("You tried to add a negative amount or 0");
            }
            this.stock += amt;
        } catch (IllegalArgumentException e) {
            System.out.println("Error message: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeStock(int amt) {
        try {
            if (amt > stock) {
                throw new InsufficientFundsException("You tried to take out more money then was allowed");
            }
            if (amt <= 0) {
                throw new IllegalArgumentException("You tried to remove a negative amount or no money");
            }
            this.stock += amt;
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Error message: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStoreSystem(WorldData wd, PowerSystem ps) {
        if (stock <= 0) open = false;
        if (ps.isMallPower() && wd.getTickCount() % 50 == 0) stock += 5; // Passive restock
    }
}
