package com.example.springbootsleuthdestination;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
@Slf4j
public class DestinationRestController {

    @GetMapping("/destination")
    public String destination(RequestEntity request){
        log.info("DESTINATION - BEGIN");
        HttpHeaders headers = request.getHeaders();
        headers.entrySet().forEach((e) ->{
            log.info("k {} v {}", e.getKey(), e.getValue());
        });
        if (Math.abs(new Random().nextInt())%3 == 0)
            log.warn("Something weird happened - The info cant be trusted");
        log.info("DESTINATION - END");
        return "Mars";
    }
}
