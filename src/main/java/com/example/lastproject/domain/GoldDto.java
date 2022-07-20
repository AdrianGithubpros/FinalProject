package com.example.lastproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoldDto {
    @JsonProperty("data")
    private LocalDate data;

    @JsonProperty("cena")
    private double cena;
}
