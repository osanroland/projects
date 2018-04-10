package com.first.map.service;

import java.util.List;

import com.first.map.place.Place;

public interface PlaceService {
	List<Place> getAllPlaces();
    boolean add(Place pl);
    void update(Place pl);
    void delete(long id);
    List<Place> getPlacesByType(String type);
    Place getPlaceById(long id);
}
