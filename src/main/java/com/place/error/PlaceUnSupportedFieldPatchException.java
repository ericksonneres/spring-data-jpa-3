package com.place.error;

import com.place.model.Place;

import java.util.Set;

public class PlaceUnSupportedFieldPatchException extends RuntimeException {

    public PlaceUnSupportedFieldPatchException(Place place) {
        super("Field " + place.getName() + " update is not allow.");
    }

}
