package com.place.error;

public class PlaceNotFoundException extends RuntimeException {

    public PlaceNotFoundException(Object id) {
        super("Place id not found : " + id);
    }

}