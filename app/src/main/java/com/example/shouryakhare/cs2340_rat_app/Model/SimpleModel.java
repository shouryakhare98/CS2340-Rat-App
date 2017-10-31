package com.example.shouryakhare.cs2340_rat_app.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shouryakhare on 10/9/17.
 * Model containing all rat sightings.
 */

public class SimpleModel {
    public static final SimpleModel INSTANCE = new SimpleModel();

    private List<RatSighting> items;

    /**
     * Method to set array list.
     * @param items New list
     */
    private void setItems(List<RatSighting> items) { this.items = items; }

    private SimpleModel() {
        items = new ArrayList<>();
    }

    /**
     * Method to add a rat sighting to list.
     * @param item Item to add.
     */
    public void addItem(RatSighting item) {
        items.add(item);
    }

    /**
     * Method to get rat sighting list.
     * @return List of rat sightings.
     */
    public List<RatSighting> getItems() {
        return items;
    }

    /**
     * Method to reset rat sighting list.
     */
    public void reset() { INSTANCE.setItems(new ArrayList<RatSighting>()); }
}
