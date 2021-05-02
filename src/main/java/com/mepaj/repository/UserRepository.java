package com.mepaj.repository;

import com.mepaj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "select u from User u  where u.profile.isActive = 0")
	List<User> findUsersPendingApproval();
}
