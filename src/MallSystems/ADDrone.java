package MallSystems;

import Interfaces.Movable;
import People.Person;
import People.Shopper;
import People.VIP;
import Stores.Store;
import WorldData.WorldData;

import java.util.ArrayList;

public class ADDrone {

    private int id, x, y, target, active;

    public ADDrone(int id, int x, int y, int target, int active) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.target = target;
        this.active = active;
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

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


    public void updateAdDrone(WorldData wd, PowerSystem ps, ArrayList<Person> pl, ArrayList<Store> sl) {
        for (int i = 0; i < 5; i++) {
            if (active == 0) continue;

            // Power Failure Logic: Drones crash if power is out
            if (!ps.isMallPower() && active == 1) {
                active = 2; // Set to crashed
                wd.getDebrisMap()[y][x] += 15; // Create heavy debris
                System.out.println("DRONE_" + i + " CRASHED at (" + x + "," + y + ")");
                continue;
            }

            // Recovery Logic: If power is back and it was crashed, janitors "reset" them
            if (ps.isMallPower() && active == 2) {
                if (wd.getDebrisMap()[y][x] == 0) { // Janitor cleared the crash site
                    active = 1;
                    x = 0; y = 0; // Respawn at base
                }
                continue;
            }

            if (active == 1) {
                // Move toward target store
                int ts = target;
                if (x < sl.get(ts).getX()) x++; else if (x > sl.get(ts).getX()) x--;
                if (y < sl.get(ts).getY()) y++; else if (y > sl.get(ts).getY()) y--;

                // If reached store, hover and influence shoppers
                if (x == sl.get(ts).getX() && y == sl.get(ts).getY()) {
                    for (Person p : pl) {
                        if (p.isActive() && Math.abs(p.getX() - x) < 10 && Math.abs(p.getY() - y) < 10) {
                            // Drones "suggest" food, increasing hunger so they go to the target store
                            if (p instanceof Shopper) {
                                ((Shopper) p).addHunger(2);
                            } else if (p instanceof VIP) {
                                ((VIP) p).addHunger(2);
                            }
                        }
                    }

                    // Chance to pick a new target store
                    if (wd.getRng().nextInt(100) < 5) {
                        target = wd.getRng().nextInt(20);
                    }
                }

                // Chance to malfunction and generate minor dirt (exhaust)
                if (wd.getRng().nextInt(100) < 2) {
                    wd.getDebrisMap()[y][x]++;
                }
            }
        }
    }
}
