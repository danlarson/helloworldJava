package com.example.helloworld.services;

import com.example.helloworld.data.Greeting;
import org.springframework.stereotype.Service;

@Service
class GreetingService implements IGreetingService {

    public Greeting Greet() {
        return new Greeting("fr-ca", "Bonjour Hi!");
    }
}
