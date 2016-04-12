package dao;

import java.util.List;

import domain.Score;

public interface ScoreDao {
	Long create(Score score);
	Score read(Long idScore);
    void update(Score score);
    void delete(Score score);
    List<Score> findAll();
    //List<Lesson> findAllDepartmentsForSchool(Long idDepart);

}
