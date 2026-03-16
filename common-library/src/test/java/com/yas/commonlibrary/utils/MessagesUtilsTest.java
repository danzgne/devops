package com.yas.commonlibrary.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MessagesUtilsTest {

    @Test
    void testGetMessage_withExistingKey() {
        String message = MessagesUtils.getMessage("USER_NOT_FOUND");
        assertEquals("User not found", message);
    }

    @Test
    void testGetMessage_withParameters() {
        String message = MessagesUtils.getMessage("PRODUCT_NOT_FOUND", "123");
        assertEquals("The product 123 is not found", message);
    }

    @Test
    void testGetMessage_withNonExistingKey() {
        String message = MessagesUtils.getMessage("NON_EXISTING_KEY");
        assertEquals("NON_EXISTING_KEY", message);
    }
}