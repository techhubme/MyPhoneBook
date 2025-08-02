package com.phonebook.adaptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonebook.dto.PhoneBookContactDto;
import com.phonebook.model.PhoneBookContact;

/**
 * PhoneBookAdaptor to transfer the object data
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
public final class PhoneBookAdaptor {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Private constructor prevent object instantiation
     */
    private PhoneBookAdaptor() {
    }

    /**
     * Transfer data from PhoneBookContactDto to PhoneBookContact
     *
     * @param contactDto PhoneBookContactDto object reference
     * @return PhoneBookContact type reference
     */
    public static PhoneBookContact toPhoneBookContact(PhoneBookContactDto contactDto) {
        return OBJECT_MAPPER.convertValue(contactDto, PhoneBookContact.class);
    }

    /**
     * Transfer data from PhoneBookContact to PhoneBookContactDto
     *
     * @param contact PhoneBookContact object reference
     * @return PhoneBookContactDto type reference
     */
    public static PhoneBookContactDto toPhoneBookContactDto(PhoneBookContact contact) {
        return OBJECT_MAPPER.convertValue(contact, PhoneBookContactDto.class);
    }
}
