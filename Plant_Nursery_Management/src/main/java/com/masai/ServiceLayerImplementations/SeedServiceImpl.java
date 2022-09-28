package com.masai.ServiceLayerImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.SeedException;
import com.masai.Repository.SeedDAO;
import com.masai.ServiceLayer.SeedService;
import com.masai.models.Seed;


@Service
public class SeedServiceImpl implements SeedService{
	
	@Autowired
	private SeedDAO seedDAO;
	
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		
		 Seed savedSeed = seedDAO.save(seed);
		
		 if(savedSeed==null) throw new SeedException("Can't add this seed");
			
		 else return savedSeed;
		
	}
	
	
	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
		
		Integer seedId = seed.getSeedId();
		
		Optional<Seed> found = seedDAO.findById(seedId);		
		
		if(found.isPresent()) {
			return seedDAO.save(seed);
		}
		else
			throw  new SeedException("Cannot Update, No such Seed present ");		
	}
	
	
	
	@Override
	public Seed deleteSeed(Seed seed) throws SeedException {
		Integer seedId = seed.getSeedId();
		
		Optional<Seed> found = seedDAO.findById(seedId);		
		
		if(found.isPresent()) {
			seedDAO.delete(seed);
			return seed;
		}
		else
			throw  new SeedException("Cannot Delete this seed, No such Seed present ");
	}
	
	
	@Override
	public Seed viewSeed(int seedId) throws SeedException {
		
		
		Optional<Seed> found = seedDAO.findById(seedId);		
		
		return found.orElseThrow( ()-> new SeedException(
		"Unable to find Seed with id "+seedId));
	}
	
	
	
	@Override
	public List<Seed> viewSeed(String commonName) throws SeedException {
		List<Seed> seedListByCommonName;
		
		seedListByCommonName = seedDAO.findByCommonName(commonName);
		
		if(seedListByCommonName.size()!=0)
		return seedListByCommonName;
		else
		throw  new SeedException("Cannot find any seed by this common name ");
		
	}
	@Override
	public List<Seed> viewAllSeeds() throws SeedException {
		List<Seed> allSeeds;
		
		allSeeds = seedDAO.findAll();
		
		if(allSeeds.size()!=0)
		return allSeeds;
		else
		throw  new SeedException("We don't have any seeds in the database ");
	}
	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException {
		
		List<Seed> allSeedsByOneType;
		
		allSeedsByOneType = seedDAO.findByTypeOfSeeds(typeOfSeed);
		
		if(allSeedsByOneType.size()!=0)
		return allSeedsByOneType;
		else
		throw  new SeedException("We don't have this type of"+typeOfSeed+" in the database ");
		
	}

}
