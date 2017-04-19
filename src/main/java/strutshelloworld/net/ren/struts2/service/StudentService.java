package strutshelloworld.net.ren.struts2.service;

import java.util.List;

import strutshelloworld.net.ren.struts2.domain.Student;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentService.
 */
public interface StudentService {

	/**
	 * Adds the student.
	 *
	 * @param student
	 *            the student
	 */
	public void addStudent(Student student);

	/**
	 * Delete student by id.
	 *
	 * @param id
	 *            the id
	 */
	public void deleteStudentById(int id);

	/**
	 * Find student by id.
	 *
	 * @param id
	 *            the id
	 * @return the student
	 */
	public Student findStudentById(int id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Student> findAll();
}
