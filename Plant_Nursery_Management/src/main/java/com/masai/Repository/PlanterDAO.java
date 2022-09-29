package com.masai.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.models.Planter;


public interface PlanterDAO extends JpaRepository<Planter, Integer> {

	
	public List<Planter> findByPlantershape(String planterShape);
	
	public List<Planter> findByPlanterCostBetween(double start,double end);
}
