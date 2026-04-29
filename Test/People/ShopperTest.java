package People;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopperTest {
    @Test
    void addHungerTest() {
        Shopper s = (Shopper) new ShopperBuilder()
                .money(200)




                .id(1)
                .x(5)
                .y(5)
                .active(true)
                .name("bob")
                .build();

        s.addHunger(2);
    }

}