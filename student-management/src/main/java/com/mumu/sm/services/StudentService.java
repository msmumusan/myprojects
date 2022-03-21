package com.mumu.sm.services;

import java.util.List;

import com.mumu.sm.api.Student;

public interface StudentService {

	List<Student> getAllStudents();

	void saveStudent(Student student);

	Student getStudent(int id);

	void updateStudent(Student student);

	void deleteStudent(int id);
}
