package Action12.service;

import resourses.Contructor;

import java.util.List;


public interface ContructorService {
    Contructor get(Long id);

    void add(Contructor contructor);

    List<Contructor> getAllContructors();
}
