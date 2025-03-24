package codegym.exam.service;

import java.util.List;

public interface IService<T>{

    List<T> getAll();

    void save(T s);

    void update(Long id, T s);

    void remove(Long id);


}
