package com.ni3.hotelroomserviceapi.dao;

import com.ni3.hotelroomserviceapi.model.HotelRoom;
import org.springframework.data.repository.CrudRepository;

public interface HotelRoomRepo extends CrudRepository<HotelRoom, Integer> {

}
