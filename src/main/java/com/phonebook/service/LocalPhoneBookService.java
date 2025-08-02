package com.phonebook.service;

import com.phonebook.adaptor.PhoneBookAdaptor;
import com.phonebook.config.LogMessage;
import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.exception.PhoneBookException;
import com.phonebook.model.PhoneBookContact;
import com.svsoft.datarepo.exception.ObjectRepositoryException;
import com.svsoft.datarepo.repository.LocalObjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            return this.repository.save(PhoneBookAdaptor.toPhoneBookContact(contactDto));
        } catch (ObjectRepositoryException ex) {
            log.error(LogMessage.LOC_BOOK_SERVICE_MSG_1, ex);
            throw new PhoneBookException(LogMessage.LOC_BOOK_SERVICE_MSG_1, ex);
        }
    }

    @Override
    public boolean update(PhoneBookContactDto contactDto) throws PhoneBookException {
        try {
            if (StringUtils.isBlank(contactDto.getContactId())) {
                log.error(LogMessage.LOC_BOOK_SERVICE_MSG_5);
                throw new PhoneBookException(LogMessage.LOC_BOOK_SERVICE_MSG_5);
            }
            return this.repository.update(PhoneBookAdaptor.toPhoneBookContact(contactDto), contactDto.getContactId());
        } catch (ObjectRepositoryException ex) {
            log.error(LogMessage.LOC_BOOK_SERVICE_MSG_6, ex);
            throw new PhoneBookException(LogMessage.LOC_BOOK_SERVICE_MSG_6, ex);
        }
    }

    @Override
    public PhoneBookContactDto getById(String contactId) throws PhoneBookException {
        try {
            PhoneBookContact contact = this.repository.get(contactId);
            contact.setContactId(contactId);
            return PhoneBookAdaptor.toPhoneBookContactDto(contact);
        } catch (ObjectRepositoryException ex) {
            String message = MessageFormat.format(LogMessage.LOC_BOOK_SERVICE_MSG_2, contactId);
            log.error(message, ex);
            throw new PhoneBookException(message, ex);
        }
    }

    @Override
    public boolean deleteById(String contactId) throws PhoneBookException {
        try {
            return this.repository.delete(contactId);
        } catch (ObjectRepositoryException ex) {
            String message = MessageFormat.format(LogMessage.LOC_BOOK_SERVICE_MSG_3, contactId);
            log.error(message, ex);
            throw new PhoneBookException(message, ex);
        }
    }

    @Override
    public List<PhoneBookContactDto> listContact(int offset, int limit) throws PhoneBookException {
        try {
            Map<String, PhoneBookContact> contactMap = this.repository.list(offset, limit);
            List<PhoneBookContactDto> result = new ArrayList<>();
            contactMap.forEach((id, contact) -> {
                contact.setContactId(id);
                result.add(PhoneBookAdaptor.toPhoneBookContactDto(contact));
            });
            return result;
        } catch (ObjectRepositoryException ex) {
            log.error(LogMessage.LOC_BOOK_SERVICE_MSG_4, ex);
            throw new PhoneBookException(LogMessage.LOC_BOOK_SERVICE_MSG_4, ex);
        }
    }
}
