package com.yas.commonlibrary.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BadRequestExceptionTest {

    @Test
    void testConstructor_withMessage() {
        BadRequestException exception = new BadRequestException("USER_NOT_FOUND");
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void testConstructor_withMessageAndParams() {
        BadRequestException exception = new BadRequestException("PRODUCT_NOT_FOUND", "123");
        assertEquals("The product 123 is not found", exception.getMessage());
    }
}