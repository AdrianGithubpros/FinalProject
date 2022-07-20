package com.example.lastproject.service;

import com.example.lastproject.domain.PaymentDto;
import com.example.lastproject.domain.Record;
import com.example.lastproject.exception.RecordNotFoundException;
import com.example.lastproject.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordDbService {
    private final RecordRepository recordRepository;

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public Record getRecordById(Long id) throws RecordNotFoundException {
        return recordRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public void cancelRecordById(Long id) throws RecordNotFoundException {
        Record record = recordRepository.findById(id).orElseThrow(RecordNotFoundException::new);
        recordRepository.deleteById(id);
        recordRepository.save(record);
    }


    public Record saveRecord(final Record record) {
        return recordRepository.save(record);
    }

    public void deleteById(Long id) {
        recordRepository.deleteById(id);
    }

    public void createPayment(PaymentDto paymentDto){



    }



}
