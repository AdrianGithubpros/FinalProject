package com.example.lastproject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RecordDto {

    private Long id;

    private int value;

    private LocalDateTime date;

    private RecordStatus recordStatus;

    private RecordType recordType;

    private Long senderID;

    private Long recipientId;
}
