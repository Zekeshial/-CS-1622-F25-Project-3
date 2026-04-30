package People;

public class SecurityBuilder extends PersonBuilder{
    @Override
    public Person build() {
        return new Security(this);
    }
}
