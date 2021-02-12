/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public enum Operation  implements Serializable{
    LOGIN, //   ProveriPodatke
    LOGOUT,
    ADD_AIRPORT,
    CHANGE_AIRPORT,
    SEARCH_AIRPORTS,
    RETURN_AIRPORTS_ALL,
    DELETE_AIRPORT,
    ADD_LINE,
    CHANGE_LINE,
    SEARCH_LINES,
    RETURN_LINES_ALL,
    DELETE_LINE,
    ADD_AIRPLANE,
    CHANGE_AIRPLANE,
    SEARCH_AIRPLANES,
    DELETE_AIRPLANE,
    RETURN_AIRPLANES_ALL,
    ADD_FLIGHT,
    CHANGE_FLIGHT,
    SEARCH_FLIGHTS,
    DELETE_FLIGHT,
    RETURN_FLIGHTS_ALL,
    ADD_COUPON,
    CHANGE_COUPON,
    SEARCH_COUPONS,
    DELETE_COUPON,
    RETURN_COUPONS_ALL,
    ADD_PASSENGER,
    CHANGE_PASSENGER,
    SEARCH_PASSENGERS,
    DELETE_PASSENGER,
    RETURN_PASSENGERS_ALL,
    ADD_RESERVATION,
    CHANGE_RESERVATION,
    SEARCH_RESERVATIONS,
    DELETE_RESERVATION,
    RETURN_RESERVATIONS
}
