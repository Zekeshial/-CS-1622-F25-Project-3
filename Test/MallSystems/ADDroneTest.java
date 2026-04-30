package MallSystems;

import People.Person;
import Stores.*;
import WorldData.WorldData;
import WorldData.Config;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ADDroneTest {
    @Test
    void updateADDroneTest() {

        ADDrone d = new ADDrone(1,20,0,15,1);
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ArrayList<Person> pl = new ArrayList<>();
        ArrayList<Store> sl = new ArrayList<>();

        ps.setMallPower(false);
        d.updateAdDrone(wd, ps, pl, sl);
        int resultActive = d.getActive();
        int resultDebrisMap = wd.getDebrisMap()[20][0];

        assertEquals(2,resultActive);
        assertEquals(15, resultDebrisMap);




    }

    @Test
    void updateADDroneTest2() {


        Config config = new Config();
        ADDrone d = new ADDrone(1,20,0,0,2);
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ArrayList<Person> pl = new ArrayList<>();
        ArrayList<Store> sl = new ArrayList<>();


        FoodStore f = (FoodStore) new FoodStoreBuilder()
                .name("Food_Stall_" + 1)
                .x(50)
                .y(50)
                .stock(100)
                .open(true)
                .build();
        sl.add(f);



        while (wd.getTickCount() < 1000) {
            d.updateAdDrone(wd, ps, pl, sl);
            wd.addTick();
        }

        int resultActive = d.getActive();
        int resultX = d.getX();
        int resultY = d.getY();

        assertEquals(1,resultActive);
        assertEquals(50,resultY);
        assertEquals(50,resultX);

    }


}