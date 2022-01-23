package com.ni3.hotelroomserviceapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@ApiModel(description = "Details About Hotel Room")
public class HotelRoom {

    @Id
    @ApiModelProperty(notes = "The unique id of hotel room")
    private int hotelId;

    @Column
    @ApiModelProperty(notes = "price of hotel room")
    private int price;

    @Column
    @ApiModelProperty(notes = "Hotel room availability flag")
    private boolean isAvailable;

    public static HotelRoom newBuilder(){
        return new HotelRoom();
    }

    public int getHotelId() {
        return hotelId;
    }

    public HotelRoom setHotelId(int hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public HotelRoom setPrice(int price) {
        this.price = price;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public HotelRoom setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    public HotelRoom build(){
        return this;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "hotelId=" + hotelId +
                ", price=" + price +
                '}';
    }
}
