package com.datacenter.dcsclient.util;

import java.math.BigDecimal;

import com.datacenter.dcsclient.domain.Address;
import com.datacenter.dcsclient.domain.Developer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	
	public Test() {
		Developer d = new Developer();
		d.setId(1298L);
		d.setName("Pavan Solapure");
		d.setSalary(new BigDecimal("123.45"));
		Address a = new Address();
		a.setCountry("India");
		a.setState("Maharashtra");
		a.setZipcode("411028");
		d.setAddress(a);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			System.out.println(objectMapper.writeValueAsString(d));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Test();
	}
}
