package com.example.listytcity;

/**
 * This is a class that defines a City
 */
public class City implements Comparable<City>{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    String getCityName(){
        return this.city;
    }
    String getProvinceName(){
        return this.province;
    }

    /**
    * Compares this city object to another city for ordering.
    * @param o
    * @return a integer as this city's name to compare to the specified city's name
    */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}
