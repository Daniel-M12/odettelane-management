package com.odettelane.inventario.exceptions;

public class NotNegativeAttributeException extends Exception{
    public NotNegativeAttributeException() {
        super("Attribute can not be negative.");
    }

    public NotNegativeAttributeException(String attribute) {
        super(attribute + " can not be negative.");
    }
}
