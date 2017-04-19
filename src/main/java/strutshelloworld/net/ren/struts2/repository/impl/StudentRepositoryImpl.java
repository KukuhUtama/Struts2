package strutshelloworld.net.ren.struts2.repository.impl;

import org.springframework.stereotype.Repository;

import strutshelloworld.net.ren.struts2.domain.Student;
import strutshelloworld.net.ren.struts2.repository.AbstractBaseRepository;
import strutshelloworld.net.ren.struts2.repository.StudentRepository;

/**
 * The Class StudentRepositoryImpl.
 */
@Repository("studentRepository")
public class StudentRepositoryImpl extends AbstractBaseRepository<Student> implements StudentRepository {

}
