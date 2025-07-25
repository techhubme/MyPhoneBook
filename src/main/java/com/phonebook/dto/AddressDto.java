
package com.phonebook.dto;

import com.phonebook.config.UIMessage;
import com.phonebook.config.Values;
import jakarta.validation.constraints.Pattern;
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
public class AddressDto {

    /* The landmark or locality of address */
    @Pattern(message = UIMessage.LANDMARK_ERR_MSG_1, regexp = Values.LANDMARK_REGEX)
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
    public enum AddressType {
        CURRENT_ADDRESS, PERMANENT_ADDRESS
    }
}
