package com.adrianescurra.challenge.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianescurra.challenge.entity.Human;
import com.adrianescurra.challenge.model.Stats;
import com.adrianescurra.challenge.repository.HumanRepository;
import com.adrianescurra.challenge.services.DNAService;
import com.adrianescurra.challenge.services.HumanService;

@Service
public class HumanServiceImpl implements HumanService {

	@Autowired
	private HumanRepository repository;

	@Autowired
	private DNAService dnaService;

	@Override
	public List<Stats> getAllStats() {
		List<Human> humans = repository.findAll();

		List<Stats> allStats = humans.stream().map(t -> {
			Stats stat = new Stats();
			stat.setId(t.getId());
			stat.setCountHumanDNA(t.getCountHumanDNA());
			stat.setCountMutantDNA(t.getCountMutantDNA());
			stat.setRatio(t.getMutantRatio());
			return stat;
		}).toList();

		return allStats;
	}

	@Override
	public boolean isMutant(List<String> sequences) {
		
		int mutantSequencesquantity = calculateMutantSequences(sequences);

		Human human = generateHuman(sequences, mutantSequencesquantity);

		saveHumanAndSequence(human, sequences);

		return human.isMutant();
	}
	
	private Human generateHuman(List<String> sequences, int mutantSequencesquantity) {
		int humanDNAQuantity = (int) Math.pow(sequences.size(), 2);
		int mutantDNAQuantity = sequences.size() * mutantSequencesquantity;

		boolean isMutant = mutantSequencesquantity >= 2;
		int countHumanDNA = 100;
		int countMutantDNA = (int) (mutantDNAQuantity * 100) / humanDNAQuantity;
		float mutantRatio = (float) countMutantDNA / (float) countHumanDNA;

		return new Human(isMutant, countHumanDNA, countMutantDNA, mutantRatio);
	}
	
	private void saveHumanAndSequence(Human human,List<String> sequences) {
		repository.save(human);
		dnaService.addSequences(human, sequences);
	}

	private int calculateMutantSequences(List<String> sequences) {
		int mutantSequencesquantity = 0;
		boolean[][] charIsValidated = new boolean[sequences.size()][sequences.size()];

		for (int i = 0; i < sequences.size(); i++) {
			String actualSequence = sequences.get(i);
			for (int j = 0; j < actualSequence.length(); j++) {
				if(charIsValidated[i][j])
					continue;
				
				// horizontal
				int horizontalSequence = 0;
				for (int k = j + 1; k < j + 4; k++) {
					if (k >= actualSequence.length() || actualSequence.charAt(j) != actualSequence.charAt(k))
						break;
					horizontalSequence++;
				}

				// vertical
				int verticalSequence = 0;
				for (int k = i + 1; k < i + 4; k++) {
					if (k >= sequences.size())
						break;
					String nextSequence = sequences.get(k);

					if (actualSequence.charAt(j) != nextSequence.charAt(j))
						break;

					verticalSequence++;
				}

				// diagonal derecha
				int diagonalRightSequence = 0;
				for (int k = 1; k < 4; k++) {
					if (i + k >= sequences.size() || j + k >= actualSequence.length())
						break;
					String nextSequence = sequences.get(i + k);

					if (actualSequence.charAt(j) != nextSequence.charAt(j + k))
						break;

					diagonalRightSequence++;
				}
				
				// diagonal izquierda
				int diagonalLeftSequence = 0;
				for (int k = 1; k < 4; k++) {
					if (i + k >= sequences.size() || j - k < 0)
						break;
					String nextSequence = sequences.get(i + k);

					if (actualSequence.charAt(j) != nextSequence.charAt(j - k))
						break;

					diagonalLeftSequence++;
				}

				if (horizontalSequence == 3) {
					for (int k = j; k < j + 4; k++)
						charIsValidated[i][k] = true;
					mutantSequencesquantity++;
					
				}else if (verticalSequence == 3) {
					for (int k = i; k < i + 4; k++)
						charIsValidated[k][j] = true;
					mutantSequencesquantity++;
					
				}else if (diagonalRightSequence == 3) {
					for (int k = 0; k < 4; k++)
						charIsValidated[i + k][j + k] = true;
					mutantSequencesquantity++;
					
				}else if (diagonalLeftSequence == 3) {
					for (int k = 0; k < 4; k++)
						charIsValidated[i + k][j - k] = true;
					mutantSequencesquantity++;
				}
			}
		}

		return mutantSequencesquantity;
	}
}
