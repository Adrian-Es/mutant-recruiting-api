package com.adrianescurra.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianescurra.challenge.entity.Human;

public interface HumanRepository extends JpaRepository<Human, Integer>{

}
