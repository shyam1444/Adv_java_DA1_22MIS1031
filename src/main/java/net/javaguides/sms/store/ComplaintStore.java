package net.javaguides.sms.store;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import net.javaguides.sms.model.Complaint;

@Component
public class ComplaintStore {
    private final List<Complaint> complaints = new CopyOnWriteArrayList<>();
    private final AtomicLong idSeq = new AtomicLong(1);

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public long nextId() {
        return idSeq.getAndIncrement();
    }
}
