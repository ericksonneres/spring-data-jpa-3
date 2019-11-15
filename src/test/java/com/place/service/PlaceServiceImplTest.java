package com.place.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.place.model.Place;
import com.place.repository.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.junit.jupiter.api.Assertions.*;

//@AutoConfigureMockMvc
//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class PlaceServiceImplTest {

    private static final long ID_PLACE = 1L;

    @InjectMocks
    PlaceServiceImpl service;

    @Mock
    PlaceRepository placeRepository;

    //@Autowired
    //private PlaceRepository placeRepository;

    //@Autowired
    //private MockMvc mockMvc;

    private Place place = new Place();
    private List<Place> places = new ArrayList<Place>();

    @BeforeEach
    void setUp() {
        place.setName("testName");
        place.setSlug("testSlug");
        place.setCity("testCity");
        place.setState("testState");
        place.setPlaceId(1);
        places.add(place);
        //placeRepository.save(place);

        //Mockito.when(placeRepository.findByNameStartingWith(place.getName()))
        //        .thenReturn(places);
    }

    @Test
    void findPlace() {
       /* Place secondPlace = new Place("testName");

        when(placeRepository.findByNameStartingWith("testName")).thenReturn(Arrays.asList(place, secondPlace));

        List<Place> placeDtoList = service.findPlace("testName");

        assertThat(placeDtoList, hasSize(2));
        assertThat(placeDtoList.get(0).getName(), is(equalTo("testName")));
        assertThat(placeDtoList.get(1).getName(), is(equalTo("testName")));

        verify(placeRepository).findByNameStartingWith("testName"); */
    }

    @Test
    void getAllPlaces() {
        Place secondPlace = new Place("32259952070");

        when(placeRepository.findAll()).thenReturn(Arrays.asList(place, secondPlace));

        List<Place> placeDtoList = service.getAllPlaces();

        assertThat(placeDtoList, hasSize(2));
        assertThat(placeDtoList.get(0).getName(), is(equalTo("testName")));
        assertThat(placeDtoList.get(1).getName(), is(equalTo("32259952070")));

        verify(placeRepository).findAll();
    }

    @Test
    void findById() {
        when(placeRepository.findById(ID_PLACE)).thenReturn(Optional.of(place));
        Optional<Place> response = service.findById(ID_PLACE);
        assertThat(response.get().getName(), is(equalTo("testName")));

        verify(placeRepository).findById(ID_PLACE);
    }

    @Test
    void savePlace() {
        when(placeRepository.save(place)).thenReturn(place);

        Place responseDto = service.savePlace(place);

        assertThat(responseDto.getName(), is(equalTo("testName")));

        verify(placeRepository).save(place);
    }

    @Test
    void updatePlace() {
    }

    @Test
    void deletePlace() {
       
    }
}