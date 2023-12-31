package extra.bai15.service;

public interface ISpendingService {
    void displayList();
    void addNewPlan();
    void deletePlan();
    void editPlan();
    void searchPlanById();
    void proximitySearchByName();
    void ascSortByName();
    void descSortBySpendAmount();
}
