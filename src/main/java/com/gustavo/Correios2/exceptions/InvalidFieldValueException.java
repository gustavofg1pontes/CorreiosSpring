package com.gustavo.Correios2.exceptions;

public class InvalidFieldValueException extends RuntimeException {

    public InvalidFieldValueException(String value) {
        super("O campo " + value + " não é valido");
    }
}
