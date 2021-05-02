package com.mepaj.service.impl;

import com.mepaj.model.User;
import com.mepaj.repository.UserRepository;
import com.mepaj.service.UserService;
import com.mepaj.util.excepiton.UserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public void save(User user) throws UserException {
		repository.save(user);
	}
	
	@Override
	public void deleteById(Long userId) throws UserException {
		if (repository.existsById(userId)) {
			repository.deleteById(userId);
		} else {
			throw new UserException("ID não pode ser excluido");
		}
	}

	@Override
	public User findById(Long userId) {
		return repository.findById(userId).get();
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public List<User> findUsersPendingApproval() {
		return repository.findUsersPendingApproval();
	}
	
}
