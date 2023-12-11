package com.odettelane.inventario.exceptions;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException() {
        super("Item not found with that id.");
    }

    public ItemNotFoundException(String item) {
        super(item + " not found with that id.");
    }
}
