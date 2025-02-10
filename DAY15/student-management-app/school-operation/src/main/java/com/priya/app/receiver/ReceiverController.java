package com.priya.app.receiver;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/school")
public class ReceiverController {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ReceiverController.class);
    @GetMapping("/read")
    public String getDetail() throws InterruptedException {
        LOGGER.info("Receiver get request:");
        return "Receiver get reponse";
    }
        @PostMapping("/save")
        public String saveDetail() throws InterruptedException {
            LOGGER.info("Receiver save request:");
            return "Receiver post reponse";
        }

    @PutMapping ("/update")
    public String updatetDetail() throws InterruptedException {
        LOGGER.info("Receiver update request:");

        return "Receiver put reponse";
    }

    @DeleteMapping("/delete")
    public String deleteDetail() throws InterruptedException {
        LOGGER.info("Receiver delete request:");

        return "Receiver delete reponse";



}}
