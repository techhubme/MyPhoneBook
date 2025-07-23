package com.phonebook.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Country class represent the contact country.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@ToString
@Getter
@EqualsAndHashCode
public class Country {

    /* Country code */
    private String code;

    /* Country name */
    private String name;

    /* Country currency name */
    private String currency;

    /* Country currency symbol ASCII value */
    private String currencySymbol;
}
