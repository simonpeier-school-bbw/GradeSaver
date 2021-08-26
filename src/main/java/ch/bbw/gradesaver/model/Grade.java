package ch.bbw.gradesaver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

/**
 * Grade Entity
 * 
 * @author Simon Peier
 */
@Entity
@Table(name = "GRADE")
public class Grade {
	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Min(1)
	@Max(6)
	private double grade;

	@NotEmpty
	private String description;

	public Grade() {
		super();
	}

	public Grade(Long id, int grade, String description) {
		super();
		this.id = id;
		this.grade = grade;
		this.description = description;
	}

	public void update(Grade grade) {
		this.grade = grade.grade;
		this.description = grade.description;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", grade=" + grade + ", description=" + description + "]";
	}
}
