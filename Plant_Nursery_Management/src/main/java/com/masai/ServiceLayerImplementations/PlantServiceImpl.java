package com.masai.ServiceLayerImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.PlantException;
import com.masai.Repository.PlantDAO;
import com.masai.ServiceLayer.PlantService;
import com.masai.models.Plant;

@Service
public class PlantServiceImpl implements PlantService {
	
	@Autowired
	private PlantDAO plantDAO;
	
	@Override
	public Plant addPlant(Plant plant) throws PlantException {
		
		Plant savedPlant = plantDAO.save(plant);
		
		 if(savedPlant==null) throw new PlantException("Can't add this plant");
			
		 else return savedPlant;
		
	}

	@Override
	public Plant updatePlant(Plant plant) throws PlantException {
		
		Integer plantId = plant.getPlantId();
		
		Optional<Plant> found = plantDAO.findById(plantId);	
		
		if(found.isPresent()) {
			return plantDAO.save(plant);
		}
		else
			throw  new PlantException("Cannot Update, No such Plant present ");			
	}

	@Override
	public Plant deletePlant(Plant plant) throws PlantException {
		
		Integer plantId = plant.getPlantId();
		
		Optional<Plant> found = plantDAO.findById(plantId);		
		
		if(found.isPresent()) {
			plantDAO.delete(plant);
			return plant;
		}
		else
			throw  new PlantException("Cannot Delete "+plant.getCommonName()+" No such Plant present ");
		
	}

	@Override
	public Plant viewPlant(Integer plantId) throws PlantException {
		
		Optional<Plant> found = plantDAO.findById(plantId);		
		
		return found.orElseThrow( ()-> new PlantException(
		"Unable to find Plant with id "+plantId));
		
	}

	@Override
	public List<Plant> viewPlant(String commonName) throws PlantException {
		List<Plant> plantListByCommonName;
		
		plantListByCommonName = plantDAO.findByCommonName(commonName);
		
		if(plantListByCommonName.size()!=0)
		return plantListByCommonName;
		else
		throw  new PlantException("Cannot find any plant by this common name ");
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		
		List<Plant> allPlants;
		
		allPlants = plantDAO.findAll();
		
		if(allPlants.size()!=0)
		return allPlants;
		else
		throw  new PlantException("We don't have any plants in the database ");
		
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantException {
		
		List<Plant> allPlantsByOneType;
		
		allPlantsByOneType = plantDAO.findAll();
		
		if(allPlantsByOneType.size()!=0)
		return allPlantsByOneType;
		else
		throw  new PlantException("We don't have this type of "+typeOfPlant+" in the database");
		
	}

	
	
	
}
