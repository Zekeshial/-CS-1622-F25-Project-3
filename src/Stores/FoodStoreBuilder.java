package Stores;

public class FoodStoreBuilder extends StoreBuilder{

    @Override
    public Store build(){
        return new FoodStore(this);
    }
}
