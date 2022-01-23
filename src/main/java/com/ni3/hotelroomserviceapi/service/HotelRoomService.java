package com.ni3.hotelroomserviceapi.service;

import com.ni3.hotelroomserviceapi.model.AvailableHotel;
import com.ni3.hotelroomserviceapi.model.HotelRoom;

import java.util.List;

public interface HotelRoomService {
     List<HotelRoom> getAllRoom();
     HotelRoom getRoomByID(int roomId);
     AvailableHotel getBookableRoom();
     void addHotelRoom(HotelRoom room);
     void updateHotelRoom(int roomId , HotelRoom room);
     void deleteRoom(int roomId);
}
