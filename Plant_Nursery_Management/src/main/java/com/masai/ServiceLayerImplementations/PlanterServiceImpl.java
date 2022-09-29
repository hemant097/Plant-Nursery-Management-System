package com.masai.ServiceLayerImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.PlanterException;
import com.masai.Repository.PlanterDAO;
import com.masai.ServiceLayer.PlanterService;
import com.masai.models.Planter;

@Service
public class PlanterServiceImpl implements PlanterService {
	
	@Autowired
	private PlanterDAO planterDAO;
	
	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		
		 Planter savedPlanter = planterDAO.save(planter);
			
		 if(savedPlanter==null) throw new PlanterException("Can't add this Planter");
			
		 else return savedPlanter;
		
	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
		
		Integer planterId = planter.getPlanterId();
		
		Optional<Planter> found = planterDAO.findById(planterId);		
		
		if(found.isPresent()) {
			return planterDAO.save(planter);
		}
		else
			throw  new PlanterException("Cannot Update, No such Planter present ");
		
	}

	@Override
	public Planter deletePlanter(Planter planter) throws PlanterException {
		
		
		Integer planterId = planter.getPlanterId();
		
		Optional<Planter> found = planterDAO.findById(planterId);		
		
		if(found.isPresent()) {
			planterDAO.delete(planter);
			return planter;
		}
		else
			throw  new PlanterException("Cannot Delete, No such Planter present ");
	}
		
	

	@Override
	public Planter viewPlanter(int planterId) throws PlanterException {
		
		Optional<Planter> found = planterDAO.findById( planterId);		
		
		return found.orElseThrow( ()-> new PlanterException(
		"Unable to find Planter with id "+planterId));
		
	}

	@Override
	public List<Planter> viewPlanter(String planterShape) throws PlanterException {
	
	
		List<Planter> allPlantersByPlanterShape;
		
		allPlantersByPlanterShape = planterDAO.findByPlantershape(planterShape);
		
		if(allPlantersByPlanterShape.size()!=0)
		return allPlantersByPlanterShape;
		else
		throw  new PlanterException("We don't have any "+planterShape +"shaped planters in the database ");
	
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		
		List<Planter> allPlanters;
		
		allPlanters = planterDAO.findAll();
		
		if(allPlanters.size()!=0)
		return allPlanters;
		else
		throw  new PlanterException("We don't have any planters in the database ");
		
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) throws PlanterException {
		
		List<Planter> allPlantersBetweenRange;
		
		allPlantersBetweenRange = planterDAO.findByPlanterCostBetween(minCost, maxCost);
		
		if(allPlantersBetweenRange.size()!=0)
		return allPlantersBetweenRange;
		else
		throw  new PlanterException("We don't have any planters between "+minCost+" and "+maxCost);
		
	}

}
