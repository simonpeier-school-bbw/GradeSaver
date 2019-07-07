package ch.bbw.gradesaver.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.bbw.gradesaver.model.Grade;

/**
 * GradeRepository
 * 
 * @author Simon Peier
 *
 */
@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {

}
