package ch.bbw.gradesaver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;

/**
 * Person Entity
 * 
 * @author Simon Peier
 */
@Entity
public class Grade {
	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence", initialValue = 10)
	private Long id;

	@NotNull
	@Min(1)
	@Max(6)
	private int grade;

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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
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
