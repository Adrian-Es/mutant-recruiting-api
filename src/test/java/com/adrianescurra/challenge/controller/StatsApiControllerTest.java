package com.adrianescurra.challenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.adrianescurra.challenge.model.Stats;
import com.adrianescurra.challenge.services.HumanService;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class StatsApiControllerTest {
	
	@MockBean
    private HumanService humanService;
	
	@Autowired
	private StatsApiController statsApiController;
	
	@Test
    void testGetAllStats() throws Exception {
        // Crear un ejemplo de lista de Stats
        Stats stat1 = new Stats();
        stat1.setCountHumanDNA(100);
        stat1.setCountMutantDNA(40);
        stat1.setRatio(0.4f);
        List<Stats> statsList = Arrays.asList(stat1);
        
        when(humanService.getAllStats()).thenReturn(statsList);

        ResponseEntity<List<Stats>> response = statsApiController.getAllStats();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

	
}
