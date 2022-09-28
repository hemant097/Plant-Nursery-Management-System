package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Planter;

public interface PlanterDAO extends JpaRepository<Planter, Integer> {

}
