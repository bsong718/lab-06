package com.example.listytcity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (hasCity(city)) {
            throw new IllegalArgumentException("City already exists in the list.");
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities; // create a copy
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether the given city exists in the list.
     * Uses compareTo() == 0 to determine equality so it works
     * even if equals()/hashCode() are not overridden.
     * @param city the city to look for
     * @return true if the city exists, false otherwise
     */
    public boolean hasCity(City city) {
        if (city == null) return false;
        for (City c : cities) {
            if (c.compareTo(city) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a city from the list if it exists,
     * otherwise throws an exception.
     * Uses compareTo() == 0 for matching.
     * @param city the city to delete
     */
    public void delete(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City to delete cannot be null.");
        }
        Iterator<City> it = cities.iterator();
        while (it.hasNext()) {
            City c = it.next();
            if (c.compareTo(city) == 0) {
                it.remove();
                return;
            }
        }
        throw new IllegalArgumentException("City not found in the list.");
    }

    /**
     * Returns the total number of cities in the list
     * @return the number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
