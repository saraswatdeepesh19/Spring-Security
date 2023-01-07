package com.deepesh.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

	@GetMapping("/myLoan")
	public String getLoansDetails() {
		return "Here are the Loans details from the DB";
	}
}
