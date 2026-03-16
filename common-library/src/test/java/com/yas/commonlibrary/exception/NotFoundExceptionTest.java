package com.yas.commonlibrary.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NotFoundExceptionTest {

    @Test
    void testConstructor_withMessageAndParams() {
        NotFoundException exception = new NotFoundException("PRODUCT_NOT_FOUND", "123");
        assertEquals("The product 123 is not found", exception.getMessage());
    }
}