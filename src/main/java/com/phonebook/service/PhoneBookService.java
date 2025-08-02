package com.phonebook.service;

import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.exception.PhoneBookException;

import java.util.List;

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
     * Update the PhoneBookContact
     *
     * @param contactDto PhoneBookContactDto refence
     * @return boolean - Flag true if updated successfully otherwise false
     */
    boolean update(PhoneBookContactDto contactDto) throws PhoneBookException;

    /**
     * Get the PhoneBookContactDto by contact id
     *
     * @param contactId String - Contact id
     * @return PhoneBookContactDto type reference
     * @throws PhoneBookException exception
     */
    PhoneBookContactDto getById(String contactId) throws PhoneBookException;

    /**
     * Delete contact by contact id
     *
     * @param contactId String - Contact id
     * @return boolean - Flag true if deleted successfully otherwise false
     * @throws PhoneBookException exception
     */
    boolean deleteById(String contactId) throws PhoneBookException;

    /**
     * Get the list of PhoneBookContactDto in pagination
     *
     * @param offset integer - Offset of index
     * @param limit  integer - Limit of contacts
     * @return List of PhoneBookContactDto
     * @throws PhoneBookException exception
     */
    List<PhoneBookContactDto> listContact(int offset, int limit) throws PhoneBookException;
}
