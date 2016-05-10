package service;

import java.util.List;

/**
 * Created by Notebook on 28.04.2016.
 */
public interface Service<T, PK> {

    T get(PK id);
    PK add(T newInstance);
    void update(T transientObject);
    void delete(T persistentObject);
    public List<T> getAll();
}
