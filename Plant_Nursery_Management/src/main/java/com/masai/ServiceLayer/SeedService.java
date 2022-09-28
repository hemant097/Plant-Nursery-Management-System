package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.SeedException;
import com.masai.models.Seed;

public interface SeedService {

	public Seed addSeed(Seed seed) throws SeedException;
	
	public Seed updateSeed(Seed seed) throws SeedException;
	
	public Seed deleteSeed(Seed seed) throws SeedException;
	
	public Seed viewSeed(int seedId) throws SeedException;
	
	public List<Seed> viewSeed(String commonName) throws SeedException;
	
	public List<Seed> viewAllSeeds() throws SeedException;
	
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException;
}
