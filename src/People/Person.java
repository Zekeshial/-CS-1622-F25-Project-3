package People;

import Interfaces.Movable;
import WorldData.WorldData;

public abstract class Person implements Movable {

    protected int id, x, y;
    protected boolean active;
    protected String name;

    public Person(PersonBuilder builder) {
        this.id = builder.id;
        this.x = builder.x;
        this.y = builder.y;
        this.active = builder.active;
        this.name = builder.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveToward(int tx, int ty, WorldData wd) {
        if (x < tx) x++; else if (x > tx) x--;
        if (y < ty) y++; else if (y > ty) y--;
        x = wd.clamp(x);
        y = wd.clamp(y);
    }
}
