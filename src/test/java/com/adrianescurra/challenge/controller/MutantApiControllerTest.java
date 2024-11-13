package com.adrianescurra.challenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.adrianescurra.challenge.model.DNA;
import com.adrianescurra.challenge.services.DNAService;
import com.adrianescurra.challenge.services.HumanService;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class MutantApiControllerTest {
	
	@MockBean
    private DNAService dnaService;

    @MockBean
    private HumanService humanService;
    
    @Autowired
    private MutantApiController mutantApiController;
    
    @Test
    void testVerifyMutantBadRequestInvalidDNA() {
        List<String> invalidDnaSequence = List.of("ATGC", "CGTA", "GGAT");
  
        DNA dna = new DNA();
        dna.setDna(invalidDnaSequence);
        
        when(dnaService.isValidDNA(invalidDnaSequence)).thenReturn(false);

        ResponseEntity<Void> response = mutantApiController.verifyMutant(dna);

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
        
        DNA dna = new DNA();
        dna.setDna(nonMutantDnaSequence);

        when(dnaService.isValidDNA(nonMutantDnaSequence)).thenReturn(true);
        when(humanService.isMutant(nonMutantDnaSequence)).thenReturn(false);

        ResponseEntity<Void> response = mutantApiController.verifyMutant(dna);

        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }
    
    @Test
    void testVerifyMutantOkIsMutant() {
        List<String> mutantDnaSequence = List.of("ATGCGC", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
        
        DNA dna = new DNA();
        dna.setDna(mutantDnaSequence);
        
        when(dnaService.isValidDNA(mutantDnaSequence)).thenReturn(true);
        when(humanService.isMutant(mutantDnaSequence)).thenReturn(true);

        ResponseEntity<Void> response = mutantApiController.verifyMutant(dna);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
}
