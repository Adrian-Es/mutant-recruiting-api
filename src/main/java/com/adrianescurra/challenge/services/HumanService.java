package com.adrianescurra.challenge.services;

import java.util.List;

import com.adrianescurra.challenge.model.Stats;

public interface HumanService {
	List<Stats> getAllStats();

	boolean isMutant(List<String> sequences);
}
