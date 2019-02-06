package pl.rafal.mazurek.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParsingException extends RuntimeException {

    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
