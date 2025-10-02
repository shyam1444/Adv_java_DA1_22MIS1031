package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.model.Complaint;

public interface ComplaintService {
    List<Complaint> getAll();
    Complaint save(Complaint complaint);
    Complaint getById(Long id);
    Complaint update(Complaint complaint);
    void deleteById(Long id);
}  
