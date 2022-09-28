package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Seed;

@Repository
public interface SeedDAO extends JpaRepository<Seed, Integer> {
	
	public List<Seed> findByCommonName(String commonName);
	
	public List<Seed> findByTypeOfSeeds(String typeOfSeeds);
}