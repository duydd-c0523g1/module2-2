package extra.bai13.repository;

import extra.bai13.model.Spend;

import java.util.*;

public class SpendingRepositoryImpl implements ISpendingRepository {
    private static Map<Integer, Spend> spendMap = new LinkedHashMap<>();

    static {
        spendMap.put(1, new Spend(1, "Buy VinFast VF9"
                , "20/10/2022", 50000, "Full options"));
        spendMap.put(2, new Spend(2, "Buy Villa"
                , "13/06/2026", 700000, "Sea sided"));
        spendMap.put(3, new Spend(3, "Private Jet"
                , "02/01/2032", 9000000, "Full options"));
    }

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
        boolean idExist = true;
        int idIterate = 1;
        while (idExist == true) {
            if (spendMap.containsKey(spendMap.size() + idIterate)) {
                idIterate++;
            } else {
                break;
            }
            spend.setId(spendMap.size() + idIterate);
        }
        spendMap.put(spend.getId(), spend);
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
    public void editPlan(Integer id, Spend spend) {
        for (Map.Entry<Integer, Spend> value : spendMap.entrySet()) {
            if (Objects.equals(value.getKey(), id)) {
                value.getValue().setId(id);
                value.getValue().setName(spend.getName());
                value.getValue().setSpendDate(spend.getSpendDate());
                value.getValue().setSpendAmount(spend.getSpendAmount());
                value.getValue().setDescription(spend.getDescription());
            }
        }
        displayList();
    }

    @Override
    public List<Spend> searchPlanById(Integer id) {
        List<Spend> spendList = new ArrayList<>();
        for (Map.Entry<Integer, Spend> value : spendMap.entrySet()) {
            if (Objects.equals(value.getKey(), id)) {
                spendList.add(value.getValue());
            }
        }
        return spendList;
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
}
