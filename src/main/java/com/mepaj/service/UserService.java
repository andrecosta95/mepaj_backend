package com.mepaj.service;

import com.mepaj.model.User;
import com.mepaj.util.excepiton.UserException;

import java.util.List;

public interface UserService {

	/**
	 * Method that create a user.
	 *
	 * @author André Costa
	 * @since 24/10/2020
	 *
	 * @param user
	 * @return <code>User</code> object
	 */

	void save(User user) throws UserException;

	/**
	 * Method that remove a user by an id.
	 *
	 * @author André Costa
	 * @since 24/10/2020
	 *
	 * @param userId
	 * @throws UserException
	 */
	void deleteById(Long userId) throws UserException;

	/**
	 * Method that find a user by an id.
	 *
	 * @author André Costa
	 * @since 24/10/2020
	 *
	 * @param userId
	 * @return <code>Optional<User></code> object
	 */
	User findById(Long userId);

	/**
	 * Method that find all user.
	 *
	 * @author André Costa
	 * @since 24/10/2020
	 *
	 * @return <code>List<User></code> object
	 */
	List<User> findAll();
	
	/**
	 * Method that find users pending approval.
	 *
	 * @author André Costa
	 * @since 25/2021
	 *
	 * @return <code>List<User></code> object
	 */
	List<User> findUsersPendingApproval();
}
