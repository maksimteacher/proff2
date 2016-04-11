package Action11.dao;

import resourses.Contructor;

import java.util.List;


public interface ContructorDao {
    Long create(Contructor contructor);

    Contructor read(Long id);

    void update(Contructor contructor);

    void delete(Contructor contructor);

    List<Contructor> findAll();
}
