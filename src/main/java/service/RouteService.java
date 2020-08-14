package service;

import model.City;
import model.Profile;

public interface RouteService {
    /**
     * Get the geocode of the city with given name
     * Return the city model with geometry and bounding box
     * @param cityName
     * @return city
     */
    City geoCode(String cityName);

    /**
     * Computes the distance between 2 given cities using the given profile
     * @param city1
     * @param city2
     * @param profile
     * @return
     */
    double getDistance(City city1, City city2, Profile profile);
}
