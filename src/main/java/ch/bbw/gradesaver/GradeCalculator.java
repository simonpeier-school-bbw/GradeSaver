package ch.bbw.gradesaver;

import ch.bbw.gradesaver.model.Grade;
import ch.bbw.gradesaver.model.Semester;
import ch.bbw.gradesaver.model.Subject;

public class GradeCalculator {

	/**
	 * Loops through a subject and return the average of all its grades
	 * 
	 * @param subject
	 * @return average of a subject
	 */
	public double subjectAverage(Subject subject) {
		return subject.getGrades().stream().mapToDouble(Grade::getGrade).sum();
	}

	/**
	 * Loops through every subject. For every subject it calculates the average of
	 * all its grades. In the end it calculates the average of all subjects
	 * 
	 * @param semester
	 * @return average of the semester
	 */
	public double semesterAverage(Semester semester) {
		return semester.getSubjects().stream()
				.mapToDouble(s -> s.getGrades().stream().mapToDouble(Grade::getGrade).average().getAsDouble()).average()
				.getAsDouble();
	}
}
