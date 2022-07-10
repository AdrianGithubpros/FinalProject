package com.example.lastproject.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "RECORDS")
public class Record {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Record_Id")
    private Long id;

    @NotNull
    @Column(name = "Value")
    private int value;

    @NotNull
    @Column(name = "Date")
    private LocalDateTime date;

    @NotNull
    @Column(name = "Record_Status")
    private RecordStatus recordStatus;

    @NotNull
    @Column(name = "Record_Type")
    private RecordType recordType;

    @NotNull
    @Column(name = "From")
    private Long senderID;

    @NotNull
    @Column(name = "To")
    private Long recipientId;

}
