package com.demo.manju.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.manju.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	//Featch all students in the table
	@RequestMapping(value="/StudentInfo", produces= { "application/json"})
	public Map<String, Object> StudentInfo()
	{
		
		
		
		Map<String, Object> returnData=new HashMap<String,Object>();
		
		returnData.put("StudentInfo", studentService.getStudentInfo());
		
		
		return returnData;
	}
	
	
	//Featch  perticular student in the table
	@RequestMapping(value="/OneStudentInfo", method = RequestMethod.POST, produces = { "application/json" })
	public Map<String, Object> OneStudentInfo(@RequestBody Map<String, String> resourceJson) {
	{
		
		Map<String, Object> returnData=new HashMap<String,Object>();
		Map<String,String> addStd = new HashMap<String,String>();

		int id =Integer.parseInt(resourceJson.get("id"));
		returnData.put("StudentInfo", studentService.getOneStudentInfo(id));
		
		
		return returnData;
	}
	
	}
	
	
	// Add new student to table
	@RequestMapping(value="/addStudent", method = RequestMethod.POST, produces = { "application/json" })
	public Map<String, String> updateStudent(@RequestBody Map<String, String> resourceJson) {

		Map<String,String> addStd = new HashMap<String,String>();
				
				
		int id =Integer.parseInt(resourceJson.get("id"));
		String firstName = resourceJson.get("firstName");
		String lastName = resourceJson.get("lastName");
		String collage = resourceJson.get("collage");
		String branch = resourceJson.get("branch");
		String city = resourceJson.get("city");
		
			
		studentService.addStudent(id, firstName, lastName, collage, branch, city);
		
		addStd.put("adding Data", "StudentInformationAdded");
		return addStd;
		
	}
	
	
	// Update existing student in the table
	@RequestMapping(value="/updateStudent", method = RequestMethod.POST, produces = { "application/json" })
	public Map<String, String> addResource(@RequestBody Map<String, String> resourceJson) {

Map<String,String> updateStd = new HashMap<String,String>();

		
				int id =Integer.parseInt(resourceJson.get("id"));
				String firstName = resourceJson.get("firstName");
				String lastName = resourceJson.get("lastName");
				String collage = resourceJson.get("collage");
				String branch = resourceJson.get("branch");
				String city = resourceJson.get("city");
		
		
	
				studentService.updateStudent(id, firstName, lastName, collage, branch, city);
		
				updateStd.put("Updating Data", "StudentInformationUpdated");
				return updateStd;

}
	
	
	// delete existing student in table
	@RequestMapping(value="deleteStudent", method = RequestMethod.POST, produces = { "application/json" })
	public Map<String, String> deleteStudent(@RequestBody Map<String, String> resourceJson) {

		Map<String,String> deleteStd = new HashMap<String,String>();
		
	
		
		
		int id =Integer.parseInt(resourceJson.get("id"));
	
		studentService.deleteStudent(id);
		
		deleteStd.put("deleteing Data","StudentInformation Deleted");
		return deleteStd;
		
	}
	
	
	
	
	}
