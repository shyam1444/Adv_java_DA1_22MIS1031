package net.javaguides.sms.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "complaints")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "registration_number", nullable = false)
	private String registrationNumber;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "department")
	private String department;

	@Column(name = "hostel_info")
	private String hostelInfo;

	private String category;

	@Column(name = "description", length = 1000)
	private String description;

	    @Column(name = "date")
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	    private LocalDateTime date;

	@Column(name = "status")
	private String status;

	public Student() {
	}

	public Student(String registrationNumber, String name, String department, String hostelInfo, String category, String description, LocalDateTime date, String status) {
		super();
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.hostelInfo = hostelInfo;
		this.category = category;
		this.description = description;
		this.date = date;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHostelInfo() {
		return hostelInfo;
	}
	public void setHostelInfo(String hostelInfo) {
		this.hostelInfo = hostelInfo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

