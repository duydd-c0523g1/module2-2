package extra.bai10.bai10_1.repository;

import extra.bai10.bai10_1.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRepositoryImpl implements  IFruitRepository{
    static List<Fruit> fruitList = new ArrayList<>();
    static {
        fruitList.add(new Fruit("Apple", "Normal",
                "14/08/2023", "20/08/2023", "Vietnam", 10));
        fruitList.add(new Fruit("Orange", "Normal",
                "14/08/2023", "20/08/2023", "Vietnam", 15));
        fruitList.add(new Fruit("Banana", "Normal",
                "14/08/2023", "20/08/2023", "Nigeria", 14));
    }
    @Override
    public void addNew(Fruit fruit) {
        fruitList.add(fruit);
    }

    @Override
    public List<Fruit> displayAll() {
        return fruitList;
    }
}
