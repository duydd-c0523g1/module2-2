package extra.bai15.repository;

import extra.bai15.model.Spend;

import java.util.List;

public interface ISpendingRepository {
    List<Spend> displayList();
    void addNewPlan(Spend spend);
    String deletePlan(Integer id);
    void editPlan(Integer id, Spend spend);
    Spend searchPlanById(Integer id);
    List<Spend> proximitySearchByName(String name);
    List<Spend> ascSortByName();
    List<Spend> descSortBySpendAmount();
}
