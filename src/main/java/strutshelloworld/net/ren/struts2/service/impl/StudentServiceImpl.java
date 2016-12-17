package strutshelloworld.net.ren.struts2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import strutshelloworld.net.ren.struts2.domain.Student;
import strutshelloworld.net.ren.struts2.service.StudentService;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentServiceImpl.
 */
public class StudentServiceImpl implements StudentService {
    
    /** The students. */
    private static List<Student> students = new ArrayList<Student>();
    
    /** The current student. */
    private Student currentStudent;
    
    /*
     * (non-Javadoc)
     * @see strutshelloworld.net.ren.struts2.service.StudentService#addStudent(
     * strutshelloworld.net.ren.struts2.domain.Student)
     */
    @Override
    public void addStudent(Student student) {
	students.add(student);
    }
    
    /*
     * (non-Javadoc)
     * @see
     * strutshelloworld.net.ren.struts2.service.StudentService#deleteStudentById
     * (int)
     */
    @Override
    public void deleteStudentById(int id) {
	for (ListIterator<Student> iterator = students.listIterator(); iterator.hasNext();) {
	    currentStudent = iterator.next();
	    if (currentStudent.getId() == id) {
		students.remove(currentStudent);
	    }
	}
    }
    
    /*
     * (non-Javadoc)
     * @see
     * strutshelloworld.net.ren.struts2.service.StudentService#findStudentById(
     * int)
     */
    @Override
    public Student findStudentById(int id) {
	for (ListIterator<Student> iterator = students.listIterator(); iterator.hasNext();) {
	    currentStudent = iterator.next();
	    if (currentStudent.getId() == id) {
		break;
	    }
	}
	return currentStudent;
    }
    
    /*
     * (non-Javadoc)
     * @see strutshelloworld.net.ren.struts2.service.StudentService#findAll()
     */
    @Override
    public List<Student> findAll() {
	return students;
    }
    
}
