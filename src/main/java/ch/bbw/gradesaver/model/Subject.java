package ch.bbw.gradesaver.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@OneToMany(cascade = { CascadeType.ALL })
	private List<Grade> grades;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SemesterID", nullable = false)
	private Semester semester;

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
	
	public void setSemester(Semester semester) {
		this.semester = semester; 
	}
	
	public Semester getSemester() {
		return semester;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
