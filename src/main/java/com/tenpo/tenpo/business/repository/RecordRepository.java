package com.tenpo.tenpo.business.repository;

import com.tenpo.tenpo.business.model.Record;
import com.tenpo.tenpo.business.record.RqType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    Page<Record> findByRequestType(RqType rqType, Pageable pageable);

}
