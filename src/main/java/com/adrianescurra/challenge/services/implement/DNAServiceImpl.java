package com.adrianescurra.challenge.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianescurra.challenge.entity.DNA;
import com.adrianescurra.challenge.entity.Human;
import com.adrianescurra.challenge.repository.DNARepository;
import com.adrianescurra.challenge.services.DNAService;

@Service
public class DNAServiceImpl implements DNAService {

	private final char[] validCharacter = { 'A', 'T', 'C', 'G' };

	@Autowired
	private DNARepository repository;

	@Override
	public boolean isValidDNA(List<String> sequences) {
		if (sequences.size() <= 3)
			return false;

		for (String sequence : sequences) {
			if (sequence.length() != sequences.size())
				return false;

			for (int i = 0; i < sequence.length(); i++) {
				if (!characterIsValid(sequence.charAt(i)))
					return false;
			}
		}

		if (repository.existsBySequenceAndSequenceLength(generateFinalSequence(sequences), sequences.size()))
			return false;

		return true;
	}

	private boolean characterIsValid(char character) {
		boolean isValid = false;
		for (char c : validCharacter) {
			if (c == character) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}

	@Override
	public void addSequences(Human human, List<String> sequences) {
		int sequencesLength = sequences.size();

		addSequence(human, generateFinalSequence(sequences), sequencesLength);
	}

	private void addSequence(Human human, String sequence, int sequencesLength) {
		repository.save(new DNA(human, sequence, sequencesLength));
	}

	private String generateFinalSequence(List<String> sequences) {
		StringBuilder finalSequence = new StringBuilder();

		for (String sequence : sequences) {
			finalSequence.append(sequence);
		}

		return finalSequence.toString();
	}

}
