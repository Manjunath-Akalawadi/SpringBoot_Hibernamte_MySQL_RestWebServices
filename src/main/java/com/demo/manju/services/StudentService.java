package com.demo.manju.services;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.manju.repository.StudentRepo;
import com.demo.manju.util.StudentUtil;


@Service
public class StudentService {
	
	
	@Autowired
	StudentRepo studentRepository;
	
	@Autowired
	StudentUtil studentUtil;
	
	
	//Featch all students in the table
	public List<Map<String, Object>> getStudentInfo()
	{
		
		
		List<Object[]> StudentInfo=null;
		
		StudentInfo=studentRepository.getStudentInfo();
		

		String[] keys= {"id" , "firstName", "lastName" , "collage", "branch", "city" };
		
				
		return studentUtil.generateKeyValueObjects(StudentInfo, keys);
		
		
	}
	
	
	//Featch  perticular student in the table
	public List<Map<String, Object>> getOneStudentInfo(int id)
	{
		
		
		List<Object[]> OneStudentInfo=null;
		
		OneStudentInfo=studentRepository.getOneStudentInfo(id);
		

		String[] keys= {"id" , "firstName", "lastName" , "collage", "branch", "city" };
		
				
		return studentUtil.generateKeyValueObjects(OneStudentInfo, keys);
		
		
	}
	
	
	// Add new student to table
	@Transactional
	public void addStudent(int id, String firstName, String lastName, String collage, String branch, String city) {
		
		try {
			
			
				
			studentRepository.addStudent(id, firstName, lastName, collage, branch, city);
			
			
		} catch (Exception e) {

			System.out.println("Exception");
		}
		
	}
	
	
	// Update existing student in the table
	@Transactional
	public void updateStudent(int id, String firstName, String lastName, String collage, String branch, String city) {
		
		try {
			
			studentRepository.updateStudent(id, firstName, lastName, collage, branch, city);
			
		} catch (Exception e) {
			System.out.println("Exception");
		}
		
	}
	
	
	// delete existing student in table
	@Transactional
	public void deleteStudent(int id) {
		
		try {
			
			studentRepository.deleteStudent(id);
			
		} catch (Exception e) {
			
			System.out.println("Exception");
			
		}
		
	}
	

}
