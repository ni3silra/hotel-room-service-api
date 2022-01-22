package com.ni3.hotelroomserviceapi.model;

import java.util.List;

public class AvailableHotel {
    List<HotelRoom> roomList;

    public List<HotelRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<HotelRoom> roomList) {
        this.roomList = roomList;
    }
}
