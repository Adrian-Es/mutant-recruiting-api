package com.adrianescurra.challenge.service.implementation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.adrianescurra.challenge.services.implement.DNAServiceImpl;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class DNAServiceImplTest {
	
	@Autowired
    private DNAServiceImpl dnaService;
	
	@Test
    void testSequenceValid(){
        List<String> sequences = List.of(
        		"ATGCGC",
        	    "CAGTGC",
        	    "TTATGT",
        	    "AGAAGG",
        	    "CCCCTA",
        	    "TCACTG");

        assertTrue(dnaService.isValidDNA(sequences));
    }
	
	@Test
    void testSequenceSizeInvalid(){
        List<String> sequences = List.of(
        		"ATGCGC",
        	    "CAGTGC");

        assertFalse(dnaService.isValidDNA(sequences));
    }
	
	@Test
    void testSequenceLengthInvalid(){
        List<String> sequences = List.of(
        		"ACGC",
        	    "CAGTGC",
        	    "TTATGT",
        	    "AGAAGG",
        	    "CCCCTA",
        	    "TCACTG");

        assertFalse(dnaService.isValidDNA(sequences));
    }
	
	@Test
    void testSequenceCharacterInvalid(){
        List<String> sequences = List.of(
        		"ACGCGZ",
        	    "CAGTGC",
        	    "TTATGT",
        	    "AGAAGG",
        	    "CCCCTA",
        	    "TCACTG");
        assertFalse(dnaService.isValidDNA(sequences));
    }
	
}
