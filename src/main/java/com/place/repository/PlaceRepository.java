package com.place.repository;

import com.place.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/** Database repository interface responsible for handling operations provided for Place. */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {


    //Optional<Place> findPlaceByName(String name);

    //List<Place> findByNome(String name);

    List<Place> findByNameStartingWith(String name);

    //List<Place> findByNamePlaceContaining(String name);

    //@Query("SELECT e FROM Place e WHERE e.name LIKE %?1")
    //Place findByOtherInfoBeginningWith(String name);
}
