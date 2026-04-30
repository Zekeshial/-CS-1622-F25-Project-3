package MallSystems;

public class Mall {
    private double mallReputation;

    public Mall(double mallReputation) {
        this.mallReputation = mallReputation;
    }

    public Mall() {
        this.mallReputation = 100;
    }

    public double getMallReputation() {
        return mallReputation;
    }

    public void setMallReputation(double mallReputation) {
        this.mallReputation = mallReputation;
    }

    public void addMallReputation(double amt) {
        this.mallReputation += amt;
    }

    public void subtractMallReputation(double amt) {
        this.mallReputation -= amt;
    }


}
