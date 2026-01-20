package com.idrive.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="STUDENT")
@SecondaryTable(name="accounts")
public class Student {


	@NotBlank
	@Size(min=3, max=10, message="Student hobby can not be empty and should be of length between {min} and {max}")
    private String studentHobby;

    @NotBlank
    @Size(min=3, max=10, message="Student name can not be empty and should be of length between {min} and {max}")
    private String studentName;

    @NotNull
    private long mobileNumber;

	@NotNull
	private Date dob;

	//@IsValidDate
	private Date doj;

	@NotEmpty
	private List<String> skills;
	private Address stdAddress;


	private Blob photo;


	private MultipartFile stdPic;

	@Email(message="Not a well formed email address")
	@NotBlank
	private String email;


	private String password;

	private List<String> authorities = new ArrayList<>();

	private List<Course> courses= new ArrayList<>();




    @Transient
	public MultipartFile getStdPic() {
		return stdPic;
	}
	public void setStdPic(MultipartFile stdPic) {
		this.stdPic = stdPic;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	@Column(name="birth_date")
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    //@Temporal(TemporalType.TIME)//without this, date will be stored as time stamp in db
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}


    @ElementCollection // this is equal to @one-to-many for primitive types
    //@JoinColumn==> to specify the foreign key name
    @CollectionTable(name="skills", joinColumns = @JoinColumn(name="student_email"))
    @Column(name="skill_name")
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Address getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(Address stdAddress) {
		this.stdAddress = stdAddress;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

	@Column(name="phone")
	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


    @Column(name="join_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}

    @Lob
    @Column(name="photo")
    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }


    @Column(table = "accounts")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
		System.out.println("Setting password #######################:");
        this.password = password;
    }


    @ElementCollection
    @CollectionTable(name="authorities", joinColumns = @JoinColumn(name="student_email")) //Specifying the foreign key column using @JoinColumn
    @Column(name="roles")
    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @ManyToMany( mappedBy = "students", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Id
    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	@Override
	public String toString() {
		return "Student{" +
				"studentHobby='" + studentHobby + '\'' +
				", studentName='" + studentName + '\'' +
				", mobileNumber=" + mobileNumber +
				", dob=" + dob +
				", doj=" + doj +
				", skills=" + skills +
				", stdAddress=" + stdAddress +
				", photo=" + photo +
				", stdPic=" + stdPic +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", authorities=" + authorities +
				", courses=" + courses +
				'}';
	}
}
