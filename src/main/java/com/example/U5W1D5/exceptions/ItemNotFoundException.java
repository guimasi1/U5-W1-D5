package com.example.U5W1D5.exceptions;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(UUID uuid) {
        super("Id " + uuid + " not found");
    }
}
