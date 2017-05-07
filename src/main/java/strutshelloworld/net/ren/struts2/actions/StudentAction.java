package strutshelloworld.net.ren.struts2.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import strutshelloworld.net.ren.struts2.domain.Student;
import strutshelloworld.net.ren.struts2.service.StudentService;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentAction.
 */
public class StudentAction extends ActionSupport implements ModelDriven, Preparable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3064301885095539523L;

	/** The student service. */
	@Autowired
	private StudentService studentService;

	/** The list student. */
	private List<Student> listStudent = new ArrayList<Student>();

	/** The student. */
	private Student student = new Student();
	
	/** The request. */
	private HttpServletRequest request;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	public Object getModel() {
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() throws Exception {
		
	}

	/*
	 * (non-Javadoc)
	 * 
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
	 * Update student.
	 *
	 * @return the string
	 */
	public String updateStudent() {
		studentService.addStudent(student);
		return SUCCESS;
	}

	/**
	 * Delete student.
	 *
	 * @return the string
	 */
	public String deleteStudent() {
        request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		studentService.deleteStudentById((Integer.parseInt(request. getParameter("id"))));
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
	 * Update student.
	 *
	 * @return the string
	 */
	public String getStudentById(){
		request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		student = studentService.findStudentById(Integer.parseInt(request. getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * Delete all.
	 *
	 * @return the string
	 */
	public String deleteAll(){
		studentService.deleteAll();
		return SUCCESS;
	}
	
	/**
	 * Gets the list student.
	 *
	 * @return the list student
	 */
	public List<Student> getListStudent() {
		return listStudent;
	}

}