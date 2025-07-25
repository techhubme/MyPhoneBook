package com.phonebook.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * PhoneBookContact class represent the contact details.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
public class PhoneBookContact {

    /* Unique contact id */
    private String contactId;

    /* First name of person */
    private String firstName;

    /* Middle name of person */
    private String middleName;

    /* Last name of person */
    private String lastName;

    /* List of Contact of person */
    private List<Contact> contacts;

    /* List of address for contact */
    private List<Address> addresses;

}
