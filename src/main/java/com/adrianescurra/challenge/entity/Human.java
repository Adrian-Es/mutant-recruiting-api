package com.adrianescurra.challenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Human {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "is_mutant", nullable = false)
	private boolean isMutant;

	@Column(name = "count_human_dna", nullable = false)
	private int countHumanDNA;

	@Column(name = "count_mutant_dna", nullable = false)
	private int countMutantDNA;

	@Column(name = "mutant_ratio", nullable = false)
	private float mutantRatio;

	public Human() {
		super();
	}

	public Human(boolean isMutant, int countHumanDNA, int countMutantDNA, float mutantRatio) {
		super();
		this.isMutant = isMutant;
		this.countHumanDNA = countHumanDNA;
		this.countMutantDNA = countMutantDNA;
		this.mutantRatio = mutantRatio;
	}

	public Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setIsMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

	public int getCountHumanDNA() {
		return countHumanDNA;
	}

	public void setCountHumanDNA(int countHumanDNA) {
		this.countHumanDNA = countHumanDNA;
	}

	public int getCountMutantDNA() {
		return countMutantDNA;
	}

	public void setCountMutantDNA(int countMutantDNA) {
		this.countMutantDNA = countMutantDNA;
	}

	public float getMutantRatio() {
		return mutantRatio;
	}

	public void setMutantRatio(float mutantRatio) {
		this.mutantRatio = mutantRatio;
	}

}
