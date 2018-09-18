package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TOrderDetail;

@Repository
public interface TOrderDetailRepository extends CrudRepository<TOrderDetail, Integer> {

	// @Query("select a from TOrderDetail a where a.detail_id=:detail_id")
	// public TOrderDetail getByDetailId(@Param("detailId") Integer detailId);
	//
	// @Query("select a from TOrderDetail a where a.detail_id=:detail_id")
	// public TOrderDetail getByUserId(@Param("userId")String userId);
	//
	@Query("select a from TOrderDetail a")
	public List<TOrderDetail> getAllOrderDetail();

	@Query("select a from TOrderDetail a where a.orderId in (select  orderId  from TOrder b where b.activityId=:activityId )")
	public List<TOrderDetail> getAddOrderDetail(@Param("activityId") int activityId);

}
