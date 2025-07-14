package com.example.helloworld;

import com.example.helloworld.HelloController;
import com.example.helloworld.data.Greeting;
import com.example.helloworld.services.IGreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    @Mock
    private IGreetingService greetingService;

    @InjectMocks
    private HelloController helloController;

    @Test
    void testHelloWorld_ReturnsCorrectGreeting() {
        // Arrange
        Greeting expectedGreeting = new Greeting("English", "Hello, World!");
        when(greetingService.Greet()).thenReturn(expectedGreeting);

        // Act
        Greeting actualGreeting = helloController.HelloWorld();

        // Assert
        assertEquals(expectedGreeting.language(), actualGreeting.language());
        assertEquals(expectedGreeting.message(), actualGreeting.message());
    }

    @Test
    void testHelloWorld_DifferentLanguage() {
        // Arrange
        Greeting expectedGreeting = new Greeting("Spanish", "¡Hola, Mundo!");
        when(greetingService.Greet()).thenReturn(expectedGreeting);

        // Act
        Greeting actualGreeting = helloController.HelloWorld();

        // Assert
        assertEquals("Spanish", actualGreeting.language());
        assertEquals("¡Hola, Mundo!", actualGreeting.message());
    }
}