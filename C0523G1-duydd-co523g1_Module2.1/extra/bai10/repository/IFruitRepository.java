package extra.bai10.repository;

import extra.bai10.model.Fruit;

import java.util.List;

public interface IFruitRepository {
    void addNew(Fruit fruit);
    List<Fruit> displayAll();
}
