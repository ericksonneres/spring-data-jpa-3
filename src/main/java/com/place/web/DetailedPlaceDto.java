package com.place.web;

import com.place.model.Place;

import java.sql.Timestamp;

public class DetailedPlaceDto {
    private long placeId;
    private String name;
    private String slug;
    private String city;
    private String state;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static DetailedPlaceDto fromEntity(Place place) {
        DetailedPlaceDto detailed = new DetailedPlaceDto();
        detailed.setPlaceId(place.getPlaceId());
        detailed.setName(place.getName());
        detailed.setSlug(place.getSlug());
        detailed.setCity(place.getCity());
        detailed.setState(place.getState());
        detailed.setCreatedAt(place.getCreatedAt());
        detailed.setUpdatedAt(place.getUpdatedAt());

        return detailed;
    }
}
