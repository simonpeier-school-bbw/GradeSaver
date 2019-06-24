package ch.bbw.gradesaver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

/**
 * Person Entity
 * 
 * @author Simon Peier
 */
@Entity
public class Semester {
	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence", initialValue = 10)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;

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

	@Override
	public String toString() {
		return "Semester [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
