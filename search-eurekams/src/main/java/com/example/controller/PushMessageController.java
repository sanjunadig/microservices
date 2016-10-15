package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SearchRabbitMQ;

@RestController
@CrossOrigin
public class PushMessageController {

	@Autowired
	private RabbitMessagingTemplate template;
	
	
	@RequestMapping(value="/send", method= RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void send(@RequestBody SearchRabbitMQ model){
		System.out.println(model);
		Map<String, Object> map = new HashMap<>();
		map.put("FLIGHT_NUMBER", model.getFlightNumber());
		map.put("FLIGHT_DATE", model.getFlightDate());
		map.put("NEW_INVENTORY", model.getNewInventory());
				
//		template.convertAndSend("inventoryQ",map);
		template.convertAndSend("inventoryQ",model);
	}
}



