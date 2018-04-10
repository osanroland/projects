package com.first.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.map.dao.PlaceDAO;
import com.first.map.place.Place;

@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceDAO placeDAO;
	
	@Override
	public Place getPlaceById(long id) {
		Place obj = placeDAO.getPlaceById(id);
		return obj;
	}
	@Override
	public List<Place> getAllPlaces(){
		return placeDAO.getAllPlaces();
	}
	@Override
	public synchronized boolean add(Place pl) {
        if (placeDAO.placeExists(pl.getName(), pl.getType())) {
          return false;
        } else {
           placeDAO.add(pl);
          return true;
        }
	}

	@Override
	public void update(Place pl) {
		placeDAO.update(pl);
		
	}

	@Override
	public void delete(long id) {
		placeDAO.delete(id);
		
	}

	@Override
	public List<Place> getPlacesByType(String type) {
		List<Place> placesbytype = placeDAO.findPlacesByType(type);
		return placesbytype;
	}



}
