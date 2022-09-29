package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.models.Planter;

@Repository
public interface PlanterDAO extends JpaRepository<Planter, Integer> {

	
	public List<Planter> findByPlanterShape(String planterShape);
	
	public List<Planter> findByPlanterCostBetween(double start,double end);
}
