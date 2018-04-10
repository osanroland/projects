package com.first.map.client;


import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.first.map.place.Place;

public class RestClientUtil {
    public void getPlaceByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/api/place/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Place> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Place.class, 1);
        Place pl = responseEntity.getBody();
        System.out.println("Id:"+pl.getId()+", Name:"+pl.getName()
                 +", Type:"+pl.getType()+", Latitude:"+pl.getLatitude()+", Longitude:"+pl.getLongitude()+", Description:"+pl.getDescription());      
    }

    public void addDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/api/place";
	Place objPlace = new Place();
	objPlace.setName("Kiralysag");
	objPlace.setType("Vendéglő");
	objPlace.setLatitude(67.4);
	objPlace.setLongitude(55.667);
	objPlace.setDescription("Yes utu ma");
       HttpEntity<Place> requestEntity = new HttpEntity<Place>(objPlace, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/place";
	Place objPlace = new Place();
	objPlace.setName("Masodik");
	objPlace.setType("Restaurant");
	objPlace.setLatitude(60.78);
	objPlace.setLongitude(76);
	objPlace.setDescription("Ja nem");
        HttpEntity<Place> requestEntity = new HttpEntity<Place>(objPlace, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/place/{id}";
        HttpEntity<Place> requestEntity = new HttpEntity<Place>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 1);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getPlaceByIdDemo();
    	util.addDemo();
    	//util.getPlaceByIdDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    	//util.getAllArticlesDemo();    	
    }    
} 