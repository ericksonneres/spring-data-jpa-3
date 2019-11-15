package com.place.service;

import com.place.model.Place;

import java.util.List;
import java.util.Optional;

/** Service interface responsible for handling operations provided for Places. */
public interface PlaceService {

    List<Place> findPlace(String name);
    Optional<Place> findById(Long placeId);
    List<Place> getAllPlaces();
    Place savePlace(Place place);
    Place updatePlace(Place place);
    void deletePlace(Long placeId);
}
