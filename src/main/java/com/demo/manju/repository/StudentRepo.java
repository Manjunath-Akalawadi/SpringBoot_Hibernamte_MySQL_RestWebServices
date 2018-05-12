package com.demo.manju.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.manju.module.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
	
	
	//Featch all students in the table
	@Query(value="select * from demo.student",nativeQuery=true)
	public List<Object[]> getStudentInfo();
	
	
	//Featch  perticular student in the table
	@Query(value="select * from demo.student WHERE id = ?1",nativeQuery=true)
	public List<Object[]> getOneStudentInfo(int id);
	
	
	// Add new student to table
	@Modifying
	@Query(value = "INSERT into demo.student (id, firstName, lastName, collage,branch,city) values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
	int addStudent(int id, String firstName, String lastName, String collage, String branch, String city);
	
	
	// Update existing student in the table
	@Modifying
	@Query(value = "UPDATE demo.student SET firstName = ?2,lastName = ?3, collage = ?4 , branch=?5 , city=?6 WHERE id = ?1", nativeQuery = true)
	int updateStudent(int id, String firstName, String lastName, String collage, String branch, String city);
	
	
	// delete existing student in table
	@Modifying
	@Query(value = "DELETE FROM demo.student WHERE id=?;", nativeQuery = true)
	int deleteStudent(int id);
}
