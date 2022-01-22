package com.ni3.hotelroomserviceapi.rest;

import com.ni3.hotelroomserviceapi.dao.HotelRoomDao;
import com.ni3.hotelroomserviceapi.model.HotelRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.OptionalInt;

@Component
public class CommonJ8 {

    @Autowired
    private HotelRoomDao hotelRoomDao;

    public void getSum(){
        List<HotelRoom> roomList=   hotelRoomDao.getRoomList();

        OptionalInt sum = roomList.stream()
                .mapToInt(HotelRoom::getPrice)
                .reduce(Integer::sum);


        OptionalInt avg =  roomList.stream()
                .mapToInt(HotelRoom::getPrice)
                .reduce(CommonJ8::avg);
    }

    private static int avg(int i, int i1) {
        return (i + i1)/2;
    }

}
