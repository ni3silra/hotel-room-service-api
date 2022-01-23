package com.ni3.hotelroomserviceapi;

import com.ni3.hotelroomserviceapi.service.HotelRoomDBServiceImpl;
import com.ni3.hotelroomserviceapi.service.HotelRoomService;
import com.ni3.hotelroomserviceapi.service.HotelRoomServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan
public class HotelRoomServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRoomServiceApiApplication.class, args);
	}


	@Bean(name="dbService")
	public HotelRoomService getHotelRoomDBService() {
		return new HotelRoomDBServiceImpl();
	}

	@Bean(name="service")
	public HotelRoomService getHotelRoomService() {
		return new HotelRoomServiceImpl();
	}

}
