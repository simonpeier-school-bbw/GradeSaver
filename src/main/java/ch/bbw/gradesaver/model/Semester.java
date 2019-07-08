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
 * Semester Entity
 * 
 * @author Simon Peier
 */
@Entity
@Table(name = "SEMESTER")
public class Semester {
	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "SemesterID")
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;

	@ElementCollection
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Subject> subjects;

	public Semester() {
		super();
	}

	public Semester(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public void update(Semester semester) {
		this.name = semester.name;
		this.description = semester.description;
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

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public void addSubject(Subject subject) {
		if (subjects == null) {
			subjects = new ArrayList<>();
		}

		subjects.add(subject);
	}

	@Override
	public String toString() {
		return "Semester [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
