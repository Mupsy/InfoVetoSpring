package com.infoveto.classic.api.Scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutomateLogger {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "10 * * * * *")
    public void automateLogger() {
        LOGGER.info("Automate logger started");
    }
}
