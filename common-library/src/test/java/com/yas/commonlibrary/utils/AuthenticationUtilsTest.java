package com.yas.commonlibrary.utils;

import com.yas.commonlibrary.exception.AccessDeniedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthenticationUtilsTest {

    @BeforeEach
    void setUp() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void testExtractUserId_withValidJwt() {
        Jwt jwt = mock(Jwt.class);
        when(jwt.getSubject()).thenReturn("user123");

        Authentication authentication = new JwtAuthenticationToken(jwt, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String userId = AuthenticationUtils.extractUserId();
        assertEquals("user123", userId);
    }

    @Test
    void testExtractUserId_withAnonymous() {
        Authentication authentication = new AnonymousAuthenticationToken("key", "principal", null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        assertThrows(AccessDeniedException.class, AuthenticationUtils::extractUserId);
    }

    @Test
    void testExtractJwt() {
        Jwt jwt = mock(Jwt.class);
        when(jwt.getTokenValue()).thenReturn("tokenValue");

        Authentication authentication = new JwtAuthenticationToken(jwt, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = AuthenticationUtils.extractJwt();
        assertEquals("tokenValue", token);
    }
}