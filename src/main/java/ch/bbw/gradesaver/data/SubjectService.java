package ch.bbw.gradesaver.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bbw.gradesaver.model.Subject;

/**
 * SubjectService
 * 
 * @author Simon Peier
 */
@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> getAllSubjects() {
		List<Subject> subjects = new ArrayList<>();
		subjectRepository.findAll().forEach(subjects::add);

		return subjects;
	}

	public void addSubject(Subject subject) {
		subjectRepository.save(subject);
	}

	public void updateSubject(Long id, Subject subject) {
		subjectRepository.deleteById(id);
		subjectRepository.save(subject);
	}

	public void deleteSubject(Long id) {
		subjectRepository.deleteById(id);
	}

	@Override
	public String toString() {
		return "SubjectService [subjects=" + Arrays.toString(getAllSubjects().toArray()) + "]";
	}
}
