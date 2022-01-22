package com.ni3.hotelmanagement.rest;

import com.ni3.hotelmanagement.model.HotelRoom;

import java.util.List;

public interface Filter {
    List<HotelRoom> filter(List<HotelRoom> roomList);
}
