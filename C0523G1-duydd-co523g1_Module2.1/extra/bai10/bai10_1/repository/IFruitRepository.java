package extra.bai10.bai10_1.repository;

import extra.bai10.bai10_1.model.Fruit;

import java.util.List;

public interface IFruitRepository {
    void addNew(Fruit fruit);
    List<Fruit> displayAll();
}
