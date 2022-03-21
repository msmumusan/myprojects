package com.mumu.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mumu.sm.DAO.StudentDAO;
import com.mumu.sm.DTO.StudentDTO;
import com.mumu.sm.api.Student;
import com.mumu.sm.services.StudentService;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

@Controller
public class StudentController {

	// @Autowired
	// private StudentDAO studentDao;

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/showAllStudents")
	public String showAllStudentsInfo(Model model) {

		// call the Service method to get data
		List<Student> studentList = studentService.getAllStudents();
		System.out.println("Calling Service method...");
		for (Student student : studentList) {
			System.out.println(student);
		}

		model.addAttribute("students", studentList);

		return "students-list";
	}

	@GetMapping(value = "/addStudent")
	public String addStudent(Model model) {

		Student student = new Student();

		model.addAttribute("student", student);

		return "add-student";
	}

	// @ResponseBody
	@PostMapping(value = "/save-student")
	public String saveStudent(Student student) {

		System.out.println(student);
		System.out.println(student.getId());

		if (student.getId() == 0) {
			studentService.saveStudent(student);
		} else {
			studentService.updateStudent(student);
		}

		// studentService.saveStudent(student);

		// return "saved successfully...";
		return "redirect:/showAllStudents";
	}

	@GetMapping(value = "/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model) {
		System.out.println("Gettig id is ...." + id);

		Student student = studentService.getStudent(id);
		System.out.println("Getting the student object ....." + student);
		model.addAttribute("student", student);

		return "add-student";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id, Model model) {

		studentService.deleteStudent(id);
//		List<Student> studentList = studentService.getAllStudents();
//		System.out.println("Calling Service method...");
//		for (Student student : studentList) {
//			System.out.println(student);
//		}
//
//		model.addAttribute("students", studentList);
//		return "students-list";
//
		return "redirect:/showAllStudents";
	}
}
