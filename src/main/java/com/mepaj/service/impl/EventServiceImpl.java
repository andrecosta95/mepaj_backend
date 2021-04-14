package com.mepaj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mepaj.model.Event;
import com.mepaj.repository.EventRepository;
import com.mepaj.service.EventService;
import com.mepaj.util.Constants;
import com.mepaj.util.excepiton.EventException;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository repository;

	@Override
	public void save(Event event) throws EventException {

		if (event.getTheme() == null || event.getStatus() == null) {
			throw new EventException("Evento não pode ser criado");
		} else {
			if (event.getCreatedBy().getProfile().getAccessLevel() != Constants.ADM
					&& event.getCreatedBy().getProfile().getIsActive() == true) {
				event.setStatus("Pedente Aprovação");
			}
			repository.save(event);
		}
	}

	@Override
	public void deleteById(Long eventId) throws EventException {
		if (repository.existsById(eventId)) {
			repository.deleteById(eventId);
		} else {
			throw new EventException("ID não pode ser excluido");
		}
	}

	@Override
	public Event findById(Long eventId) {
		return repository.findById(eventId).get();
	}

	@Override
	public List<Event> findAll() {
		return repository.findAll();
	}
}
