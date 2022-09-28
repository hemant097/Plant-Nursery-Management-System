package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Plant;
import com.masai.models.Seed;

public interface PlantDAO extends JpaRepository<Plant, Integer> {
	
	public List<Plant> findByCommonName(String commonName);
	
	public List<Plant> findByTypeOfSeeds(String typeOfPlant);
}