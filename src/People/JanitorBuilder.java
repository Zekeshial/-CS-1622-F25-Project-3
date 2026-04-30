package People;

public class JanitorBuilder extends PersonBuilder{
    @Override
    public Person build() {
        return new Janitor(this);
    }
}
