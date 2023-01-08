package com.deepesh.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@GetMapping("/myCard")
	public String getCardDetails() {
		return "Here are the cards details from the DB";
	}
}
