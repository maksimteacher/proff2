package dao;

import java.util.List;

public interface GenericDao<T, PK> {
    PK create(T newInstance);
    T read(PK id);
    void update(T transientObject);
    void delete(T persistentObject);
    List<T> findAll();
    T findAllByRestrictionEq (String propertyName, String objectValue);
}
