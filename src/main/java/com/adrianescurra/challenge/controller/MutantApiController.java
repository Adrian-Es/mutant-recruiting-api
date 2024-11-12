package com.adrianescurra.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.adrianescurra.challenge.services.DNAService;
import com.adrianescurra.challenge.services.HumanService;

@Controller
public class MutantApiController implements MutantApi {

	@Autowired
	private HumanService humanService;
	@Autowired
	private DNAService dnaService;

	@Override
	public ResponseEntity<Void> verifyMutant(List<String> dnaSequence) {

		if (!dnaService.isValidDNA(dnaSequence))
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

		boolean isMutant = humanService.isMutant(dnaSequence);

		if (!isMutant)
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);

		return ResponseEntity.ok(null);
	}

}
