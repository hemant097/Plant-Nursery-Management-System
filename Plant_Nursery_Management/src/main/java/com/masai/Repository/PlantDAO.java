package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Plant;

@Repository
public interface PlantDAO extends JpaRepository<Plant, Integer> {
	
	public List<Plant> findByCommonName(String commonName);
	
	public List<Plant> findByTypeOfPlant(String typeOfPlant);
}