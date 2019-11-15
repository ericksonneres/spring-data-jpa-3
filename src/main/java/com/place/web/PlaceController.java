package com.place.web;

import com.place.model.Place;
import com.place.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> list = placeService.getAllPlaces();
        return new ResponseEntity<List<Place>>(list, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Place>> findOne(@PathVariable String name) {
        List<Place> list = placeService.findPlace(name);
        return new ResponseEntity<List<Place>>(list, HttpStatus.OK);
               // .map(DetailedPlaceDto::fromEntity)
                //.map(ResponseEntity::ok)
                //.orElse(ResponseEntity.status(HttpStatus.valueOf(400)).build());
                //.orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Place place) {
        return ResponseEntity.ok(placeService.savePlace(place));
    }

    @PutMapping
    public ResponseEntity<Place> update(@Valid @RequestBody Place place) {
        if (!placeService.findById(place.getPlaceId()).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(placeService.updatePlace(place));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!placeService.findById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        placeService.deletePlace(id);

        return ResponseEntity.ok().build();
    }
}
