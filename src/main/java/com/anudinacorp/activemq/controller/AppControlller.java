package com.anudinacorp.activemq.controller;
/**
 * 
 */

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anudinacorp.activemq.services.Producer;

/**
 * @author Anand
 *
 */
@Controller
@RequestMapping("/messageservice")
public class AppControlller {
	@Autowired
    Producer messageSender;
	 
	@RequestMapping(value = "/healthcheck", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String healthCheck() throws ApplicationException {
		return "Status:Service is alive";
	}

	
	@RequestMapping(value = "/sendmessage", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String startprocess(@RequestParam String message)
			throws Exception {
		messageSender.sendMessage(message);
        return "Stringsuccess";
	}
	     
}
