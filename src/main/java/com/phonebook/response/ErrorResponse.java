package com.phonebook.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * Error response class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Builder
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse implements PhoneBookResponse {

    private String errorMessage;
    private Map<String, String> fieldsError;
    private List<String> paramErrors;
}
