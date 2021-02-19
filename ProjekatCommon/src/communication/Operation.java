/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Marija
 */
public enum Operation implements Serializable{
    LOGIN, 
    LOGOUT,
    SEARCH_AIRPORTS,
    RETURN_AIRPORTS_ALL,
    SEARCH_LINES,
    RETURN_LINES_ALL,
    SEARCH_AIRPLANES,
    RETURN_AIRPLANES_ALL,
    ADD_FLIGHT,
    CHANGE_FLIGHT,
    SEARCH_FLIGHTS,
    DELETE_FLIGHT,
    RETURN_FLIGHTS_ALL,
    SEARCH_COUPONS,
    RETURN_COUPONS_ALL,
    ADD_PASSENGER,
    SEARCH_PASSENGERS,
    RETURN_PASSENGERS_ALL,
    ADD_RESERVATION,
    CHANGE_RESERVATION,
    SEARCH_RESERVATIONS,
    DELETE_RESERVATION,
    RETURN_RESERVATIONS_ALL
}
