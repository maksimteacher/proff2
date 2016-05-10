package service;

import dao.GenericDao;
import dao.GenericDaoImpl;

import java.util.List;

abstract class ServiceAbstract<T, PK> implements Service<T, PK> {
    private final Class TYPE;
    protected GenericDao dao;

    public ServiceAbstract(Class type) {
        TYPE = type;
        dao = new GenericDaoImpl(type);
    }

    @Override
    public T get(PK id) {
       return (T) dao.read(id);
    }

    @Override
    public PK add(T newInstance) {
        return (PK) dao.create(newInstance);
    }

    @Override
    public void update(T transientObject) {
        dao.update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        dao.delete(persistentObject);
    }

    @Override
    public List<T> getAll() {
        return dao.findAll();
    }

}