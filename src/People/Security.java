package People;

import MallSystems.Mall;
import WorldData.WorldData;

import java.util.ArrayList;

public class Security extends Person {

    public Security(PersonBuilder builder) {
        super(builder);
    }

    public void updateSecurity(ArrayList<Person> pl, Mall m, WorldData wd) {
        for (Person p : pl) {
            try {
                if (p.isActive() && ((Shopper) p).getStress() > 100 || ((VIP) p).getStress() > 100) {
                    moveToward(p.getX(), p.getY(), wd);
                    if (x == p.getX() && y == p.getY()) {
                        System.out.println("SECURITY: Removed " + p.getName() + " for causing a scene.");
                        // Removing a VIP is a major PR disaster
                        if (p instanceof VIP) m.subtractMallReputation(20);
                        p.setActive(false);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


}
