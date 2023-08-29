package repository;

import java.util.List;

public interface IRepository<T> {
    List<T> displayList();

    void addNew(T t);
}
