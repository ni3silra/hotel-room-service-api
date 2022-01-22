package com.ni3.hotelroomserviceapi.rest;

import com.ni3.hotelroomserviceapi.model.HotelRoom;

import java.util.List;

public interface Filter {
    List<HotelRoom> filter(List<HotelRoom> roomList);
}
