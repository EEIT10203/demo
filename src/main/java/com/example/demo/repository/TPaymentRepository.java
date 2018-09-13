package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TPayment;

@Repository
public interface TPaymentRepository extends CrudRepository<TPayment, Integer>{

	@Query("select a from TPayment a where a.orderId=:orderId")
	public List<TPayment> getByOrderId(@Param("orderId") int orderId);
}