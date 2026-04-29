package People;

public abstract class PersonBuilder {

    protected int id, x, y;
    protected boolean active;
    protected String name;

    public PersonBuilder() {
    }

    public PersonBuilder id(int id) {
        this.id = id;
        return this;
    }

    public PersonBuilder x(int x) {
        this.x = x;
        return this;
    }

    public PersonBuilder y(int y) {
        this.y = y;
        return this;
    }

    public PersonBuilder active(boolean active) {
        this.active = active;
        return this;
    }

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public abstract Person build();

}
