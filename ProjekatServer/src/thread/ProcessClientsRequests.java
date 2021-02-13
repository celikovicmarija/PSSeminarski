/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import communication.Operation;
import static communication.Operation.LOGIN;
import java.net.Socket;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.Airplane;
import domain.Airport;
import domain.Coupon;
import domain.Flight;
import domain.GenericEntity;
import domain.Line;
import domain.Passenger;
import domain.Reservation;
import domain.User;

public class ProcessClientsRequests extends Thread {

    private Socket socket;
    Sender sender;
    Receiver receiver;
    boolean end = true;
    User user;

    public ProcessClientsRequests(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Request request = (Request) receiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOGIN:
                            User u = (User) request.getArgument();
                            response.setResult(Controller.getInstance().login(u.getUsername(), u.getPassword()));
                            user = u;
                            break;
                        case RETURN_AIRPLANES_ALL:
                            response.setResult(Controller.getInstance().getAllAirplanes(new Airplane()));
                            break;
                        case RETURN_AIRPORTS_ALL:
                            response.setResult(Controller.getInstance().getAllAirports(new Airport()));
                            break;
                        case RETURN_LINES_ALL:
                            response.setResult(Controller.getInstance().getAllLines(new Line()));
                            break;
                        case RETURN_COUPONS_ALL:
                            response.setResult(Controller.getInstance().getAllCoupons(new Coupon()));
                            break;
                        case RETURN_PASSENGERS_ALL:
                            response.setResult(Controller.getInstance().getAllPassengers(new Passenger()));
                            break;
                        case RETURN_RESERVATIONS_ALL:
                            response.setResult(Controller.getInstance().getAllReservations(new Reservation()));
                            break;
                        case RETURN_FLIGHTS_ALL:
                            response.setResult(Controller.getInstance().getAllFlights(new Flight()));
                            break;
                        case ADD_FLIGHT:
                            GenericEntity flightInsert = (GenericEntity) request.getArgument();
                            Controller.getInstance().addFlight(flightInsert);
                            response.setResult(flightInsert);
                            break;
                        case ADD_PASSENGER:
                            GenericEntity passengerInsert = (GenericEntity) request.getArgument();
                            Controller.getInstance().addPassenger(passengerInsert);
                            response.setResult(passengerInsert);
                            break;
                        case ADD_RESERVATION:
                            GenericEntity reservationInsert = (GenericEntity) request.getArgument();
                            Controller.getInstance().addReservation(reservationInsert);
                            response.setResult(reservationInsert);
                            break;
                        case DELETE_FLIGHT:
                            GenericEntity flightDelete = (GenericEntity) request.getArgument();
                            Controller.getInstance().deleteFlight(flightDelete);
                            break;
                        case DELETE_RESERVATION:
                            GenericEntity reservationDelete = (GenericEntity) request.getArgument();
                            Controller.getInstance().deleteReservation(reservationDelete);
                            break;
                        case CHANGE_FLIGHT:
                            GenericEntity flightEdit = (GenericEntity) request.getArgument();
                            Controller.getInstance().editFlight(flightEdit);
                            break;
                        case CHANGE_RESERVATION:
                            GenericEntity reservationEdit = (GenericEntity) request.getArgument();
                            Controller.getInstance().editReservation(reservationEdit);
                            break;
                        case SEARCH_AIRPLANES:
                            GenericEntity airplaneSearch = (GenericEntity) request.getArgument();
                            response.setResult(Controller.getInstance().searchAirplanes(airplaneSearch));
                            break;
                        case SEARCH_AIRPORTS:
                            GenericEntity airportSearch = (GenericEntity) request.getArgument();
                            response.setResult(Controller.getInstance().searchAirports(airportSearch));
                            break;
                        case SEARCH_COUPONS:
                            GenericEntity couponSearch = (GenericEntity) request.getArgument();
                            response.setResult(Controller.getInstance().searchCoupons(couponSearch));
                            break;
                        case SEARCH_PASSENGERS:
                            GenericEntity passengerSearch = (GenericEntity) request.getArgument();
                            response.setResult(Controller.getInstance().searchPassengers(passengerSearch));
                            break;
                        case SEARCH_LINES:
                            GenericEntity linetSearch = (GenericEntity) request.getArgument();
                            response.setResult(Controller.getInstance().searchLines(linetSearch));
                            break;
                        case SEARCH_FLIGHTS:
                            GenericEntity flightSearch = (GenericEntity) request.getArgument();
                            response.setResult(Controller.getInstance().searchFlights(flightSearch));

                            break;
                        case SEARCH_RESERVATIONS:
                            GenericEntity reservationSearch = (GenericEntity) request.getArgument();
                            response.setResult(Controller.getInstance().searchReservations(reservationSearch));
                            break;
                    }
                } catch (Exception e) {
                    // e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
            } catch (Exception ex) {
                //   Logger.getLogger(ProcessClientsRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void logoutEverybody() {
        try {
            end = true;

            Request request = new Request(Operation.LOGOUT, null);
            sender.send(request);

        } catch (Exception ex) {
            System.out.println("Greska pri logoutovanju prijavljenih korisnika");
        }
    }
}
