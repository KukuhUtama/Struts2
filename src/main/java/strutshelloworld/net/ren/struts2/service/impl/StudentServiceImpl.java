package strutshelloworld.net.ren.struts2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import strutshelloworld.net.ren.struts2.domain.Student;
import strutshelloworld.net.ren.struts2.repository.StudentRepository;
import strutshelloworld.net.ren.struts2.service.StudentService;

/**
 * The Class StudentServiceImpl.
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see strutshelloworld.net.ren.struts2.service.StudentService#addStudent(
	 * strutshelloworld.net.ren.struts2.domain.Student)
	 */
	public void addStudent(Student student) {
		studentRepository.add(student);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * strutshelloworld.net.ren.struts2.service.StudentService#deleteStudentById
	 * (int)
	 */
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * strutshelloworld.net.ren.struts2.service.StudentService#findStudentById(
	 * int)
	 */
	public Student findStudentById(int id) {
		return studentRepository.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strutshelloworld.net.ren.struts2.service.StudentService#findAll()
	 */
	public List<Student> findAll() {
		return studentRepository.getAll();
	}
}
