package com.phonebook.controller;

import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.response.ErrorResponse;
import com.phonebook.response.PhoneBookResponse;
import com.phonebook.response.SuccessResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The rest controller class for PhoneBook
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
@Validated
@RestController
@RequestMapping(value = "/contact")
public class PhoneBookController {

    /**
     * Add a new contact to phone book.
     *
     * @param contactDto PhoneBookContactDto - The request payload
     * @param errors  Errors - If request body has any error
     * @return ResponseEntity of PhoneBookResponse - Error or success
     */
    @PostMapping("/add")
    public ResponseEntity<PhoneBookResponse> addPhoneBookContact(@Valid @RequestBody PhoneBookContactDto contactDto, Errors errors) {
        log.info("Adding New PhoneBook Contact");
        if (errors.hasErrors()) {
            log.info("PhoneBook Contact is invalid");
            List<FieldError> fieldErrors = errors.getFieldErrors();
            Map<String, String> reqErr = new HashMap<>();
            for (FieldError fieldError : fieldErrors) {
                reqErr.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(ErrorResponse.builder().errors(reqErr).build(), HttpStatus.BAD_REQUEST);
        } else {
            log.info("PhoneBook Contact is valid");
            return new ResponseEntity<>(SuccessResponse.builder().successMessage("Phonebook Contact created").build(), HttpStatus.CREATED);
        }
    }
}
