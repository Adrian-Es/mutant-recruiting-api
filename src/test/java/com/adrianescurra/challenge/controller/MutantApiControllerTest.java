package com.adrianescurra.challenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.adrianescurra.challenge.services.DNAService;
import com.adrianescurra.challenge.services.HumanService;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class MutantApiControllerTest {
	
	@Mock
    private DNAService dnaService;

    @Mock
    private HumanService humanService;
	
    @Autowired
    private MutantApiController mutantApiController;
    
    @Test
    void testVerifyMutantBadRequestInvalidDNA() {
        List<String> invalidDnaSequence = List.of("ATGC", "CGTA", "GGAT");

        when(dnaService.isValidDNA(invalidDnaSequence)).thenReturn(false);

        ResponseEntity<Void> response = mutantApiController.verifyMutant(invalidDnaSequence);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
    
    @Test
    void testVerifyMutantForbiddenNotMutant() {
        List<String> nonMutantDnaSequence = List.of(
        		"GTGCTC",
        	    "CAGTGC",
        	    "TTATGT",
        	    "AGAAGG",
        	    "CGCCTA",
        	    "TCACTG");

        when(dnaService.isValidDNA(nonMutantDnaSequence)).thenReturn(true);
        when(humanService.isMutant(nonMutantDnaSequence)).thenReturn(false);

        ResponseEntity<Void> response = mutantApiController.verifyMutant(nonMutantDnaSequence);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }
    
    @Test
    void testVerifyMutantOkIsMutant() {
        List<String> mutantDnaSequence = List.of("ATGCGC", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");

        when(dnaService.isValidDNA(mutantDnaSequence)).thenReturn(true);
        when(humanService.isMutant(mutantDnaSequence)).thenReturn(true);

        ResponseEntity<Void> response = mutantApiController.verifyMutant(mutantDnaSequence);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
}
