package ch.bbw.gradesaver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Subject Entity
 * 
 * @author Simon Peier
 */
@Entity
@Table(name = "SUBJECT")
public class Subject {
	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "SubjectID")
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;

	@ElementCollection
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Grade> grades;
	
	public Subject() {
		super();
	}

	public Subject(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public void update(Subject subject) {
		this.name = subject.name;
		this.description = subject.description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	public void addGrade(Grade grade) {
		if (grades == null) {
			grades = new ArrayList<>();
		}

		grades.add(grade);
	}
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
