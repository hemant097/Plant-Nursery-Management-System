package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.PlantException;
import com.masai.Exceptions.PlanterException;
import com.masai.Exceptions.SeedException;
import com.masai.ServiceLayer.CustomerService;
import com.masai.ServiceLayer.PlantService;
import com.masai.ServiceLayer.PlanterService;
import com.masai.ServiceLayer.SeedService;
import com.masai.ServiceLayer.UserLoginLogoutService;
import com.masai.ServiceLayer.UserService;
import com.masai.models.Plant;
import com.masai.models.Planter;
import com.masai.models.Seed;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CustomerService cService;
	@Autowired
	private UserLoginLogoutService userLoginLogOutService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserLoginLogoutService loginLogOutService;
	@Autowired 
	private SeedService seedService;
	@Autowired
	private PlantService plantService;
	@Autowired
	private PlanterService planterService;
	
/*----------------------------------------SEEDS--------------------------------------*/
	
	@PostMapping("/seed/add")
	public ResponseEntity<Seed> saveNewSeed(@RequestBody Seed seed)
			throws SeedException{

		Seed savedSeed = seedService.addSeed(seed);

		return new ResponseEntity<Seed>(savedSeed, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/seed/delete/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId)
			throws SeedException{

		Seed deletedSeed = seedService.deleteSeed(seedId);

		return new ResponseEntity<Seed>(deletedSeed, HttpStatus.OK);
	}
	@PutMapping("/seed/update")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed)
			throws SeedException{

		Seed updatedSeed = seedService.updateSeed(seed);

		return new ResponseEntity<Seed>(updatedSeed, HttpStatus.CREATED);
	}
	
	@GetMapping("/seed/byID/{seedid}")
	public ResponseEntity<Seed> getSpecificSeed(@PathVariable Integer seedid)
			throws SeedException{

		Seed specificSeed = seedService.viewSeed(seedid);

		return new ResponseEntity<Seed>(specificSeed, HttpStatus.OK);
	}
	
	@GetMapping("/seed/{commonName}")
	public ResponseEntity<List<Seed>> viewSeedByCommonName(@PathVariable String commonName)
			throws SeedException{

		List<Seed> seedsByCommonName = seedService.viewSeed(commonName);

		return new ResponseEntity<List<Seed>>(seedsByCommonName, HttpStatus.OK);
	}
	
	@GetMapping("/seed/all")
	public ResponseEntity<List<Seed>> viewAllSeeds()
			throws SeedException{

		List<Seed> allSeeds = seedService.viewAllSeeds();
		

		return new ResponseEntity<List<Seed>>(allSeeds, HttpStatus.OK);
	}
	
	@GetMapping("/seed/all/{seedType}")
	public ResponseEntity<List<Seed>> viewAllSeedsByTypeOfSeed(@PathVariable String seedType)
			throws SeedException{
		List<Seed> allSeeds = seedService.viewAllSeeds(seedType);		

		return new ResponseEntity<List<Seed>>(allSeeds, HttpStatus.OK);
	}
	
/*----------------------------------------PLANTS--------------------------------------*/
	
	@PostMapping("/plant/add")
	public ResponseEntity<Plant> saveNewPlant(@RequestBody Plant plant)
			throws PlantException{
//plantService
		Plant savedPlant = plantService.addPlant(plant);

		return new ResponseEntity<Plant>(savedPlant, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/plant/delete/{plantId}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Integer plantId)
			throws PlantException{

		Plant deletedPlant = plantService.deletePlant(plantId);

		return new ResponseEntity<Plant>(deletedPlant, HttpStatus.OK);
	}
	
	@PutMapping("/plant/update")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant)
			throws PlantException{

		Plant updatedPlant = plantService.updatePlant(plant);

		return new ResponseEntity<Plant>(updatedPlant, HttpStatus.CREATED);
	}
	
	@GetMapping("/plant/byID/{plantId}")
	public ResponseEntity<Plant> getSpecificPlant(@PathVariable Integer plantId)
			throws PlantException{

		Plant specificPlant = plantService.viewPlant(plantId);

		return new ResponseEntity<Plant>(specificPlant, HttpStatus.OK);
	}
	
	@GetMapping("/plant/{commonName}")
	public ResponseEntity<List<Plant>> viewPlantByCommonName(@PathVariable String commonName)
			throws PlantException{

		List<Plant> plantsByCommonName = plantService.viewPlant(commonName);

		return new ResponseEntity<List<Plant>>(plantsByCommonName, HttpStatus.OK);
	}
	
	@GetMapping("/plant/all")
	public ResponseEntity<List<Plant>> viewAllPlants()
			throws PlantException{

		List<Plant> allPlants = plantService.viewAllPlants();
		

		return new ResponseEntity<List<Plant>>(allPlants, HttpStatus.OK);
	}
	
	@GetMapping("/plant/all/{plantType}")
	public ResponseEntity<List<Plant>> viewAllPlantsByTypeOfPlant(@PathVariable String plantType)
			throws PlantException{
		List<Plant> allPlants = plantService.viewAllPlants(plantType);		

		return new ResponseEntity<List<Plant>>(allPlants, HttpStatus.OK);
	}
	
	
	/*--------------------------------------------PLANTERS----------------------------------------*/

	@PostMapping("/planter/add")
	public ResponseEntity<Planter> saveNewPlanter(@RequestBody Planter planter)
			throws PlanterException{
//plantService	
		Planter savedPlanter = planterService.addPlanter(planter);

		return new ResponseEntity<Planter>(savedPlanter, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/planter/delete/{planterId}")
	public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId)
			throws PlanterException{

		Planter deletedPlanter = planterService.deletePlanter(planterId);

		return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
	}
	
	@PutMapping("/planter/update")
	public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter)
			throws PlanterException{

		Planter updatedPlanter = planterService.updatePlanter(planter);

		return new ResponseEntity<Planter>(updatedPlanter, HttpStatus.CREATED);
	}
	
	@GetMapping("/planter/byID/{planterId}")
	public ResponseEntity<Planter> getSpecificPlanterById(@PathVariable Integer planterId)
			throws PlanterException{

		Planter specificPlanter = planterService.viewPlanter(planterId);

		return new ResponseEntity<Planter>(specificPlanter, HttpStatus.OK);
	}
	
	@GetMapping("/planter/{planterShape}")
	public ResponseEntity<List<Planter>> viewPlanterByShape(@PathVariable String planterShape)
			throws PlanterException{

		List<Planter> plantersByShape = planterService.viewPlanter(planterShape);

		return new ResponseEntity<List<Planter>>(plantersByShape, HttpStatus.OK);
	}
	
	@GetMapping("/planter/all")
	public ResponseEntity<List<Planter>> viewAllPlanters()
			throws PlanterException{

		List<Planter> allPlanters = planterService.viewAllPlanters();
		

		return new ResponseEntity<List<Planter>>(allPlanters, HttpStatus.OK);
	}
	
	@GetMapping("/planter/all/range")
	public ResponseEntity<List<Planter>> viewAllPlantersByTypeOfPlanter
			(@RequestParam Double minCost,@RequestParam Double maxCost)
			throws PlanterException{
		List<Planter> allPlanters = planterService.
						viewAllPlanters(minCost, maxCost);	

		return new ResponseEntity<List<Planter>>(allPlanters, HttpStatus.OK);
	}
	
/*----------------------------------------------------------------------------------------*/






}
