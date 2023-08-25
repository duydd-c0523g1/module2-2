package service;

import java.util.List;

public interface IService<T> {
    void addNew(T t);
    List<T> display();
}
