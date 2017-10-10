package com.example.shouryakhare.cs2340_rat_app.Model;

import java.io.Serializable;

/**
 * Created by shouryakhare on 10/9/17.
 */

public class RatSighting implements Serializable {

    private long uniqueKey;
    private String createdDate;
    private String locationType;
    private long incidentZip;
    private String incidentAddress;
    private String city;
    private String borough;
    private double longitude;
    private double latitude;

    public RatSighting() {}
    public RatSighting(long uniqueKey, String createdDate, String locationType, long incidentZip,
                       String incidentAddress, String city, String borough, double longitude,
                       double latitude) {
        this.uniqueKey = uniqueKey;
        this.createdDate = createdDate;
        this.locationType = locationType;
        this.incidentZip = incidentZip;
        this.incidentAddress = incidentAddress;
        this.city = city;
        this.borough = borough;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(long uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public long getIncidentZip() {
        return incidentZip;
    }

    public void setIncidentZip(long incidentZip) {
        this.incidentZip = incidentZip;
    }

    public String getIncidentAddress() {
        return incidentAddress;
    }

    public void setIncidentAddress(String incidentAddress) {
        this.incidentAddress = incidentAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String toString() {
        return uniqueKey + " " + createdDate + " " + city;
    }
}
