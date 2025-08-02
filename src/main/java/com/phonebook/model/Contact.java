package com.phonebook.model;

import lombok.*;

import java.io.Serializable;

/**
 * Contact class represent the contact number.
 * it holds country code, contact number, contact type.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Data
public class Contact implements Serializable {

    /* Country code of contact number */
    private String countryCode;

    /* Contact number */
    private String contactNumber;

    /* Type of contact */
    private ContactType contactType;

    /**
     * ContactType enum
     */
    public enum ContactType implements Serializable{
        MOBILE, LANDLINE, OFFICE, HOME
    }
}
