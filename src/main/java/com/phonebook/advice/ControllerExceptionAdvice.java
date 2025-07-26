package com.phonebook.advice;

import com.phonebook.config.LogMessage;
import com.phonebook.config.UIMessage;
import com.phonebook.response.ErrorResponse;
import com.phonebook.response.PhoneBookResponse;
import com.phonebook.util.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The Controller exception handler advice class
 *
 * @author Ram Niwash
 * @since 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * Handles Exception when this type of exception thrown.
     *
     * @param ex Exception type reference that caught
     * @return ResponseEntity of PhoneBookResponse
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<PhoneBookResponse> handleException(Exception ex) {
        String errorId = AppUtils.getErrorId();
        log.error(LogMessage.CTRLR_ADV_ERROR_MSG_1, errorId, ex);
        String uiMsg = String.format(UIMessage.CTRLR_ADV_ERR_MSG_1, errorId);
        ErrorResponse.ErrorResponseBuilder responseMessage = ErrorResponse.builder();
        responseMessage.errorMessage(uiMsg);
        return new ResponseEntity<>(responseMessage.build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles Error when this type of exception thrown.
     *
     * @param ex Error type reference that caught
     * @return ResponseEntity of PhoneBookResponse
     */
    @ExceptionHandler(Error.class)
    public ResponseEntity<PhoneBookResponse> handleError(Error ex) {
        String errorId = AppUtils.getErrorId();
        log.error(LogMessage.CTRLR_ADV_ERROR_MSG_1, errorId, ex);
        String uiMsg = String.format(UIMessage.CTRLR_ADV_ERR_MSG_1, errorId);
        ErrorResponse.ErrorResponseBuilder responseMessage = ErrorResponse.builder();
        responseMessage.errorMessage(uiMsg);
        return new ResponseEntity<>(responseMessage.build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}