package com.example.lastproject.mapper;


import com.example.lastproject.domain.Record;
import com.example.lastproject.domain.RecordDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordMapper {

    public Record mapToRecord(final RecordDto recordDto){
        return new Record(
                recordDto.getId(),
                recordDto.getValue(),
                recordDto.getDate(),
                recordDto.getRecordStatus(),
                recordDto.getRecordType(),
                recordDto.getSenderID(),
                recordDto.getRecipientId());
    }
    public RecordDto mapToRecordDto(final Record record){
        return new RecordDto(
                record.getId(),
                record.getValue(),
                record.getDate(),
                record.getRecordStatus(),
                record.getRecordType(),
                record.getSenderID(),
                record.getRecipientId());
    }

    public List<RecordDto> mapToRecordDtoList(final List<Record> recordList) {
        return recordList.stream()
                .map(this::mapToRecordDto)
                .collect(Collectors.toList());
    }


}
