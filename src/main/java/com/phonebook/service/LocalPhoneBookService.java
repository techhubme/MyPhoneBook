package com.phonebook.service;

import com.phonebook.adaptor.PhoneBookAdaptor;
import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.exception.PhoneBookException;
import com.phonebook.model.PhoneBookContact;
import com.svsoft.datarepo.exception.ObjectRepositoryException;
import com.svsoft.datarepo.repository.LocalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * PhoneBookService implements
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
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
        } catch (ObjectRepositoryException e) {
            throw new PhoneBookException("Unable to save phone book contact");
        }
    }
}
