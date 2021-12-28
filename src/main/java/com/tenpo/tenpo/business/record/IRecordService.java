package com.tenpo.tenpo.business.record;

import com.tenpo.tenpo.business.model.Record;
import com.tenpo.tenpo.business.record.dto.RecordDTO;
import org.springframework.data.domain.Page;

public interface IRecordService {

    void save(Record record);

    Page<RecordDTO> findAll(RqType rqType, int pageSize, int pageNumber);

}
