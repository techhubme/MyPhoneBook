package com.phonebook.dto;

import com.phonebook.config.Values;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class PhoneBookContactDto {

    /* First name of person */
    @NotNull(message = Values.FIRST_NAME_ERR_MSG_1)
    @Pattern(message = Values.FIRST_NAME_ERR_MSG_2, regexp = Values.NAME_REGEX)
    private String firstName;

    /* Middle name of person */
    private String middleName;

    /* Last name of person */
    @NotNull(message = "First Name must not be null")
    @Pattern(message = "First Name is Invalid", regexp = Values.NAME_REGEX)
    private String lastName;

    /* List of Contact of person */
    private List<ContactDto> contactList;

    /* List of address for contact */
    private List<AddressDto> addresses;

}
