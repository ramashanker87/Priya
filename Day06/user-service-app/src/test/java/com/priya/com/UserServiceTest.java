package com.priya.com;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.verification.VerificationMode;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDetails userdetails;

    @InjectMocks
    UserService userService;
    private java.lang.Exception Exception;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test

    public void testGetUserById() {
        // Arrange
        User user = new User();
        user.setId(1);
        user.setName("John Doe");
        when(userdetails.findById(1)).thenReturn(Optional.of(user));

        User output = userService.getUserById(1);

        assertNotNull(output);
        assertEquals("John Doe", output.getName());
        verify(userService, times(1)).findById(1);

    }

    private UserDetails verify(UserService userService, VerificationMode times) {
        verify(userService, times(1)).findById(1);

        return null;
    }



    @Test
    public void testGetUserDetails_UserNotFound() {

        when(userdetails.findById(2)).thenReturn(Optional.empty());
        Exception exception = assertThrows(userdetails.findById(2));
        assertEquals("notfound", exception.getMessage());


    }

    private Exception assertThrows(Optional<User> findbyId) {
        Exception exception = assertThrows(userdetails.findById(2));
        return Exception;
    }
}