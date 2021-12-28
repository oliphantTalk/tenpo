package com.tenpo.tenpo.business.record;

import com.tenpo.tenpo.business.model.Record;
import com.tenpo.tenpo.business.record.dto.RecordDTO;
import com.tenpo.tenpo.business.repository.RecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecordService implements IRecordService {

    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Async
    @Override
    public void recordTracking(Record record) {
        log.info("Saving record: {}", record);
        recordRepository.save(record);
    }

    public PaginationResponse<TrackingRecorder> getAllRecordTracking(HistoryRequest historyRequest) {
        Pageable pageable = PageRequest.of(historyRequest.getPage(), historyRequest.getPageSize());
        Page<TrackingRecorder> page;
        if (historyRequest.getRequestType() != null) {
            page = trackingRecorderRepository.findByRequestType(historyRequest.getRequestType(), pageable);
        } else {
            page = trackingRecorderRepository.findAll(pageable);
        }
        return new PaginationResponse<TrackingRecorder>(page.getContent(), page.getTotalPages(), page.getPageable().getPageNumber(), (int) page.getTotalElements());
    }


    @Override
    public void save(Record record) {

    }

    @Override
    public Page<RecordDTO> findAll(RqType rqType, int pageSize, int pageNumber) {
        return null;
    }
}
