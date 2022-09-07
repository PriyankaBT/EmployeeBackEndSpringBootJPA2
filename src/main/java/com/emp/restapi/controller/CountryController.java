package com.emp.restapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mycountry", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CountryController {
 
 public static ArrayList<String> a=new ArrayList<String>(Arrays.asList
			("INDIA","JAPAN","AMERICA","SHRILANKA"));
	
	
// @RequestMapping(value = "/countries",
//		 method = RequestMethod.GET,
//		 headers="Accept=application/json")
 @GetMapping(value = "/countries")
 public ResponseEntity<List> getCountries()
 {
	 return new ResponseEntity<List>(a, HttpStatus.OK);

 }
 
 @PostMapping(value = "/add/{cname}")
 public ResponseEntity<String> addCountry(@PathVariable("cname") String cname1) {
	a.add(cname1);
	 return new ResponseEntity<String>("Added successfully",
			 HttpStatus.CREATED);

 }


}
