package com.fawry.student_mangement.exception.customException;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message);
    }
}
