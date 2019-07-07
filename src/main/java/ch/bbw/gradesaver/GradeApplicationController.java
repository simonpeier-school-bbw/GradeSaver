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
	public String checkSemesterInfo(@ModelAttribute("semester") @Valid Semester semester, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("GradeApplicationController:checkSemesterInfo(): Problem: " + bindingResult.getErrorCount());
			model.addAttribute("semesters", semesterService.getAllSemesters());
			return "add-semester";
		}
		System.out.println("GradeApplicationController:checkSemesterInfo(): add new Semester:" + semester.toString());
		semesterService.addSemester(semester);
		return "redirect:/";
	}

	@GetMapping("/add-subject/{id}")
	public String addSubject(@PathVariable("id") int id,Model model) {
		model.addAttribute("semester",semesterService.getSemester(id));
		model.addAttribute("subject", new Subject());
		
		System.out.println(semesterService.getSemester(id).toString());
		System.out.println(id);

		return "add-subject";
	}

	@PostMapping("/add-subject")
	public String checkSubjectInfo(@ModelAttribute("subject") Subject subject, @ModelAttribute("semester") Semester semester, BindingResult bindingResult,Model model) {
	/*	if (bindingResult.hasErrors()) {
			System.out.println("GradeApplicationController:checkSemesterInfo(): Problem: " + bindingResult.getErrorCount());
			model.addAttribute("subjects", subjectService.getAllSubjects());
			// ADD semester
			return "add-subject";
		}*/
		System.out.println("Subject Info" + subject.toString());
		System.out.println("Semesterinfo" + semester.toString());

		subject.setSemester(semester);
		subjectService.addSubject(subject);
		return "redirect:/";
	}
}
