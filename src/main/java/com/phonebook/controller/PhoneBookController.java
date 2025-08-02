package com.phonebook.controller;

import com.phonebook.config.LogMessage;
import com.phonebook.config.UIMessage;
import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.response.ErrorResponse;
import com.phonebook.response.PhoneBookResponse;
import com.phonebook.response.SuccessResponse;
import com.phonebook.service.PhoneBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
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
@RestController
@RequestMapping(value = "/contact")
public class PhoneBookController {

    /* phoneBookService reference */
    private PhoneBookService phoneBookService;

    @Autowired
    private PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    /**
     * Add a new contact to phone book.
     *
     * @param contactDto PhoneBookContactDto - The request payload
     * @param errors     Errors - If request body payload has any error
     * @return ResponseEntity of PhoneBookResponse - Error or success
     */
    @PostMapping(value = {"/add"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PhoneBookResponse> addContact(@Valid @RequestBody PhoneBookContactDto contactDto, Errors errors) throws Exception {
        log.debug(LogMessage.PHONE_BOOK_CNTLR_MSG_1);
        if (errors.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            List<FieldError> fieldErrors = errors.getFieldErrors();
            fieldErrors.forEach(e -> errorMap.put(e.getField(), e.getDefaultMessage()));
            return new ResponseEntity<>(ErrorResponse.builder().fieldsError(errorMap)
                    .errorMessage(UIMessage.PHONE_BOOK_CTRLR_MSG_2).build(),
                    HttpStatus.BAD_REQUEST);
        } else {
            String id = this.phoneBookService.save(contactDto);
            return new ResponseEntity<>(SuccessResponse.builder().contactId(id)
                    .successMessage(UIMessage.PHONE_BOOK_CTRLR_MSG_1).build(), HttpStatus.CREATED);
        }
    }
}
