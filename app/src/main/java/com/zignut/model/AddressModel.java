package com.zignut.model;

import java.util.ArrayList;

/**
 * Created by Lenovo on 18-03-2018.
 */

public class AddressModel {

    private String id;
    private String tripNmae;
    private String tripSrcAddress;
    private String tripDestAddress;
    private String tripStartDate;
    private String tripEndDate;
    private String tripSrcLat;
    private String tripSrclong;
    private String tripDestLat;
    private String tripDestlong;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTripNmae() {
        return tripNmae;
    }

    public void setTripNmae(String tripNmae) {
        this.tripNmae = tripNmae;
    }

    public String getTripSrcAddress() {
        return tripSrcAddress;
    }

    public void setTripSrcAddress(String tripSrcAddress) {
        this.tripSrcAddress = tripSrcAddress;
    }

    public String getTripDestAddress() {
        return tripDestAddress;
    }

    public void setTripDestAddress(String tripDestAddress) {
        this.tripDestAddress = tripDestAddress;
    }

    public String getTripStartDate() {
        return tripStartDate;
    }

    public void setTripStartDate(String tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    public String getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(String tripEndDate) {
        this.tripEndDate = tripEndDate;
    }

    public String getTripSrcLat() {
        return tripSrcLat;
    }

    public void setTripSrcLat(String tripSrcLat) {
        this.tripSrcLat = tripSrcLat;
    }

    public String getTripSrclong() {
        return tripSrclong;
    }

    public void setTripSrclong(String tripSrclong) {
        this.tripSrclong = tripSrclong;
    }

    public String getTripDestLat() {
        return tripDestLat;
    }

    public void setTripDestLat(String tripDestLat) {
        this.tripDestLat = tripDestLat;
    }

    public String getTripDestlong() {
        return tripDestlong;
    }

    public void setTripDestlong(String tripDestlong) {
        this.tripDestlong = tripDestlong;
    }

    public static ArrayList<AddressModel> getDummyData() {

        ArrayList<AddressModel> addressModelArrayList = new ArrayList<>(10);

        // AddressModel addressModel = new AddressModel();
        for (int i = 0; i <= 10; i++) {

            AddressModel addressModel = new AddressModel();
            addressModel.setId(String.valueOf(i));
            addressModel.setTripNmae("Abu with freind");
            addressModel.setTripSrcAddress("Ahmedabad ,paldi");
            addressModel.setTripDestAddress("Abu raod");
            addressModel.setTripStartDate("13 march 2018");
            addressModel.setTripEndDate("16 march 2018");
            addressModel.setTripSrcLat("23.0089785");
            addressModel.setTripSrclong("72.5398136");
            addressModel.setTripDestLat("23.2206942");
            addressModel.setTripDestlong("72.5755072");
            addressModelArrayList.add(addressModel);
        }


        return addressModelArrayList;
    }
}
