package extra.bai13.repository;

import extra.bai13.model.Spend;

import java.util.List;

public interface ISpendingRepository {
    List<Spend> displayList();
    void addNewPlan(Spend spend);
    String deletePlan(Integer id);
    void editPlan(Integer id, Spend spend);
    Spend searchPlanById(Integer id);
    List<Spend> proximitySearchByName(String name);
}
