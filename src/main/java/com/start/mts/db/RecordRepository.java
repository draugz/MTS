package com.start.mts.db;

import com.start.mts.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    List<Record> findAll();
    List<Record> findByTicketNumber(String ticketNumber);
    List<Record> findByUserName(String userName);
    List<Record> findByObjectType(String objectType);
    List<Record> findByObjectName(String objectName);
}
