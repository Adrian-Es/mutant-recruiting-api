package com.adrianescurra.challenge.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.adrianescurra.challenge.entity.Human;
import com.adrianescurra.challenge.model.Stats;
import com.adrianescurra.challenge.services.implement.HumanServiceImpl;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class HumanServiceTest {
	
	@Autowired
    private HumanServiceImpl humanService;
	
	@Test
    void testGenerateHumanMutant() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        List<String> sequences = List.of(
        		"ATGCGC",
        	    "CAGTGC",
        	    "TTATGT",
        	    "AGAAGG",
        	    "CCCCTA",
        	    "TCACTG");
        int mutantSequencesquantity = 3;

        Method generateHumanMethod = HumanServiceImpl.class.getDeclaredMethod("generateHuman", List.class, int.class);
        generateHumanMethod.setAccessible(true);


        Human human = (Human) generateHumanMethod.invoke(humanService, sequences, mutantSequencesquantity);

        assertTrue(human.isMutant());
        assertEquals(100, human.getCountHumanDNA());
        assertEquals(50, human.getCountMutantDNA());
        assertEquals(0.5, human.getMutantRatio(), 0.01);
    }
	
	@Test
    void testCalculateMutantSequences() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        List<String> sequences = List.of(
        		"ATGCGCAT",
        	    "CAGTGCGC",
        	    "TTATGTAT",
        	    "AGAAGGCG",
        	    "CCCCTTAT",
        	    "TAACTCCG",
        	    "GCATGGTA",
        	    "TGTCCACG");

        Method generateHumanMethod = HumanServiceImpl.class.getDeclaredMethod("calculateMutantSequences", List.class);
        generateHumanMethod.setAccessible(true);


        int mutantSequences = (int) generateHumanMethod.invoke(humanService, sequences);


        assertEquals(4, mutantSequences);
    }
	
	@Test
	void testGetAllStats() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		List<String> sequences = List.of(
        		"ATGCGC",
        	    "CAGTGC",
        	    "TTATGT",
        	    "AGAAGG",
        	    "CCCCTA",
        	    "TCACTG");
        int mutantSequencesquantity = 3;

        Method generateHumanMethod = HumanServiceImpl.class.getDeclaredMethod("generateHuman", List.class, int.class);
        generateHumanMethod.setAccessible(true);
        Human human = (Human) generateHumanMethod.invoke(humanService, sequences, mutantSequencesquantity);
        
        humanService.isMutant(sequences);
        
        Stats stat = new Stats();
        stat.setCountHumanDNA(human.getCountHumanDNA());
        stat.setCountMutantDNA(human.getCountMutantDNA());
        stat.setRatio(human.getMutantRatio());
        
        List<Stats> statList = humanService.getAllStats();
        for(Stats statAux : statList) {
        	assertEquals(stat.getCountHumanDNA(), statAux.getCountHumanDNA());
        	assertEquals(stat.getCountMutantDNA(), statAux.getCountMutantDNA());
        	assertEquals(stat.getRatio(), statAux.getRatio());
        }
        
        
	}
	
	@Test
	void testIsMutant() {
		List<String> sequences = List.of(
        		"ATGCGC",
        	    "CAGTGC",
        	    "TTATGT",
        	    "AGAAGG",
        	    "CCCCTA",
        	    "TCACTG");
		assertTrue(humanService.isMutant(sequences));
	}
}
