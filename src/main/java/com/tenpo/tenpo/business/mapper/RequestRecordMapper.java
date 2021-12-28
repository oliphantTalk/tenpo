package com.tenpo.tenpo.business.mapper;

import com.tenpo.tenpo.business.model.Record;
import com.tenpo.tenpo.business.record.dto.RecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestRecordMapper {

    RequestRecordMapper INSTANCE = Mappers.getMapper(RequestRecordMapper.class);

    RecordDTO modelToDto(Record user);

    Record dtoToModel(RecordDTO userDTO);

}
