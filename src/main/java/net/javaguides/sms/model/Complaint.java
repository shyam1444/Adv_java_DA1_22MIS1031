package net.javaguides.sms.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Complaint {
    private Long id;
    private String registrationNumber;
    private String name;
    private String department;
    private String hostelInfo;
    private String category;
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    private String status;

    public Complaint() {
    }

    public Complaint(Long id, String registrationNumber, String name, String department, String hostelInfo,
                     String category, String description, LocalDateTime date, String status) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.department = department;
        this.hostelInfo = hostelInfo;
        this.category = category;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getHostelInfo() { return hostelInfo; }
    public void setHostelInfo(String hostelInfo) { this.hostelInfo = hostelInfo; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
