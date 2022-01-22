package com.ni3.hotelmanagement.rest;

import com.ni3.hotelmanagement.dao.HotelRoomDao;
import com.ni3.hotelmanagement.model.HotelRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonJ8 {

    @Autowired
    private HotelRoomDao hotelRoomDao;

    public void getSum(){
        List<HotelRoom> roomList=   hotelRoomDao.getRoomList();

        int sum = roomList.stream()
                .mapToInt(HotelRoom::getPrice)
                .reduce(Integer::sum).getAsInt();


        int avg =  roomList.stream()
                .mapToInt(HotelRoom::getPrice)
                .reduce(CommonJ8::avg).getAsInt();
    }

    private static int avg(int i, int i1) {
        return (i + i1)/2;
    }

}
