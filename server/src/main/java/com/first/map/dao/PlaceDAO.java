package com.first.map.dao;

import java.util.List;
import com.first.map.place.Place;


public interface PlaceDAO   {
	List<Place> getAllPlaces();
    void add(Place pl);
    void update(Place pl);
    void delete(Long id);
	List<Place> findPlacesByType(String type);
	Place getPlaceById(Long id);
	boolean placeExists(String name, String type);
	
}


