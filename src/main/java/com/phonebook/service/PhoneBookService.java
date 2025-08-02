package com.phonebook.service;

import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.exception.PhoneBookException;

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

    /**
     * Get the PhoneBookContactDto by contact id
     *
     * @param contactId String - Contact id
     * @return PhoneBookContactDto type reference
     * @throws PhoneBookException exception
     */
    PhoneBookContactDto getById(String contactId) throws PhoneBookException;
}
