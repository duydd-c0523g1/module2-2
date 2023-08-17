package extra.bai12.repository;

import extra.bai12.model.Fruit;

import java.util.List;
import java.util.Map;

public interface IFruitRepository {
    String addNew(Integer num, Fruit fruit);
    List<Fruit> displayAll();
    String updateFruit(int key, Fruit fruit);
    Fruit findFruit(int id);
}
