package Action12.service;

import Action11.dao.ContructorDao;
import resourses.Contructor;

import java.util.List;


public class ContructorServiceImpl implements ContructorService {
    ContructorDao dao;

    public ContructorServiceImpl(ContructorDao dao) {
        this.dao = dao;
    }

    @Override
    public Contructor get(Long id) {
        return dao.read(id);
    }

    @Override
    public void add(Contructor contructor) {
        dao.create(contructor);
    }

    @Override
    public List<Contructor> getAllContructors() {
        return dao.findAll();
    }
}
