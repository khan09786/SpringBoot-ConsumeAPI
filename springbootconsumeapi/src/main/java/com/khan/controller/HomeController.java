package com.khan.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.khan.model.Organization;

@RestController
@RequestMapping
public class HomeController {

	@GetMapping("/employees")
	public String getEmployees() {
		final String uri = "http://localhost:8080/employees";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		return result;
	}

	@GetMapping("/organizations")
	public List<Organization> getOrganization() {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Organization>> response = restTemplate.exchange("http://localhost:8080/organizations",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Organization>>() {
				});
		List<Organization> organization = response.getBody();
		return organization;

	}

}
