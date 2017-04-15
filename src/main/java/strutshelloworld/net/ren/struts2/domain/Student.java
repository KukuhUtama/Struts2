package strutshelloworld.net.ren.struts2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
@Entity
@Table(name="student")
public class Student {
    
    /** The id. */
	@Id
	@GeneratedValue
	@Column(name="id")
    private int id;
    
    /** The first name. */
	@Column(name="first_name")
    private String firstName;
    
    /** The last name. */
	@Column(name="last_name")
    private String lastName;
    
    /**
     * Instantiates a new student.
     */
    public Student() {
	
    }
    
    /**
     * Instantiates a new student.
     *
     * @param id the id
     * @param firstName the first name
     * @param lastName the last name
     */
    public Student(int id, String firstName, String lastName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
    }
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
	return id;
    }
    
    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
	this.id = id;
    }
    
    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
	return firstName;
    }
    
    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }
    
    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
	return lastName;
    }
    
    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }
    
}
