package net.javaguides.sms.service.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.sms.model.Complaint;
import net.javaguides.sms.service.ComplaintService;
import net.javaguides.sms.store.ComplaintStore;

@Service
public class InMemoryComplaintService implements ComplaintService {

    private final ComplaintStore store;

    public InMemoryComplaintService(ComplaintStore store) {
        this.store = store;
    }

    @Override
    public List<Complaint> getAll() {
        return store.getComplaints().stream()
                .sorted(Comparator.comparing(Complaint::getDate, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Complaint save(Complaint complaint) {
        if (complaint.getId() == null) {
            complaint.setId(store.nextId());
        }
        if (complaint.getDate() == null) {
            complaint.setDate(LocalDateTime.now());
        }
        if (complaint.getStatus() == null || complaint.getStatus().isBlank()) {
            complaint.setStatus("Pending");
        }
        store.getComplaints().add(complaint);
        return complaint;
    }

    @Override
    public Complaint getById(Long id) {
        if (id == null) return null;
        Optional<Complaint> found = store.getComplaints().stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findFirst();
        return found.orElse(null);
    }

    @Override
    public Complaint update(Complaint complaint) {
        if (complaint == null || complaint.getId() == null) return null;
        deleteById(complaint.getId());
        store.getComplaints().add(complaint);
        return complaint;
    }

    @Override
    public void deleteById(Long id) {
        store.getComplaints().removeIf(c -> Objects.equals(c.getId(), id));
    }
}
