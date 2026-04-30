package People;

import MallSystems.Mall;
import WorldData.WorldData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {

    @Test
    void updateSecurityTest() {
        Mall m = new Mall();
        WorldData wd = new WorldData();
        ArrayList<Person> pl = new ArrayList<>();

        Shopper shopper = (Shopper) new ShopperBuilder()
                .money(200)
                .id(1)
                .x(50)
                .y(50)
                .active(true)
                .name("Shopper_" + 1)
                .build();
        pl.add(shopper);

        VIP v = (VIP) new VIPBuilder()
                .money(1000)
                .name("VIP_" + (115))
                .x(50)
                .y(50)
                .active(true)
                .build();
        pl.add(v);


        Security security = (Security) new SecurityBuilder()
                .name("Guard_" + (110))
                .x(25)
                .y(25)
                .active(true)
                .build();
        pl.add(security);

        shopper.setStress(120);
        v.setStress(120);

        while (wd.getTickCount() < 100) {
            security.updateSecurity(pl,m,wd);
            wd.addTick();
        }

        int result = 0;

        for (Person p: pl) {
            if (p instanceof Shopper) {
                if(p.isActive()) {
                    result += 1;
                }
            } else if (p instanceof VIP) {
                if(p.isActive()) {
                    result += 1;
                }
            }
        }


        assertEquals(0, result);

    }

    @Test
    void updateSecurityTest2() {
        Mall m = new Mall();
        WorldData wd = new WorldData();
        ArrayList<Person> pl = new ArrayList<>();

        Shopper shopper = (Shopper) new ShopperBuilder()
                .money(200)
                .id(1)
                .x(50)
                .y(50)
                .active(true)
                .name("Shopper_" + 1)
                .build();
        pl.add(shopper);

        VIP v = (VIP) new VIPBuilder()
                .money(1000)
                .name("VIP_" + (115))
                .x(50)
                .y(50)
                .active(true)
                .build();
        pl.add(v);


        Security security = (Security) new SecurityBuilder()
                .name("Guard_" + (110))
                .x(25)
                .y(25)
                .active(true)
                .build();
        pl.add(security);

        shopper.setStress(120);
        v.setStress(120);

        while (wd.getTickCount() < 100) {
            security.updateSecurity(pl,m,wd);
            wd.addTick();
        }

        double result = m.getMallReputation();

        assertEquals(80, result);

    }

    @Test
    void updateSecurityTest3() {
        Mall m = new Mall();
        WorldData wd = new WorldData();
        ArrayList<Person> pl = new ArrayList<>();

        Shopper shopper = (Shopper) new ShopperBuilder()
                .money(200)
                .id(1)
                .x(50)
                .y(50)
                .active(true)
                .name("Shopper_" + 1)
                .build();
        pl.add(shopper);

        Shopper shopper2 = (Shopper) new ShopperBuilder()
                .money(200)
                .id(2)
                .x(50)
                .y(50)
                .active(true)
                .name("Shopper_" + 2)
                .build();
        pl.add(shopper2);

        VIP v = (VIP) new VIPBuilder()
                .money(1000)
                .name("VIP_" + (115))
                .x(50)
                .y(50)
                .active(true)
                .build();
        pl.add(v);


        Security security = (Security) new SecurityBuilder()
                .name("Guard_" + (110))
                .x(25)
                .y(25)
                .active(true)
                .build();
        pl.add(security);

        shopper.setStress(120);
        v.setStress(120);

        while (wd.getTickCount() < 100) {
            security.updateSecurity(pl,m,wd);
            wd.addTick();
        }

        int result = 0;

        for (Person p: pl) {
            if (p instanceof Shopper) {
                if(p.isActive()) {
                    result += 1;
                }
            } else if (p instanceof VIP) {
                if(p.isActive()) {
                    result += 1;
                }
            }
        }


        assertEquals(1, result);

    }

}