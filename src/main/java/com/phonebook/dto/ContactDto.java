package com.phonebook.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Contact class represent the contact number.
 * it holds country code, contact number, contact type.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
public class ContactDto {

    /* Country code of contact number */
    private String countryCode;

    /* Contact number */
    private String contactNumber;

    /* Type of contact */
    private ContactType contactType;

    /**
     * ContactType enum
     */
    public enum ContactType {
        MOBILE, LANDLINE, OFFICE, HOME
    }
}
