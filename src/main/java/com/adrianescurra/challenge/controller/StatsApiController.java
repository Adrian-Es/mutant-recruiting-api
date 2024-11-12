package com.adrianescurra.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.adrianescurra.challenge.model.Stats;
import com.adrianescurra.challenge.services.HumanService;

@Controller
public class StatsApiController implements StatsApi {

	@Autowired
	private HumanService humanService;

	@Override
	public ResponseEntity<List<Stats>> getAllStats() {
		return ResponseEntity.ok(humanService.getAllStats());
	}

}
