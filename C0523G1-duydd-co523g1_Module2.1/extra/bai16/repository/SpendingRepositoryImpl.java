package extra.bai16.repository;

import extra.bai16.Exeptions.IdNotFoundException;
import extra.bai16.model.Spend;
import extra.bai16.utils.Stream;

import java.util.*;

public class SpendingRepositoryImpl implements ISpendingRepository {
    private static final String FILE_PATH = "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\extra\\bai16\\data\\data.csv";
    private static final String BYTE_FILE_PATH = "D:\\CodeGym\\Git\\C0523G1-duydd-co523g1_Module2.1\\extra\\bai16\\data\\data.dat";
    public static final String COMMA = ",";

    @Override
    public List<Spend> displayList() {
        List<Spend> spendList = new ArrayList<>();
        List<String> strings = Stream.readByteStream(BYTE_FILE_PATH);
        String[] arr = null;
        for (String str : strings) {
            arr = str.split(",");
            spendList.add(new Spend(Integer.parseInt(arr[0]), arr[1], arr[2], Float.parseFloat(arr[3]), arr[4]));
        }
        if (!spendList.isEmpty()) {
            return spendList;
        }
        return new ArrayList<>();
    }

    @Override
    public void addNewPlan(Spend spend) {
        List<Spend> spendList = this.displayList();
        spendList.add(spend);
        List<String> strings = this.convertToString(spendList);
        Stream.writeByteStream(BYTE_FILE_PATH, strings);
    }

    @Override
    public String deletePlan(Integer id) {
        List<Spend> spendList = this.displayList();
        for (Spend spend : spendList) {
            if (Objects.equals(spend.getId(), id)) {
                spendList.remove(spend);
                break;
            }
        }
        List<String> strings = this.convertToString(spendList);
        Stream.writeByteStream(BYTE_FILE_PATH, strings);
        return "Plan has been deleted successfully!";
    }

    @Override
    public void editPlan(Integer id, Spend spend) throws IdNotFoundException {
        List<Spend> spendList = this.displayList();
        for (Spend s : spendList) {
            if (Objects.equals(s.getId(), id)) {
                s.setId(id);
                s.setName(spend.getName());
                s.setSpendDate(spend.getSpendDate());
                s.setSpendAmount(spend.getSpendAmount());
                s.setDescription(spend.getDescription());
            }
            List<String> strings = this.convertToString(spendList);
            Stream.writeByteStream(BYTE_FILE_PATH, strings);
        }
        displayList();
    }

    @Override
    public Spend searchPlanById(Integer id) {
        List<Spend> spendList = this.displayList();
        for (int i = 0; i < spendList.size(); i++) {
            if (Objects.equals(spendList.get(i).getId(), id)) {
                return spendList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Spend> proximitySearchByName(String name) {
        List<Spend> spendList = this.displayList();
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
        List<Spend> spendList = this.displayList();
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
        List<Spend> spendList = this.displayList();
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

    private List<String> convertToString(List<Spend> spendList) {
        List<String> strings = new ArrayList<>();
        for (Spend spend : spendList) {
            strings.add(spend.getId() + COMMA + spend.getName() + COMMA + spend.getSpendDate()
                    + COMMA + spend.getSpendAmount() + COMMA + spend.getDescription());
        }
        return strings;
    }
}

