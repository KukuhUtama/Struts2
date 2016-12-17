package strutshelloworld.net.ren.struts2.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import strutshelloworld.net.ren.struts2.domain.Student;
import strutshelloworld.net.ren.struts2.service.StudentService;
import strutshelloworld.net.ren.struts2.service.impl.StudentServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentAction.
 */
public class StudentAction extends ActionSupport implements ModelDriven, Preparable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3064301885095539523L;
    
    /** The student service. */
    private StudentService studentService;
    
    /** The list student. */
    private List<Student> listStudent = new ArrayList<Student>();
    
    /** The student. */
    private Student student = new Student();
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    @Override
    public Object getModel() {
	return student;
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.Preparable#prepare()
     */
    @Override
    public void prepare() throws Exception {
	 studentService = new StudentServiceImpl();
    }
    
    /* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {
	
	return SUCCESS;
    }
    
    /**
     * Adds the student.
     *
     * @return the string
     */
    public String addStudent() {
	studentService.addStudent(student);
	return SUCCESS;
    }
    
    /**
     * Delete student.
     *
     * @return the string
     */
    public String deleteStudent() {
	studentService.addStudent(student);
	return SUCCESS;
    }
    
    /**
     * Gets the all student.
     *
     * @return the all student
     */
    public String getAllStudent() {
	listStudent = studentService.findAll();
	return SUCCESS;
    }
    
    /**
     * Gets the list student.
     *
     * @return the list student
     */
    public List<Student> getListStudent(){
	return listStudent;
    }
    
}
