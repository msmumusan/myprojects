package com.mumu.sm.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mumu.sm.DAO.StudentDAO;
import com.mumu.sm.api.Student;
import com.mumu.sm.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = studentDAO.getAllStudents();
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {

		if (student.getAddress().equals("Thuwunna")) {
			System.out.println("Email sent to " + student.getName());
		}

		studentDAO.saveStudent(student);

	}

	@Override
	public Student getStudent(int id) {
		Student student = studentDAO.getStudent(id);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
		
	}

}
