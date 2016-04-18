package service;

import java.util.List;

import dao.ContructorDao;
import domain.Contructor;

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
