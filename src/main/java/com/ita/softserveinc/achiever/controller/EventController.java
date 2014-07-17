package com.ita.softserveinc.achiever.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ita.softserveinc.achiever.entity.Event;
import com.ita.softserveinc.achiever.exception.ElementExistsException;
import com.ita.softserveinc.achiever.service.IEventService;

@Controller
public class EventController {

	@Autowired
	private IEventService eventService;

	/**
	 * @param map
	 * @return schedules
	 */
	@RequestMapping("/event")
	public String listEvents(Map<String, Object> map) {
		map.put("event", new Event());
		map.put("eventList", eventService.findAll());
		return "event";
	}

	@RequestMapping(value = "/events/add", method = RequestMethod.POST)
	public String addEvent(@ModelAttribute("event") Event event,
			BindingResult result) {
		try {
			eventService.create(event);
		} catch (ElementExistsException e) {
			e.printStackTrace();
		}
		return "redirect:/event";
	}
	
	@RequestMapping(value = "/event/edit/${eventId}")
	public String editEvent(@PathVariable("eventId") Long id) {
		Event event = eventService.findById(id);
		try {
			eventService.update(event);
		} catch (ElementExistsException e) {
			e.printStackTrace();
		}
		return "redirect:/event";
		
		
	}

	@RequestMapping("/event/delete/{eventId}")
	public String deleteEvent(@PathVariable("eventId") Long id) {
		Event event = eventService.findById(id);
		eventService.delete(event);
		return "redirect:/event";
	}
}
