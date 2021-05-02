package com.mepaj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mepaj.model.Event;
import com.mepaj.service.EventService;
import com.mepaj.util.excepiton.EventException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Event")
@RestController()
@RequestMapping("/events")
public class EventController {

	@Autowired
	EventService eventService;

	@ApiOperation(value = "Cadastra evento")
	@PostMapping(path = "/save")
	public ResponseEntity<Event> create(@Valid @RequestBody Event Event) throws EventException {
		eventService.save(Event);
		return new ResponseEntity<>(Event, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Busca todos evento cadastrados")
	@GetMapping
	public ResponseEntity<List<Event>> findAll() {
		if (!eventService.findAll().isEmpty()) {
			List<Event> Events = eventService.findAll();
			return new ResponseEntity<List<Event>>(Events, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "Busca evento cadastrados por id")
	@GetMapping(path = "/find/{id}")
	public ResponseEntity<Event> findById(@PathVariable(value = "id") long id) {
		Event Event = eventService.findById(id);

		if (Event.getId() != null) {
			return new ResponseEntity<Event>(Event, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Altera evento cadasdtrado")
	@PostMapping(path = "/alter")
	public ResponseEntity<Event> alter(@Valid @RequestBody Event Event) throws EventException {
		eventService.save(Event);
		return new ResponseEntity<>(Event, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Deleta evento cadastrados por id")
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Event> delete(@PathVariable(value = "id") long id) throws EventException {
		Event Event = eventService.findById(id);

		if (Event.getId() != null) {
			eventService.deleteById(id);
			return new ResponseEntity<Event>(Event, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Busca todos eventos pedentes de aprovação")
	@GetMapping(path = "/findEventsPendingApproval")
	public ResponseEntity<List<Event>> findEventsPendingApproval() {
		if (!eventService.findAll().isEmpty()) {
			List<Event> events = eventService.findEventsPendingApproval();
			return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
