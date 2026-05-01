package People;

import MallSystems.Mall;
import WorldData.WorldData;

import java.util.ArrayList;

public class Security extends Person {
    /**
     * Constructor for this class
     * @param builder the builder for the constructor
     */
    public Security(SecurityBuilder builder) {
        super(builder);
    }

    /**
     * The functionality of a person called Security for the program
     * @param pl the list of people for the program
     * @param m the mall of the program
     * @param wd the world data of the program
     */
    public void updateSecurity(ArrayList<Person> pl, Mall m, WorldData wd) {
        for (Person p : pl) {
            try {
                if (p.isActive() && p instanceof Shopper && ((Shopper) p).getStress() > 100 || p.isActive() && p instanceof VIP && ((VIP) p).getStress() > 100) {
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
