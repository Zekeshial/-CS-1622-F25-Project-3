package MallSystems;

import WorldData.WorldData;

public class PowerSystem {
    private boolean mallPower = true;
    private int genHealth = 100;
    private int blackoutTicks = 0;


    public boolean isMallPower() {
        return mallPower;
    }

    public void setMallPower(boolean mallPower) {
        this.mallPower = mallPower;
    }

    public int getGenHealth() {
        return genHealth;
    }

    /**
     * Adds 2 to the health of the generator
     */
    public void addGenHealth() {
        genHealth = Math.min(100, genHealth + 2);
    }

    public void setGenHealth(int genHealth) {
        this.genHealth = genHealth;
    }

    public int getBlackoutTicks() {
        return blackoutTicks;
    }

    public void setBlackoutTicks(int blackoutTicks) {
        this.blackoutTicks = blackoutTicks;
    }

    /**
     * the functionality of the power system of the program
     * @param wd the world data of the program
     */
    public void updatePowerGrid(WorldData wd) {
        if (blackoutTicks > 0) {
            blackoutTicks--;
            if (blackoutTicks == 0) {
                mallPower = true;
                System.out.println(">> POWER RESTORED");
            }
        } else {
            // Decay health and check for failure
            if (wd.getTickCount() % 5 == 0) genHealth--;
            if (wd.getRng().nextInt(120) > genHealth) {
                mallPower = false;
                blackoutTicks = 30 + wd.getRng().nextInt(40);
                System.out.println(">> BLACKOUT! Generator Health: " + genHealth);
            }
        }
    }

}
