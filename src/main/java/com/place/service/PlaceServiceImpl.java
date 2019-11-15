package com.place.service;

import com.place.error.PlaceNotFoundException;
import com.place.error.PlaceUnSupportedFieldPatchException;
import com.place.model.Place;
import com.place.repository.PlaceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository repository;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.repository = placeRepository;
    }

   /* @Override
    @Transactional(readOnly = true)
    public Optional<User> findOne(String username) {
        return repository.findDetailedByUsername(username);
    } */

    @Override
    public List<Place> findPlace(String name) {
        if (repository.findByNameStartingWith(name).isEmpty()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
            throw new PlaceNotFoundException(name);
        }

        return repository.findByNameStartingWith(name);
    }

    @Override
    public List<Place> getAllPlaces() {
        return repository.findAll();
    }

    @Override
    public Optional<Place> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Place savePlace(Place place) {
        if (repository.findById(place.getPlaceId()).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
            throw new PlaceUnSupportedFieldPatchException(place);
        }

        if (place.getCreatedAt() == null) {
            Timestamp times = getTimestamp();
            place.setCreatedAt(times);
            place.setUpdatedAt(times);
        }
        return repository.save(place);
    }

    @Override
    public Place updatePlace(Place place) {
        return repository.findById(place.getPlaceId())
                .map(x -> {
                    String name = place.getName();
                    if (!StringUtils.isEmpty(name)) {
                        x.setName(place.getName());
                        x.setCity(place.getCity());
                        x.setSlug(place.getSlug());
                        x.setState(place.getState());
                        x.setUpdatedAt(getTimestamp());
                        return repository.save(x);
                    } else {
                        throw new PlaceUnSupportedFieldPatchException(x);
                    }
                })
                .orElseGet(() -> {
                    throw new PlaceNotFoundException(place.getPlaceId());
                });
    }

    @Override
    public void deletePlace(Long placeId) {
        if (!repository.findById(placeId).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
            throw new PlaceNotFoundException(placeId);

        }
        repository.deleteById(placeId);
    }

    private Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
