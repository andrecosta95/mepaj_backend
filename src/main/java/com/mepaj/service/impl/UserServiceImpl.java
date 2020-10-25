package com.mepaj.service.impl;

import com.mepaj.model.User;
import com.mepaj.repository.UserRepository;
import com.mepaj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public User findById(Long userId) {
        return repository.findById(userId).get();
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

}
