package com.ni3.hotelroomserviceapi.dao;

import com.ni3.hotelroomserviceapi.model.HotelRoom;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class HotelRoomDao {

    List<HotelRoom> roomList;

    @PostConstruct
    public void fillHotelRoomDB() {
        int[] ids = {101, 102, 103, 104, 105};
        int[] prices = {1370, 1260, 1890, 2100, 5000};
        boolean[] isAvailable = {false, true, false, true, true};

        roomList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            HotelRoom room = HotelRoom.newBuilder()
                    .setHotelId(ids[i])
                    .setPrice(prices[i])
                    .setAvailable(isAvailable[i])
                    .build();
            roomList.add(room);
        }
    }

    public List<HotelRoom> getRoomList() {
        return roomList;
    }
}
