package extra.bai14.repository;

import extra.bai14.model.Spend;

import java.util.*;

public class SpendingRepositoryImpl implements ISpendingRepository {
    private static final Map<Integer, Spend> spendMap = new LinkedHashMap<>();

    static {
        spendMap.put(1, new Spend(1, "Buy VinFast VF9"
                , "20/10/2022", 50000, "Full options"));
        spendMap.put(2, new Spend(2, "Buy Villa"
                , "13/06/2026", 700000, "Sea sided"));
        spendMap.put(3, new Spend(3, "Buy Private Jet"
                , "02/01/2032", 9000000, "Private pilot included"));
        spendMap.put(4, new Spend(4, "Buy Private Cruiser"
                , "02/01/2032", 9000000, "Private pilot included"));
    }

    static int idCount = 5;

    @Override
    public List<Spend> displayList() {
        List<Spend> spendList = new ArrayList<>();
        for (Map.Entry<Integer, Spend> value : spendMap.entrySet()) {
            spendList.add(value.getValue());
        }
        return spendList;
    }

    @Override
    public void addNewPlan(Spend spend) {
//        int idIncrement = 1;
//        while (true) {
//            if (spendMap.containsKey(spendMap.size() + idIncrement)) {
//                idIncrement++;
//            } else {
//                break;
//            }
//        }
//        spend.setId(spendMap.size() + idIncrement);
        spend.setId(idCount);
        spendMap.put(spend.getId(), spend);
        idCount++;
    }

    @Override
    public String deletePlan(Integer id) {
        if (spendMap.containsKey(id)) {
            spendMap.remove(id);
            return "Plan has been removed";
        } else {
            return "ID does not exist, please try again";
        }
    }

    @Override
    public String editPlan(Integer id, Spend spend) {
        for (Map.Entry<Integer, Spend> value : spendMap.entrySet()) {
            if (Objects.equals(value.getKey(), id)) {
                value.getValue().setId(id);
                value.getValue().setName(spend.getName());
                value.getValue().setSpendDate(spend.getSpendDate());
                value.getValue().setSpendAmount(spend.getSpendAmount());
                value.getValue().setDescription(spend.getDescription());
                return "Success!";
            }
        }
        return "ID does not exist!";
    }

    @Override
    public Spend searchPlanById(Integer id) {
        for (Map.Entry<Integer, Spend> value : spendMap.entrySet()) {
            if (Objects.equals(value.getKey(), id)) {
                return value.getValue();
            }
        }
        return null;
    }

    @Override
    public List<Spend> proximitySearchByName(String name) {
        List<Spend> spendList = new ArrayList<>(spendMap.values());
        List<Spend> result = new ArrayList<>();
        for (Spend spend : spendList) {
            if (spend.getName().startsWith(name)) {
                result.add(spend);
            }
        }
        return result;
    }

    @Override
    public List<Spend> ascSortByName() {
        List<Spend> spendList = new ArrayList<>();
        for (Map.Entry<Integer, Spend> spend : spendMap.entrySet()) {
            spendList.add(spend.getValue());
        }
        spendList.sort(new Comparator<Spend>() {
            @Override
            public int compare(Spend o1, Spend o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return spendList;
    }

    @Override
    public List<Spend> descSortBySpendAmount() {
        List<Spend> spendList = new ArrayList<>();
        for (Map.Entry<Integer, Spend> spend : spendMap.entrySet()) {
            spendList.add(spend.getValue());
        }
        spendList.sort(new Comparator<Spend>() {
            @Override
            public int compare(Spend o1, Spend o2) {
                if (o1.getSpendAmount() == o2.getSpendAmount()) {
                    return o2.getName().compareTo(o1.getName());
                } else if (o2.getSpendAmount() > o1.getSpendAmount()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return spendList;
    }
}
