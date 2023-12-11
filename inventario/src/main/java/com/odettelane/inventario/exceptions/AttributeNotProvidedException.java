package com.odettelane.inventario.exceptions;

public class AttributeNotProvidedException extends Exception{
    public AttributeNotProvidedException() {
        super("You must provide an apropiate atributte");
    }
    public AttributeNotProvidedException(String attribute) {
        super("You must provide an appropriate " + attribute + ".");
    }
}
