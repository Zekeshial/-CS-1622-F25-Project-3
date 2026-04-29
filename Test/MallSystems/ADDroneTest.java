package MallSystems;

import People.Person;
import Stores.Store;
import WorldData.WorldData;
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
        int result = d.getActive();

        assertEquals(2,result);


    }

    @Test
    void updateADDroneTest() {

        ADDrone d = new ADDrone(20,0,15,1);
        WorldData wd = new WorldData();
        PowerSystem ps = new PowerSystem();
        ArrayList<Person> pl = new ArrayList<>();
        ArrayList<Store> sl = new ArrayList<>();

        ps.setMallPower(false);
        d.updateAdDrone(wd, ps, pl, sl);
        int result = d.getActive();
        assertEquals(2,result);

    }

    @Test
    void updateADDroneTest() {



    }

}