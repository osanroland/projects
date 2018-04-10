package com.first.map.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.first.map.place.Place;

public class PlaceRowMapper implements RowMapper<Place>{


		@Override
		public Place mapRow(ResultSet row, int rowNum) throws SQLException {
			Place pl = new Place();
			pl.setId(row.getLong("id"));
			pl.setName(row.getString("name"));
			pl.setType(row.getString("type"));
			pl.setLatitude(row.getDouble("latitude"));
			pl.setLongitude(row.getDouble("longitude"));
			pl.setDescription(row.getString("description"));
			return pl;
		}
	} 

