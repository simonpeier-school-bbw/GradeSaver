package ch.bbw.gradesaver.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bbw.gradesaver.model.Semester;

/**
 * SemesterService
 * 
 * @author Simon Peier
 */
@Service
public class SemesterService {

	@Autowired
	private SemesterRepository semesterRepository;

	public List<Semester> getAllSemesters() {
		List<Semester> semesters = new ArrayList<>();
		semesterRepository.findAll().forEach(semesters::add);
		return semesters;
	}

	public void addSemester(Semester semester) {
		semesterRepository.save(semester);
	}

	public Semester getSemester(long id) {
		return semesterRepository.findById(id).get();
	}

	public void updateSemester(Long id, Semester semester) {
		semesterRepository.save(semester);
	}

	public void deleteSemester(Long id) {
		semesterRepository.deleteById(id);
	}

	@Override
	public String toString() {
		return "SemesterService [semesters=" + Arrays.toString(getAllSemesters().toArray()) + "]";
	}
}
