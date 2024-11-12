package com.adrianescurra.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianescurra.challenge.entity.DNA;

public interface DNARepository extends JpaRepository<DNA, Integer> {
	boolean existsBySequenceAndSequenceLength(String sequence, int sequenceLength);
}
