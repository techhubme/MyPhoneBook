package com.phonebook.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.phonebook.config.UIMessage;
import com.phonebook.config.Values;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

/**
 * PhoneBookContact class represent the contact details.
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneBookContactDto {

    /* First name of person */
    @NotNull(message = UIMessage.FIRST_NAME_ERR_MSG_1)
    @NotBlank(message = UIMessage.FIRST_NAME_ERR_MSG_1)
    @Pattern(message = UIMessage.FIRST_NAME_ERR_MSG_2, regexp = Values.NAME_REGEX)
    private String firstName;

    /* Middle name of person */
    @Pattern(message = UIMessage.MIDDLE_NAME_ERR_MSG_1, regexp = Values.NAME_REGEX)
    private String middleName;

    /* Last name of person */
    @NotNull(message = UIMessage.LAST_NAME_ERR_MSG_1)
    @NotBlank(message = UIMessage.LAST_NAME_ERR_MSG_1)
    @Pattern(message = UIMessage.LAST_NAME_ERR_MSG_2, regexp = Values.NAME_REGEX)
    private String lastName;

    /* List of Contact of person */
    @Valid
    @NotNull(message = UIMessage.CONTACT_NUMBER_ERR_MSG_3)
    private List<ContactDto> contacts;

    /* List of address for contact */
    @Valid
    private List<AddressDto> addresses;
}
