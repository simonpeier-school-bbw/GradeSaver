package ch.bbw.gradesaver.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bbw.gradesaver.model.Grade;

/**
 * GradeService
 * 
 * @author Simon Peier
 */
@Service
public class GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	public List<Grade> getAllGrades() {
		List<Grade> grades = new ArrayList<>();
		gradeRepository.findAll().forEach(grades::add);

		return grades;
	}

	public void addGrade(Grade grade) {
		gradeRepository.save(grade);
	}

	public void updateGrade(Long id, Grade grade) {
		gradeRepository.deleteById(id);
		gradeRepository.save(grade);
	}

	public void deleteGrade(Long id) {
		gradeRepository.deleteById(id);
	}

	@Override
	public String toString() {
		return "GradeService [grades=" + Arrays.toString(getAllGrades().toArray()) + "]";
	}
}
