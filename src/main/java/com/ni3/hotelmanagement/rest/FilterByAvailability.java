package com.ni3.hotelmanagement.rest;

import com.ni3.hotelmanagement.model.HotelRoom;

import java.util.List;

public class FilterByAvailability implements Filter{
    @Override
    public List<HotelRoom> filter(List<HotelRoom> roomList) {
        return null;
    }

    // Filter room by reservor name. -> Customre Service
    // audit all of the operations coming from the controllers
}
