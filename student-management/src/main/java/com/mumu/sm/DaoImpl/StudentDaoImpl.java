package com.mumu.sm.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mumu.sm.DAO.StudentDAO;
import com.mumu.sm.api.Student;
import com.mumu.sm.rowMapper.StudentRowMapper;

@Repository
public class StudentDaoImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> getAllStudents() {
		// Getting students data from Db

		String sql = "SELECT * FROM students";

		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());

		return studentList;
	}

	@Override
	public void saveStudent(Student student) {

		String sql = "insert into students(name,phone,address) values (?, ?, ?)";

		Object[] sqlParameters = { student.getName(), student.getPhone(), student.getAddress() };

		jdbcTemplate.update(sql, sqlParameters);

		System.out.println("1 record inserted....");

	}

	@Override
	public Student getStudent(int id) {

		String sql = "SELECT * FROM students where id = ?";

		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);

		return student;
	}

	@Override
	public void updateStudent(Student student) {

		String sql = "UPDATE STUDENTS SET NAME=?, PHONE=?, ADDRESS=? WHERE ID=?";
		jdbcTemplate.update(sql, student.getName(), student.getPhone(), student.getAddress(), student.getId());
		System.out.println("1 record updated");
	}

	@Override
	public void deleteStudent(int id) {
		String sql = "DELETE FROM STUDENTS WHERE ID =?";
		jdbcTemplate.update(sql, id);
		System.out.println("1 record deleted....");
	}

}
