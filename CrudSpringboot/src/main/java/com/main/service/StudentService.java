package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.StudentDao;
import com.main.dto.StudentRequest;
import com.main.dto.StudentResponse;
import com.main.translator.StudentTranslator;

@Service
public class StudentService {
	
	
	@Autowired
	private StudentTranslator translator;
	
	
	@Autowired
	private StudentDao dao;
	
	//fetch
	public List<StudentResponse> fetchstudent(){
		return translator.response(dao.find());
	}
	
	//fetch by id
	public StudentResponse fetchby(Long id) {
		return translator.response(dao.findby(id));
	}
	
	//add
	public Long adduser(StudentRequest stu) {
		return dao.add(translator.reqStudent(stu));
	}
	
	//update
	public String updatereq(StudentRequest stu,Long id) {
		return dao.update(translator.reqStudent(stu), id);
	}
	
	//delete
	public void deleteuser() {
		dao.delete();
	}
	
	//delete by id
	public Long deleteuser(Long id) {
		return dao.deleteby(id);
	}
}
