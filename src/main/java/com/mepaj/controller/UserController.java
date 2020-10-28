package com.mepaj.controller;

import com.mepaj.model.User;
import com.mepaj.repository.UserRepository;
import com.mepaj.service.UserService;
import com.mepaj.util.excepiton.UserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@PostMapping(path = "/save")
	public ResponseEntity<User> create(@Valid @RequestBody User user) throws UserException {
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		if (userService.findAll().get(0) != null) {
			List<User> users = userService.findAll();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(path = "/find/{id}")
	public ResponseEntity<User> findById(@PathVariable(value = "id") long id) {
		User user = userService.findById(id);

		if (user.getId() != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable(value = "id") long id) throws UserException {
		User user = userService.findById(id);

		if (user.getId() != null) {
			userService.deleteById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
