package strutshelloworld.net.ren.struts2.service;

import java.util.List;

import strutshelloworld.net.ren.struts2.domain.Student;

public interface StudentService {
    public void addStudent(Student student);
    public void deleteStudentById(int id);
    public Student findStudentById(int id);
    public List<Student> findAll();
}
