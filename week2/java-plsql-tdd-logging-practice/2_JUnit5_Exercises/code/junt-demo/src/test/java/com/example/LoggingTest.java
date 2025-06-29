package com.example;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    @Test
    void testLoggingLevels() {
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }
}
