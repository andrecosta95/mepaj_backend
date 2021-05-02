package com.mepaj.controller;

import com.mepaj.model.User;
import com.mepaj.service.UserService;
import com.mepaj.util.excepiton.UserException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "User")
@RestController()
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Cadastra usuário")
	@PostMapping(path = "/save")
	public ResponseEntity<User> create(@Valid @RequestBody User user) throws UserException {
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Busca todos usuário cadastrados")
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		if (!userService.findAll().isEmpty()) {
			List<User> users = userService.findAll();
			return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Busca usuários cadastrados por id")
	@GetMapping(path = "/find/{id}")
	public ResponseEntity<User> findById(@PathVariable(value = "id") long id) {
		User user = userService.findById(id);

		if (user.getId() != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Altera usuário cadastrado")
	@PutMapping(path = "/alter")
	public ResponseEntity<User> alter(@RequestBody User user) throws UserException {
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta usuário cadastrados por id")
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

	@ApiOperation(value = "Busca todos usuários pedentes de aprovação")
	@GetMapping(path = "/findUsersPendingApproval")
	public ResponseEntity<List<User>> findUsersPendingApproval() {
		if (!userService.findAll().isEmpty()) {
			List<User> users = userService.findUsersPendingApproval();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
