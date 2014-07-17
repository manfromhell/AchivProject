package com.ita.softserveinc.achiever.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ita.softserveinc.achiever.entity.Direction;
import com.ita.softserveinc.achiever.exception.ElementExistsException;
import com.ita.softserveinc.achiever.service.IDirectionService;

/**
 * 
 * @author Andriana
 *
 */
@Controller
public class DirectionController {

	@Autowired
	private IDirectionService directionService;
	
	private Direction editableDirection;

	@RequestMapping("/directions")
	public String listDirections(Map<String, Object> map) {
		map.put("directionList", directionService.findAll());
		return "direction/direction";
	}

	@RequestMapping("/newdirection")
	public String newDirection(Map<String, Object> map) {
		map.put("direction", new Direction());
		return "direction/newdirection";
	}

	public Direction getDirection(Map<String, Object> map) {
		Direction direction = new Direction();
		map.put("direction", direction);
		return direction;
	}

	@RequestMapping(value = "/addDirection", method = RequestMethod.POST)
	public String addDirection(@Valid @ModelAttribute("direction") Direction direction,
			BindingResult result) {
		if(result.hasErrors()) {
	    	return "direction/newdirection";
	    }
		try{
		directionService.create(direction);
		}catch(ElementExistsException e){
			result.rejectValue("name", "error.direction", "this direction already exists");
			return "direction/newdirection";
		}
		return "redirect:/directions";
	}

	@RequestMapping(value = "/direction/edit/{directionId}")
	public String editDirection(@PathVariable("directionId") Long id, Map<String, Object> map) {
		map.put("direction", directionService.findById(id));
		editableDirection = directionService.findById(id);
		return "direction/editdirection";
	}
	
	@RequestMapping(value = "/direction/edit/editDirection", method = RequestMethod.POST)
	public String editDirection2(@Valid @ModelAttribute("direction") Direction direction, BindingResult result) {
		if(result.hasErrors()) {
	    	return "direction/editdirection";
	    }
		if (direction.getName().equals(editableDirection.getName())){
			return "redirect:/directions";
		}
		try{
		editableDirection.setName(direction.getName());
		directionService.update(editableDirection);
		}catch(ElementExistsException e){
			result.rejectValue("name", "error.direction", "this direction already exists");
			return "direction/editdirection";
		}
		return "redirect:/directions";
	}

	@RequestMapping("/direction/delete/{directionId}")
	public String deleteDirection(@PathVariable("directionId") Long id) {
		Direction direction = directionService.findById(id);
		directionService.delete(direction);
		return "redirect:/directions";
	}

}
