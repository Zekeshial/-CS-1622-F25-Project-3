package Stores;

public class ClothStoreBuilder extends StoreBuilder{

    @Override
    public Store build(){
        return new ClothStore(this);
    }
}
