package com.adrianescurra.challenge.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DNA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "human")
	@OneToOne(optional = false)
	private Human human;
	
	@Column(name = "sequence",nullable = false, length = 2500)
	private String sequence;
	
	@Column(name = "sequence_length",nullable = false)
	private int sequenceLength;

	public DNA() {
		super();
	}

	public DNA(Human human, String sequence, int sequenceLength) {
		super();
		this.human = human;
		this.sequence = sequence;
		this.sequenceLength = sequenceLength;
	}

	public Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public int getSequenceLength() {
		return sequenceLength;
	}

	public void setSequenceLength(int sequenceLength) {
		this.sequenceLength = sequenceLength;
	}
	
}
