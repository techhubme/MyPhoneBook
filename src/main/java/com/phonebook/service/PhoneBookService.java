package com.phonebook.service;

import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.exception.PhoneBookException;
import com.phonebook.model.PhoneBookContact;

/**
 * PhoneBookService interface
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
public interface PhoneBookService {

    /**
     * Save the PhoneBookContact
     *
     * @param contactDto PhoneBookContactDto refence
     * @return String the phone book contact id
     */
    String save(PhoneBookContactDto contactDto) throws PhoneBookException;
}
