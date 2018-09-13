package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TActivityType;

@Repository
public interface TActivityTypeRepository extends CrudRepository<TActivityType, Integer>{
	@Query("select a from TActivityType a")
	public List<TActivityType> getAllTActivityType();
}
