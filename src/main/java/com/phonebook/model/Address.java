
package com.phonebook.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Address class represent the contact address.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
public class Address {

    /* The landmark or locality of address */
    private String landMark;

    /* Name of the city or village */
    private String villageOrCity;

    /* Name of district */
    private String district;

    /* Name of state */
    private String state;

    /* The country for address */
    private Country country;

    /* PinCode or ZipCode of address */
    private String pinCode;

    /* Type of address */
    private AddressType addressType;

    /**
     * ENUM for address type
     */
    public enum AddressType {
        CURRENT, PERMANENT
    }
}
