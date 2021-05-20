package com.ksk.LinkedinSpringboot;

import com.ksk.LinkedinSpringboot.business.service.ReservationService;
import com.ksk.LinkedinSpringboot.data.RoomRepository;
import com.ksk.LinkedinSpringboot.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LinkedinSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedinSpringbootApplication.class, args);
	}




}
