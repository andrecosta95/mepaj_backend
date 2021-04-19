package com.mepaj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mepaj.model.Event;
import com.mepaj.model.User;
import com.mepaj.repository.EventRepository;
import com.mepaj.repository.UserRepository;
import com.mepaj.service.EventService;
import com.mepaj.util.Constants;
import com.mepaj.util.excepiton.EventException;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(Event event) throws EventException {
		
		Long idUser = event.getCreatedBy();
		
		User user = userRepository.findById(idUser).get();
		
		if (user.getProfile().getAccessLevel() != Constants.ADM
				&& user.getProfile().getIsActive() != true) {
			event.setStatus("Pedente Aprovação");
		}
		eventRepository.save(event);
	}

	@Override
	public void deleteById(Long eventId) throws EventException {
		if (eventRepository.existsById(eventId)) {
			eventRepository.deleteById(eventId);
		} else {
			throw new EventException("ID não pode ser excluido");
		}
	}

	@Override
	public Event findById(Long eventId) {
		return eventRepository.findById(eventId).get();
	}

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}
}
