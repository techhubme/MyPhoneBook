package com.phonebook.service;

import com.phonebook.adaptor.PhoneBookAdaptor;
import com.phonebook.config.LogMessage;
import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.exception.PhoneBookException;
import com.phonebook.model.PhoneBookContact;
import com.svsoft.datarepo.exception.ObjectRepositoryException;
import com.svsoft.datarepo.repository.LocalObjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;

/**
 * PhoneBookService implements
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
@Repository
public class LocalPhoneBookService implements PhoneBookService {

    private final LocalObjectRepository<PhoneBookContact> repository;

    @Autowired
    public LocalPhoneBookService(LocalObjectRepository<PhoneBookContact> repository) {
        this.repository = repository;
    }


    @Override
    public String save(PhoneBookContactDto contactDto) throws PhoneBookException {
        try {
            return repository.save(PhoneBookAdaptor.toPhoneBookContact(contactDto));
        } catch (ObjectRepositoryException ex) {
            log.error(LogMessage.LOC_BOOK_SERVICE_MSG_1, ex);
            throw new PhoneBookException(LogMessage.LOC_BOOK_SERVICE_MSG_1, ex);
        }
    }

    @Override
    public PhoneBookContactDto getById(String contactId) throws PhoneBookException {
        try {
            PhoneBookContact contact = repository.get(contactId);
            return PhoneBookAdaptor.toPhoneBookContactDto(contact);
        } catch (ObjectRepositoryException ex) {
            String message = MessageFormat.format(LogMessage.LOC_BOOK_SERVICE_MSG_2, contactId);
            log.error(message, ex);
            throw new PhoneBookException(message, ex);
        }
    }
}
