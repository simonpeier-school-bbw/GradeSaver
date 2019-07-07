package ch.bbw.gradesaver.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.bbw.gradesaver.model.Subject;

/**
 * SubjectRepository
 * 
 * @author Simon Peier
 *
 */
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
