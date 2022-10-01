package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.PlanterException;
import com.masai.models.Planter;

public interface PlanterService {

	public Planter addPlanter(Planter planter) throws PlanterException;

	public Planter updatePlanter(Planter planter) throws PlanterException;

	public Planter deletePlanter(Integer planterId) throws PlanterException;

	public Planter viewPlanter(Integer planterId) throws PlanterException;

	public List<Planter> viewPlanter(String planterShape) throws PlanterException;

	public List<Planter> viewAllPlanters() throws PlanterException;

	public List<Planter> viewAllPlanters(double minCost, double maxCost) throws PlanterException;

}
