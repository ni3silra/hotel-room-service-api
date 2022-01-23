package com.ni3.hotelroomserviceapi.controller;

import com.ni3.hotelroomserviceapi.model.AvailableHotel;
import com.ni3.hotelroomserviceapi.model.HotelRoom;
import com.ni3.hotelroomserviceapi.service.HotelRoomService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class HotelRoomController {
    @Autowired
    @Qualifier("dbService")
    private HotelRoomService hotelRoomService; // need abstraction // swagger

    @GetMapping("/all")
    public List<HotelRoom> getAllRoom() {
        return hotelRoomService.getAllRoom();
    }

    @GetMapping("/{roomId}")
    @ApiOperation(value = "Find HotelRoom By Id",
            notes = "Provide an id to lookup specific HotelRoom",
            response = HotelRoom.class)
    public HotelRoom getRoomByID(@ApiParam(value = "Id Value for the contact you need to retrieve", required = true)
                                 @PathVariable int roomId) {
        return hotelRoomService.getRoomByID(roomId);
    }

    @GetMapping("/available")
    public AvailableHotel getBookableRoom() {
        return hotelRoomService.getBookableRoom();
    }

    @PostMapping("/add")
    public void addHotelRoom(@RequestBody HotelRoom room) {
        hotelRoomService.addHotelRoom(room);
    }

    @PutMapping("/update/{roomId}")
    public void updateRoom(@RequestBody HotelRoom room, @PathVariable int roomId) {
        hotelRoomService.updateHotelRoom(roomId, room);
    }

    @DeleteMapping("/delete/{roomId}")
    public void deleteRoom(@PathVariable int roomId) {
        hotelRoomService.deleteRoom(roomId);
    }

}
