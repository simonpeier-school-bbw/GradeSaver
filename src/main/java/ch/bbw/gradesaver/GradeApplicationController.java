package ch.bbw.gradesaver;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ch.bbw.gradesaver.data.GradeService;
import ch.bbw.gradesaver.data.SemesterService;
import ch.bbw.gradesaver.data.SubjectService;
import ch.bbw.gradesaver.model.Grade;
import ch.bbw.gradesaver.model.Semester;
import ch.bbw.gradesaver.model.Subject;

/**
 * PersonController
 * 
 * @author Simon Peier
 */
@Controller
public class GradeApplicationController {
	@Autowired
	SemesterService semesterService;

	@Autowired
	SubjectService subjectService;

	@Autowired
	GradeService gradeService;

	private Semester currentSemester;
	private Subject currentSubject;

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("semester", new Semester());
		model.addAttribute("semesters", semesterService.getAllSemesters());
		return "index";
	}

	@GetMapping("/add-semester")
	public String addSemester(Model model) {
		model.addAttribute("semester", new Semester());
		return "add-semester";
	}

	@PostMapping("/add-semester")
	public String checkSemesterInfo(@ModelAttribute("semester") @Valid Semester semester, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("checkSemesterInfo(): Problem: " + bindingResult.getErrorCount());
			model.addAttribute("semesters", semesterService.getAllSemesters());
			return "add-semester";
		}

		System.out.println("GradeApplicationController:checkSemesterInfo(): add new Semester:" + semester.toString());
		semesterService.addSemester(semester);
		return "redirect:/";
	}

	@GetMapping("/add-subject/{id}")
	public String addSubject(@PathVariable("id") int id, Model model) {
		currentSemester = semesterService.getSemester(id);

		model.addAttribute("semester", currentSemester);
		model.addAttribute("subject", new Subject());

		System.out.println(currentSemester);
		System.out.println(id);

		return "add-subject";
	}

	@PostMapping("/add-subject")
	public String checkSubjectInfo(@ModelAttribute("subject") Subject subject, Model model,
			BindingResult bindingResult) {
		/*
		 * if (bindingResult.hasErrors()) { System.out.
		 * println("GradeApplicationController:checkSemesterInfo(): Problem: " +
		 * bindingResult.getErrorCount()); model.addAttribute("subjects",
		 * subjectService.getAllSubjects()); // ADD semester return "add-subject"; }
		 */
		System.out.println("Subject Info" + subject.toString());
		System.out.println("Semesterinfo" + currentSemester.toString());

		currentSemester.addSubject(subject);
		semesterService.updateSemester(currentSemester.getId(), currentSemester);

		// subjectService.addSubject(subject);
		return "redirect:/";
	}

	@GetMapping("/add-grade/{id}")
	public String addGrade(@PathVariable("id") int id, Model model) {
		currentSubject = subjectService.getSubject(id);
		model.addAttribute("subject", currentSubject);
		model.addAttribute("grade", new Grade());

		System.out.println(currentSubject);
		System.out.println(Integer.toString(id));

		return "add-grade";
	}

	@PostMapping("/add-grade")
	public String checkGradeInfo(@Valid @ModelAttribute("grade") Grade grade, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println("checkSemesterInfo(): Problem: " + bindingResult.getErrorCount());
			model.addAttribute("subject", currentSubject);
			return "add-grade";
		}
		System.out.println("Grade Info: " + grade.toString());
		System.out.println("SubjectInfo: " + currentSubject.toString());

		currentSubject.addGrade(grade);
		subjectService.updateSubject(currentSubject.getId(), currentSubject);

		// subjectService.addSubject(subject);
		return "redirect:/";
	}
}
