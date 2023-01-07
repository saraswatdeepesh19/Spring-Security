package com.deepesh.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

	@GetMapping("/myNotice")
	public String getNoticeDetails() {
		return "Here are the Notice details from the DB";
	}
}
