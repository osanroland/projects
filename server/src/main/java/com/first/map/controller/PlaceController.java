package com.first.map.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.first.map.place.Place;
import com.first.map.service.PlaceService;
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("api")
public class PlaceController {
	@Autowired
	private PlaceService placeService;
	
	@GetMapping("place/{id}")
	public ResponseEntity<Place> getPlaceById(@PathVariable("id") Long id) {
		Place pl = placeService.getPlaceById(id);
		return new ResponseEntity<Place>(pl, HttpStatus.OK);
	}
	
	@GetMapping("places/{type}")
	public ResponseEntity<List<Place>> getPlacesByType(@PathVariable("type") String type) {
		List<Place> list = placeService.getPlacesByType(type);
		return new ResponseEntity<List<Place>>(list, HttpStatus.OK);
	}
	
	@GetMapping("places")
	public ResponseEntity<List<Place>> getAllPlaces() {
		List<Place> list = placeService.getAllPlaces();
		return new ResponseEntity<List<Place>>(list, HttpStatus.OK);
	}
	
	@PostMapping("place")
	public ResponseEntity<Void> add(@RequestBody Place pl, UriComponentsBuilder builder) {
                boolean flag = placeService.add(pl);
                if (flag == false) {
        	   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/place/{id}").buildAndExpand(pl.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("place")
	public ResponseEntity<Place> update(@RequestBody Place pl) {
		placeService.update(pl);
		return new ResponseEntity<Place>(pl, HttpStatus.OK);
	}
	
	@DeleteMapping("place/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		placeService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 
