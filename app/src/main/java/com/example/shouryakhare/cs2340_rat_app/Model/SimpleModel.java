package com.example.shouryakhare.cs2340_rat_app.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shouryakhare on 10/9/17.
 * Model containing all rat sightings.
 */

public class SimpleModel {
    public static final SimpleModel INSTANCE = new SimpleModel();

    private List<RatSighting> items;

    private SimpleModel() {
        items = new ArrayList<>();
    }

    public void addItem(RatSighting item) {
        items.add(item);
    }

    public List<RatSighting> getItems() {
        return items;
    }

    public void setItems(List<RatSighting> items) { this.items = items; }

    public void reset() { INSTANCE.setItems(new ArrayList<RatSighting>()); }

    public RatSighting findItemById(long id) {
        for (RatSighting d : items) {
            if (d.getUniqueKey() == id) return d;
        }
        Log.d("MYAPP", "Warning - Failed to find id: " + id);
        return null;
    }
}
