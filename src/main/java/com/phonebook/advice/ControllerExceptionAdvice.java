package com.phonebook.advice;

import com.phonebook.config.LogMessage;
import com.phonebook.config.UIMessage;
import com.phonebook.exception.PhoneBookException;
import com.phonebook.response.ErrorResponse;
import com.phonebook.response.PhoneBookResponse;
import com.phonebook.util.AppUtils;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Controller exception handler advice class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

    private static final Map<String, String> ENUM_FIELD_ERRORS = new HashMap<>();

    static {
        ENUM_FIELD_ERRORS.put("addressType", "[PERMANENT_ADDRESS, CURRENT_ADDRESS]");
        ENUM_FIELD_ERRORS.put("contactType", "[MOBILE, OFFICE, LANDLINE]");
    }

    /**
     * Handles Throwable when this type of exception thrown.
     *
     * @param ex Exception type reference that caught
     * @return ResponseEntity of PhoneBookResponse
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<PhoneBookResponse> handleThrowable(Throwable ex) {
        log.debug(LogMessage.CTRLR_ADV_MSG_1);
        String errorId = AppUtils.getErrorId();
        log.error(LogMessage.CTRLR_ADV_ERROR_MSG_1, errorId, ex);
        String uiMsg = String.format(UIMessage.CTRLR_ADV_ERR_MSG_1, errorId);
        ErrorResponse.ErrorResponseBuilder responseMessage = ErrorResponse.builder();
        responseMessage.errorMessage(uiMsg);
        return new ResponseEntity<>(responseMessage.build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles HttpMessageNotReadableException when this type of exception thrown.
     * Used for Enum validation
     *
     * @param ex Error type reference that caught
     * @return ResponseEntity of PhoneBookResponse
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<PhoneBookResponse> handleHttpMsgNotReadableEx(HttpMessageNotReadableException ex) {
        log.debug(LogMessage.CTRLR_ADV_MSG_2);
        String errMsg = ex.getMessage();
        ErrorResponse.ErrorResponseBuilder responseMessage = ErrorResponse.builder();
        Map<String, String> fieldErrors = new HashMap<>();
        ENUM_FIELD_ERRORS.forEach((key, value) -> {
            if (errMsg.contains(value)) {
                String fieldErrorMsg = String.format(UIMessage.ENUM_IVALID_ERR, key, value);
                fieldErrors.put(key, fieldErrorMsg);
            }
        });
        responseMessage.errorMessage(UIMessage.PHONE_BOOK_CTRLR_MSG_2).fieldsError(fieldErrors);
        return new ResponseEntity<>(responseMessage.build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles ConstraintViolationException when controller request path variable or params invalid.
     * Used for controller method validation
     *
     * @param ex ConstraintViolationException type reference that caught
     * @return ResponseEntity of PhoneBookResponse
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<PhoneBookResponse> handleConstraintViolationEx(ConstraintViolationException ex) {
        log.debug(LogMessage.CTRLR_ADV_MSG_3);
        List<String> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));
        ErrorResponse.ErrorResponseBuilder responseMessage = ErrorResponse.builder();
        responseMessage.errorMessage(UIMessage.PHONE_BOOK_CTRLR_MSG_3).paramErrors(errors);
        return new ResponseEntity<>(responseMessage.build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles PhoneBookException when controller throws
     * Used for controller PhoneBookException exception
     *
     * @param ex PhoneBookException type reference that caught
     * @return ResponseEntity of PhoneBookResponse
     */
    @ExceptionHandler(PhoneBookException.class)
    public ResponseEntity<PhoneBookResponse> handlePhoneBookException(PhoneBookException ex) {
        log.debug(LogMessage.CTRLR_ADV_MSG_4);
        String errorId = AppUtils.getErrorId();
        log.error(LogMessage.CTRLR_ADV_ERROR_MSG_1, errorId, ex);
        String uiMsg = String.format(UIMessage.CTRLR_ADV_ERR_MSG_1, errorId);
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ErrorResponse.ErrorResponseBuilder responseMessage = ErrorResponse.builder();
        responseMessage.errorMessage(uiMsg).paramErrors(errors);
        return new ResponseEntity<>(responseMessage.build(), HttpStatus.BAD_REQUEST);
    }
}