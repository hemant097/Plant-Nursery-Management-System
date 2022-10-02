package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.PlantException;
import com.masai.Exceptions.PlanterException;
import com.masai.ServiceLayer.CustomerService;
import com.masai.ServiceLayer.PlantService;
import com.masai.ServiceLayer.PlanterService;
import com.masai.ServiceLayer.SeedService;
import com.masai.ServiceLayer.UserLoginLogoutService;
import com.masai.ServiceLayer.UserService;
import com.masai.models.Plant;
import com.masai.models.Planter;

@RestController
@RequestMapping("/planter")
public class PlanterController {
	
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
	
	
	@PostMapping("/{adminID}/add")
	public ResponseEntity<Planter> saveNewPlanter(@Valid @RequestBody Planter planter,
												@PathVariable Integer adminID)
			throws AdminException,PlanterException{
		
		Planter savedPlanter = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
		savedPlanter = planterService.addPlanter(planter);
		
		else
		throw new AdminException("You are not an admin");
		
		return new ResponseEntity<Planter>(savedPlanter, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{adminID}/delete/{planterId}")
	public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId,
												@PathVariable Integer adminID)
			throws AdminException,PlanterException{

		Planter deletedPlanter = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
		deletedPlanter = planterService.deletePlanter(planterId);
		
		else
		throw new AdminException("You are not an admin");

		return new ResponseEntity<Planter>(deletedPlanter, HttpStatus.OK);
	}
	
	@PutMapping("/{adminID}/update")
	public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter,
												@PathVariable Integer adminID)
			throws AdminException , PlanterException{

		Planter updatedPlanter = null;
		
		if(adminID==1111||adminID==2222||adminID==3333||adminID==4444)
		updatedPlanter = planterService.updatePlanter(planter);
		
		else
		throw new AdminException("You are not an admin");
		
		return new ResponseEntity<Planter>(updatedPlanter, HttpStatus.CREATED);
	}
	
	@GetMapping("/byID/{planterId}")
	public ResponseEntity<Planter> getSpecificPlanterById(@PathVariable Integer planterId)
			throws PlanterException{

		Planter specificPlanter = planterService.viewPlanter(planterId);

		return new ResponseEntity<Planter>(specificPlanter, HttpStatus.OK);
	}
	
	@GetMapping("/{planterShape}")
	public ResponseEntity<List<Planter>> viewPlanterByShape(@PathVariable String planterShape)
			throws PlanterException{

		List<Planter> plantersByShape = planterService.viewPlanter(planterShape);

		return new ResponseEntity<List<Planter>>(plantersByShape, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Planter>> viewAllPlanters()
			throws PlanterException{

		List<Planter> allPlanters = planterService.viewAllPlanters();
		

		return new ResponseEntity<List<Planter>>(allPlanters, HttpStatus.OK);
	}
	
	@GetMapping("/all/range")
	public ResponseEntity<List<Planter>> viewAllPlantersByTypeOfPlanter
			(@RequestParam Double minCost,@RequestParam Double maxCost)
			throws PlanterException{
		List<Planter> allPlanters = planterService.
						viewAllPlanters(minCost, maxCost);	

		return new ResponseEntity<List<Planter>>(allPlanters, HttpStatus.OK);
	}
}
