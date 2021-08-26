package ch.bbw.gradesaver.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.bbw.gradesaver.model.Semester;

/**
 * SemesterRepository
 * 
 * @author Simon Peier
 *
 */
@Repository
public interface SemesterRepository extends CrudRepository<Semester, Long>{

}
