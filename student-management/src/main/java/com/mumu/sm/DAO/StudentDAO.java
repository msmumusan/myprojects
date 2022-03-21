package com.mumu.sm.DAO;

import java.util.List;

import com.mumu.sm.api.Student;

public interface StudentDAO {
	List<Student> getAllStudents();

	void saveStudent(Student student);

	Student getStudent(int id);
	
	void updateStudent(Student student);

	void deleteStudent(int id);
}
