package com.odettelane.inventario.exceptions;

public class IdNotProvidedException extends Exception{
    public IdNotProvidedException(String message) {
        super("Id not provided: " + message);
    }
}
