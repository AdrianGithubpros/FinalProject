package com.example.lastproject.controller;


import com.example.lastproject.domain.PaymentDto;
import com.example.lastproject.domain.Record;
import com.example.lastproject.domain.RecordDto;
import com.example.lastproject.exception.RecordNotFoundException;
import com.example.lastproject.mapper.RecordMapper;
import com.example.lastproject.service.RecordDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/Record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordDbService recordDbService;
    private final RecordMapper recordMapper;


    @GetMapping
    public ResponseEntity<List<RecordDto>> getRecords() {
        List<Record> records = recordDbService.getAllRecords();
        return ResponseEntity.ok(recordMapper.mapToRecordDtoList(records));
    }

    @GetMapping(value = "{recordId}")
    public ResponseEntity<RecordDto> getRecord(@PathVariable Long recordId) throws RecordNotFoundException {
        return ResponseEntity.ok(recordMapper.mapToRecordDto(recordDbService.getRecordById(recordId)));
    }

    @DeleteMapping(value = "{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
        recordDbService.deleteById(recordId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RecordDto> updateRecord(@RequestBody RecordDto recordDto) {
        Record record = recordMapper.mapToRecord(recordDto);
        Record recordSaved = recordDbService.saveRecord(record);
        return ResponseEntity.ok(recordMapper.mapToRecordDto(recordSaved));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRecord(@RequestBody RecordDto recordDto) {
        Record  record = recordMapper.mapToRecord(recordDto);
        recordDbService.saveRecord(record);
        return ResponseEntity.ok().build();
    }


}
