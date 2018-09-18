package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TActivity;

@Repository
public interface TActivityRepository extends CrudRepository<TActivity, Integer> {
	@Query("select a from TActivity a where a.activityId=:activityId")
	public TActivity getById(@Param("activityId") int activityId);

	@Query("select a from TActivity a where a.activityId=:activityId and a.createUser=:createUser")
	public TActivity getByIdAndUser(@Param("activityId") int activityId, @Param("createUser") String createUser);

	@Query("select a from TActivity a where a.createUser=:createUser and a.activityStatus=:activityStatus")
	public List<TActivity> getAllCreateUser(@Param("createUser") String createUser,
			@Param("activityStatus") String activityStatus);

	@Query("select a from TActivity a")
	public List<TActivity> getAllActivity();

	@Query("select a from TActivity a where a.activityStatus=:activityStatus")
	public List<TActivity> getActivityByStatus(@Param("activityStatus") String activityStatus);

	@Query("select a from TActivity a where a.activityStatus=2 and (a.activityName LIKE CONCAT('%',:searchValue,'%') or a.activityType=:searchValue)")
	public List<TActivity> getActivityBySearch(@Param("searchValue") String searchValue);
}
