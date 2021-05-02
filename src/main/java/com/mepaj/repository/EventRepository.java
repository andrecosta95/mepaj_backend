package com.mepaj.repository;

import com.mepaj.model.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query(value = "select e from Event e  where e.status = Pending")
	List<Event> findEventsPendingApproval();
}
