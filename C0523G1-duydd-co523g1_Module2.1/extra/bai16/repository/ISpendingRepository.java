package extra.bai16.repository;

import extra.bai16.exception.IdNotFoundException;
import extra.bai16.model.Spend;

import java.util.List;

public interface ISpendingRepository {
    List<Spend> displayList();
    void addNewPlan(Spend spend);
    String deletePlan(Integer id);
    void editPlan(Integer id, Spend spend) throws IdNotFoundException;
    Spend searchPlanById(Integer id);
    List<Spend> proximitySearchByName(String name);
    List<Spend> ascSortByName();
    List<Spend> descSortBySpendAmount();
}
