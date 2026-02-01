package repository.interfaces;

import java.util.List;

public interface CrudRepository<T, ID> {
    void create(T entity);
    List<T> getAll();
    T getById(ID id) throws Exception;
    void update(ID id, T entity) throws Exception;
    void delete(ID id) throws Exception;
}

