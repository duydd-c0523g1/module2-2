package extra.bai12.repository;

import extra.bai12.model.Fruit;

import java.util.*;

public class FruitRepositoryImpl implements IFruitRepository {
    private static Map<Integer, Fruit> fruitMap = new LinkedHashMap<>();

    static {
        fruitMap.put(1, (new Fruit(1, "Apple", "Normal",
                "14/08/2023", "20/08/2023", "Vietnam", 10)));
        fruitMap.put(2, (new Fruit(2, "Orange", "Normal",
                "14/08/2023", "20/08/2023", "Vietnam", 15)));
        fruitMap.put(3, (new Fruit(3, "Banana", "Normal",
                "14/08/2023", "20/08/2023", "Nigeria", 14)));
    }

    @Override
    public String addNew(Integer num, Fruit fruit) {
        fruitMap.put(num, fruit);
        return "Success!"
                + "\n-----------------------------------";
    }

    @Override
    public List<Fruit> displayAll() {
        List<Fruit> fruitList = new ArrayList<>();
        for (Map.Entry<Integer, Fruit> fruit : fruitMap.entrySet()) {
            fruitList.add(fruit.getValue());
        }
        Collections.sort(fruitList);
        return fruitList;
    }

    @Override
    public String updateFruit(int key, Fruit fruit) {
        for (Map.Entry<Integer, Fruit> f : fruitMap.entrySet()) {
            if (f.getKey() == key) {
                f.setValue(fruit);
            }
        }
        return "The fruit has been updated."
                + "\n-----------------------------------";
    }

    @Override
    public Fruit findFruit(int id) {
        List<Fruit> fruitList = new ArrayList<>();
        for (Map.Entry<Integer, Fruit> fruit : fruitMap.entrySet()) {
            if (fruit.getKey() == id) {
                fruitList.add(fruit.getValue());
                break;
            }
        }
        return fruitList.get(0);
    }

    @Override
    public boolean checkIfIdExisted(int id) {
        return fruitMap.containsKey(id);
    }
}