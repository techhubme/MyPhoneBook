
package com.phonebook.dto;

import com.phonebook.config.UIMessage;
import com.phonebook.config.Values;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
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
public class AddressDto {

    /* The landmark or locality of address */
    @Pattern(message = UIMessage.LANDMARK_ERR_MSG_1, regexp = Values.LANDMARK_REGEX)
    private String landMark;

    /* Name of the city or village */
    @NotNull(message = UIMessage.VILLAGE_CITY_ERR_MSG_1)
    @NotBlank(message = UIMessage.VILLAGE_CITY_ERR_MSG_1)
    @Pattern(message = UIMessage.VILLAGE_CITY_ERR_MSG_2, regexp = Values.VILLAGE_CITY_REGEX)
    private String villageOrCity;

    /* Name of district */
    @NotNull(message = UIMessage.DISTRICT_ERR_MSG_1)
    @NotBlank(message = UIMessage.DISTRICT_ERR_MSG_1)
    @Pattern(message = UIMessage.DISTRICT_ERR_MSG_2, regexp = Values.DISTRICT_REGEX)
    private String district;

    /* Name of state */
    @NotNull(message = UIMessage.STATE_ERR_MSG_1)
    @NotBlank(message = UIMessage.STATE_ERR_MSG_1)
    @Pattern(message = UIMessage.STATE_ERR_MSG_2, regexp = Values.DISTRICT_REGEX)
    private String state;

    /* The country for address */
    @NotNull(message = UIMessage.COUNTRY_ERR_MSG_1)
    @NotBlank(message = UIMessage.COUNTRY_ERR_MSG_1)
    @Pattern(message = UIMessage.COUNTRY_ERR_MSG_2, regexp = Values.DISTRICT_REGEX)
    private String countryName;

    /* PinCode or ZipCode of address */
    @NotNull(message = UIMessage.PIN_CODE_ERR_MSG_1)
    @NotBlank(message = UIMessage.PIN_CODE_ERR_MSG_1)
    @Pattern(message = UIMessage.PIN_CODE_ERR_MSG_2, regexp = Values.PIN_CODE_REGEX)
    private String pinCode;

    /* Type of address */
    private AddressType addressType;

    /**
     * ENUM for address type
     */
    public enum AddressType {
        CURRENT_ADDRESS, PERMANENT_ADDRESS
    }
}
