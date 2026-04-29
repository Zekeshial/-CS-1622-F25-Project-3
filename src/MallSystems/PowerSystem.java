package MallSystems;

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

    public void setGenHealth(int genHealth) {
        this.genHealth = genHealth;
    }

    public int getBlackoutTicks() {
        return blackoutTicks;
    }

    public void setBlackoutTicks(int blackoutTicks) {
        this.blackoutTicks = blackoutTicks;
    }

}
