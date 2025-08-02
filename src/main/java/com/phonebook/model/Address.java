
package com.phonebook.model;

import lombok.*;

import java.io.Serializable;

/**
 * Address class represent the contact address.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Data
public class Address implements Serializable {

    /* The landmark or locality of address */
    private String landMark;

    /* Name of the city or village */
    private String villageOrCity;

    /* Name of district */
    private String district;

    /* Name of state */
    private String state;

    /* The country for address */
    private String countryName;

    /* PinCode or ZipCode of address */
    private String pinCode;

    /* Type of address */
    private AddressType addressType;

    /**
     * ENUM for address type
     */
    public enum AddressType implements Serializable {
        CURRENT_ADDRESS, PERMANENT_ADDRESS
    }
}
