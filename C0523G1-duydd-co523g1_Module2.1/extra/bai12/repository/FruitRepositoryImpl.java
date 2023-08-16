package extra.bai12.repository;

import extra.bai12.model.Fruit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        if (fruitMap.containsKey(num)){
            return "Cannot use this ID, please try again!"; //Dùng tạm
        } else {
            fruitMap.put(num, fruit);
            return "Success!";
        }
    }

    @Override
    public List<Fruit> displayAll() {
        List<Fruit> fruitList = new ArrayList<>();
        for (Map.Entry<Integer, Fruit> fruit : fruitMap.entrySet()) {
            fruitList.add(fruit.getValue());
        }
        return fruitList;
    }

    @Override
    public String updateFruit(int key, Fruit fruit) {
        boolean fruitExist = false;
        for (Map.Entry<Integer, Fruit> f : fruitMap.entrySet()) {
            if (f.getKey() == key) {
                f.setValue(fruit);
                fruitExist = true;
                break;
            }
        }
        if (fruitExist) {
            return "The fruit has been updated.";
        } else {
            return "The fruit does not exist!";
        }
    }

    @Override
    public String findFruit(int id) {
        return null;
    }
}