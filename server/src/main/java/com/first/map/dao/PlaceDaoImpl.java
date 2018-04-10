package com.first.map.dao;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.first.map.dao.PlaceRowMapper;
import com.first.map.dao.PlaceDAO;
import com.first.map.place.Place;
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
@Repository
public class PlaceDaoImpl implements PlaceDAO {
	@Autowired
        private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Place> getAllPlaces() {
		String sql = "SELECT id,name,type,latitude,longitude,description FROM place";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Place> rowMapper = new PlaceRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	@Override
		public void add(Place pl) {
			//Add place
			String sql = "INSERT INTO place (id,name,type,latitude,longitude,description) values (?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, pl.getId(), pl.getName(), pl.getType(),pl.getLatitude(),pl.getLongitude(),pl.getDescription());
			//Fetch article id
			sql = "SELECT id FROM place WHERE name = ? and type= ? and latitude = ? and longitude = ? and description = ?";
			long plId = jdbcTemplate.queryForObject(sql, Long.class,pl.getName(), pl.getType(),pl.getLatitude(),pl.getLongitude(),pl.getDescription() );
			
			//Set article id  
			pl.setId(plId);
	}
	
	@Override
	public void update(Place pl) {
		String sql = "UPDATE place SET name = ? and type=? and latitude = ? and longitude = ? and description = ? WHERE id=?";
		jdbcTemplate.update(sql, pl.getName(), pl.getType(),pl.getLatitude(),pl.getLongitude(),pl.getDescription());
		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM place WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public List<Place> findPlacesByType(String type) {
		String sql = "SELECT id,name,type,latitude,longitude,description FROM place WHERE type=?";
        //RowMapper<Place> rowMapper = new BeanPropertyRowMapper<Place>(Place.class);
		RowMapper<Place> rowMapper = new PlaceRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper,type);
	}

	@Override
	public Place getPlaceById(Long id) {
		String sql = "SELECT id,name,type,latitude,longitude,description FROM place WHERE id = ?";
		RowMapper<Place> rowMapper = new BeanPropertyRowMapper<Place>(Place.class);
		Place pl = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return pl;
	}

	@Override
	public boolean placeExists(String name, String type) {
		String sql = "SELECT count(*) FROM place WHERE name = ? and type=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, name,type);
		if(count == 0) {
    		        return false;
		} else {
			return true;
		}
		
	}
}