package com.aml.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.service.AMLServerimpl;
import com.aml.util.RaterConstants;



@RestController
public class AMLController {
	@Autowired
	private AMLServerimpl service;


	@GetMapping(RaterConstants.ALL_COUNTRY_LIST)
	public ResponseEntity<String> getCurrency() {
		return new ResponseEntity<>(service.getCurrency(), HttpStatus.OK);
	}
	
	@GetMapping(RaterConstants.COUNTRY_LIST)
	public ResponseEntity<String> getCurrencylocal() {
		return new ResponseEntity<>(service.getCurrency_local(), HttpStatus.OK);
	}
	

	
	@GetMapping(value =RaterConstants.APPLICATION_HEALTH_CHECK)
	public ResponseEntity<String> healthCheck(){
		return new ResponseEntity<>("VERSION: 1.0  ",HttpStatus.OK);
	}
	
	

}
