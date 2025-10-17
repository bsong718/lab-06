package com.example.listytcity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
    // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
    // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
    // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City existing = mockCity();
        City notExisting = new City("Toronto", "Ontario");

        // Should return true for existing city
        assertTrue(cityList.hasCity(existing));

        // Should return false for non-existing city
        assertFalse(cityList.hasCity(notExisting));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City existing = mockCity();

        // Should remove the existing city
        cityList.delete(existing);
        assertFalse(cityList.hasCity(existing));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        City city2 = new City("Regina", "Saskatchewan");
        City city3 = new City("Calgary", "Alberta");

        cityList.add(city2);
        cityList.add(city3);

        assertEquals(3, cityList.countCities());
    }
}