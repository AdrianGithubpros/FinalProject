package com.example.lastproject.NBP.client;

import com.example.lastproject.config.NBPConfig;
import com.example.lastproject.domain.GoldDto;
import com.example.lastproject.exception.GoldNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



import java.util.Optional;


@Component
@RequiredArgsConstructor
public class NBPClient {
    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(NBPClient.class);
    private final NBPConfig nbpConfig;

    public GoldDto getGoldCost() throws GoldNotFoundException {

        try {
            GoldDto goldDto = restTemplate.getForObject(nbpConfig.getNbpApiEndpoint() + "/cenyzlota",GoldDto.class);
            return Optional.ofNullable(goldDto).orElseThrow(GoldNotFoundException::new);

        } catch (
                RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new GoldDto();
        }
    }


}
