package com.adrianescurra.challenge.services;

import java.util.List;

import com.adrianescurra.challenge.entity.Human;

public interface DNAService {
	boolean isValidDNA(List<String> sequences);

	void addSequences(Human human, List<String> sequences);
}
