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

    /**
     * No arg constructor for compilation.
     */
    public RatSighting() {}

    /**
     * Multi arg constructor for initialization.
     * @param uniqueKey Unique key
     * @param createdDate Date created
     * @param locationType Location Type
     * @param incidentZip Zip
     * @param incidentAddress Address
     * @param city City
     * @param borough Borough
     * @param longitude Longitude
     * @param latitude Latitude
     */
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

    /**
     * Unique key getter
     * @return unique key
     */
    public long getUniqueKey() {
        return uniqueKey;
    }

    /**
     * Unique key setter
     * @param uniqueKey Key
     */
    void setUniqueKey(long uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    /**
     * Created date getter
     * @return Date
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Location Type getter
     * @return Location type getter
     */
    public String getLocationType() {
        return locationType;
    }

    /**
     * Zip getter
     * @return Zip
     */
    public long getIncidentZip() {
        return incidentZip;
    }

    /**
     * Address getter
     * @return Address
     */
    public String getIncidentAddress() {
        return incidentAddress;
    }

    /**
     * City getter
     * @return City
     */
    public String getCity() {
        return city;
    }

    /**
     * Borough getter
     * @return Borough
     */
    public String getBorough() {
        return borough;
    }

    /**
     * Longitude getter
     * @return Longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Latitude getter
     * @return Latitude
     */
    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return uniqueKey + " " + createdDate + " " + city;
    }
}
