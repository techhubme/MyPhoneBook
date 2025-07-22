package com.phonebook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The rest controller class for PhoneBook
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
@RestController
public class PhoneBookController {

    @GetMapping("/hello")
    public String test(){
        log.info("Handling test API call");
        return "Hello";
    }
}
