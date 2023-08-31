package service;

import java.util.List;

public interface IService<T> {
    void addNew(T t);
    boolean idExist(String id);
    List<T> display();
}
