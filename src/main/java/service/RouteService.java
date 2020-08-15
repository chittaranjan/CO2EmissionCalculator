package service;

import exception.InvalidApiKeyException;
import model.City;
import model.Profile;

public interface RouteService {
    /**
     * Get the geocode of the city with given name
     * Return the city model with geometry and bounding box
     * @param cityName
     * @return city
     */
    City geoCode(String cityName) throws InvalidApiKeyException;

    /**
     * Computes the distance between 2 given cities using the given profile
     * @param city1
     * @param city2
     * @param profile
     * @return
     */
    Double getDistanceWithProfile(City city1, City city2, Profile profile) throws InvalidApiKeyException;

    /**
     * Computes distance between 2 cities with default profile i.e. DRIVING_CAR
     * @param city1
     * @param city2
     * @return
     */
    Double getDistance(City city1, City city2) throws InvalidApiKeyException;
}
