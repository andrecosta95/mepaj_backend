package com.mepaj.service;

import java.util.List;

import com.mepaj.model.Event;
import com.mepaj.util.excepiton.EventException;

public interface EventService {

	/**
	 * Method that create a event.
	 *
	 * @author André Costa
	 * @since 30/10/2020
	 *
	 * @param event
	 * @return `Event` object
	 * @throws EventException
	 */

	void save(Event event) throws EventException;

	/**
	 * Method that find a event by an id.
	 *
	 * @author André Costa
	 * @since 30/10/2020
	 *
	 * @param eventId
	 * @return `Event` object
	 * @throws NotUserException
	 */

	Event findById(Long eventId);

	/**
	 * Method that delete a event by an id.
	 *
	 * @author André Costa
	 * @since 30/10/2020
	 *
	 * @param eventId
	 * @return `Event` object
	 * @throws EventException
	 * @throws NotUserException
	 */

	void deleteById(Long eventId) throws EventException;

	/**
	 * Method that find all events.
	 *
	 * @author André Costa
	 * @since 30/10/2020
	 *
	 * @return `List<Event></Event>` object
	 * @throws NotUserException
	 */
	List<Event> findAll();
}
