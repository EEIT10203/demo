package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.TUser;

public interface TUserRepository extends CrudRepository<TUser, Long> {

	@Query("select u from TUser u where u.userId=:userId")
	public TUser getById(@Param("userId") String userId);
	
	@Query("select a from TUser a")
	public List<TUser> getAllUser();
	
	@Query("select a from TUser a where a.role=:role")
	public List<TUser> getrole();

	@Query("select a from TUser a where a.role=:role")
	public List<TUser> getRole(@Param("role") String role);
	
	@Query("select u from TUser u where u.userUuid=:userUuid")
	public TUser getUserById(@Param("userUuid") int userUuid);
}
