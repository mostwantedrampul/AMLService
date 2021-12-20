package com.aml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.aml.util.UitlityAML;

@Service
public class AMLServerimpl {


	@Value(value = "${currency.exchange.access}")
	private String access_key;

	@Value(value = "${currency.exchange.url}")
	private String url;
	
	@Autowired
	private UitlityAML aml;

	public String getCurrency() {	
		return aml.responceJson(url+access_key);
	}

	public String getCurrency_local() {
		String pathVariables="&currencies=TZA,ZAR,KEN&source=USD&format=1";
		return aml.responceJson(url +access_key+pathVariables);
	}

}
