package com.ni3.hotelroomserviceapi.service;

import com.ni3.hotelroomserviceapi.dao.HotelRoomRepo;
import com.ni3.hotelroomserviceapi.model.AvailableHotel;
import com.ni3.hotelroomserviceapi.model.HotelRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HotelRoomDBServiceImpl implements HotelRoomService{

    @Autowired
    private HotelRoomRepo hotelRoomRepo;


    public List<HotelRoom> getAllRoom(){
        List<HotelRoom> rooms = new ArrayList<>();
        hotelRoomRepo.findAll().forEach(rooms::add);
        return rooms;
    }

    public HotelRoom getRoomByID(int roomId){
        Optional<HotelRoom> room =  hotelRoomRepo.findById(roomId);
        return room.orElse(null);
    }

    public AvailableHotel getBookableRoom(){
        List<HotelRoom> optionalHotelRoom = getAllRoom().stream()
                .filter(HotelRoom::isAvailable)
                .collect(Collectors.toList());
        AvailableHotel availableHotel =  new AvailableHotel();
        availableHotel.setRoomList(optionalHotelRoom);
        return availableHotel;
    }

    public void addHotelRoom(HotelRoom room) {
        hotelRoomRepo.save(room);
    }

    public void updateHotelRoom(int roomId , HotelRoom room) {
        hotelRoomRepo.save(room);
    }

    public void deleteRoom(int roomId) {
       hotelRoomRepo.deleteById(roomId);
    }


}
