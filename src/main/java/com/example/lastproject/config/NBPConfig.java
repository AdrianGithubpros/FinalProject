package com.example.lastproject.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class NBPConfig {


    @Value("${api.nbp.pl/api}")
    private String nbpApiEndpoint;
}
