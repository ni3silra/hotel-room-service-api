package com.ni3.hotelroomserviceapi.service;

import com.ni3.hotelroomserviceapi.dao.HotelRoomDao;
import com.ni3.hotelroomserviceapi.dao.HotelRoomRepo;
import com.ni3.hotelroomserviceapi.model.AvailableHotel;
import com.ni3.hotelroomserviceapi.model.HotelRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelRoomServiceImpl implements HotelRoomService{

    @Autowired
    private HotelRoomDao hotelRoomDB;

    private List<HotelRoom> roomList;

    @PostConstruct
    public void setData(){
        roomList = hotelRoomDB.getRoomList();
    }

    public List<HotelRoom> getAllRoom(){
       return roomList;
    }

    public HotelRoom getRoomByID(int roomId){
        Optional<HotelRoom> optionalHotelRoom =
                 roomList.stream()
                .filter(room -> room.getHotelId()==roomId)
                .findFirst();
        return optionalHotelRoom.orElse(null);
    }

    public AvailableHotel getBookableRoom(){
        List<HotelRoom> optionalHotelRoom = roomList.stream()
                .filter(HotelRoom::isAvailable)
                .collect(Collectors.toList());
        AvailableHotel availableHotel =  new AvailableHotel();
        availableHotel.setRoomList(optionalHotelRoom);
                return availableHotel;
    }


    public void addHotelRoom(HotelRoom room) {
        roomList.add(room);
    }

    public void updateHotelRoom(int roomId , HotelRoom room) {
        for(HotelRoom room1 : roomList){
            if(roomId == room1.getHotelId()){
                room1.setAvailable(room.isAvailable());
                room1.setPrice(room.getPrice());
            }
        }
    }

    public void deleteRoom(int roomId) {
       /* for(int i = 0; i< roomList.size();i++){
            if(roomId == roomList.get(i).getHotelId()){
                roomList.remove(i);
                return;
            }
        }*/
        roomList.removeIf(room -> room.getHotelId() == roomId);
    }
}
