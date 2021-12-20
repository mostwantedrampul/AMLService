package com.aml.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class UitlityAML {

	@Autowired
	private RestTemplate restTemplate;

	public String responceJson(String url) {
		String json = "";
		ObjectNode node = null;
		try {
			String response = restTemplate.getForObject(url, String.class);
			node = new ObjectMapper().readValue(response, ObjectNode.class);
			if (node.has(RaterConstants.CHECK_QUOTES)) {
				json = node.get(RaterConstants.CHECK_QUOTES).toString();
				System.out.println("contentType: " + json);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
