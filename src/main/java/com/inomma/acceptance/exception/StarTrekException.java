package com.inomma.acceptance.exception;

/**
 *Star Trek Exception
 */
public class StarTrekException extends RuntimeException {

    public StarTrekException(String message) {
        super(message);
    }

    public StarTrekException(String message, Throwable cause) {
        super(message, cause);
    }
}
