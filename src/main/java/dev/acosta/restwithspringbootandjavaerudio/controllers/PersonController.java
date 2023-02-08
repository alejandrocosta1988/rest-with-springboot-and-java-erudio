package dev.acosta.restwithspringbootandjavaerudio.controllers;

import dev.acosta.restwithspringbootandjavaerudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonServices service;

    

}
