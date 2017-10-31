package com.example.shouryakhare.cs2340_rat_app.Model;

import java.io.Serializable;

/**
 * Created by shouryakhare on 10/9/17.
 * POJO representing a rat sighting.
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

    /*
    Constructors required.
     */
    public RatSighting() {}
    RatSighting(long uniqueKey, String createdDate, String locationType, long incidentZip,
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

    /*
    Getters and setters.
     */
    public long getUniqueKey() {
        return uniqueKey;
    }

    void setUniqueKey(long uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getLocationType() {
        return locationType;
    }

    public long getIncidentZip() {
        return incidentZip;
    }

    public String getIncidentAddress() {
        return incidentAddress;
    }

    public String getCity() {
        return city;
    }

    public String getBorough() {
        return borough;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String toString() {
        return uniqueKey + " " + createdDate + " " + city;
    }
}
