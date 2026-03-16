package com.yas.commonlibrary.utils;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTimeUtilsTest {

    @Test
    void testFormat_withDefaultPattern() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 10, 15, 14, 30, 45);
        String expected = "15-10-2023_14-30-45";
        String actual = DateTimeUtils.format(dateTime);
        assertEquals(expected, actual);
    }

    @Test
    void testFormat_withCustomPattern() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 10, 15, 14, 30, 45);
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2023-10-15 14:30:45";
        String actual = DateTimeUtils.format(dateTime, pattern);
        assertEquals(expected, actual);
    }
}