package communication;

import domain.Airplane;
import domain.Airport;
import domain.Coupon;
import domain.Flight;
import domain.Line;
import domain.Passenger;
import domain.Reservation;
import java.net.Socket;
import domain.User;
import java.util.List;

public class Communication {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;

    private Communication() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Communication getInstance() throws Exception {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public User login(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Request request = new Request(Operation.LOGIN, user);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (User) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void editFlight(Flight flight) throws Exception {
        Request request = new Request(Operation.CHANGE_FLIGHT, flight);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public void editReservation(Reservation reservation) throws Exception {
        Request request = new Request(Operation.CHANGE_RESERVATION, reservation);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public List<Flight> getAllFlights() throws Exception {
        Request request = new Request(Operation.RETURN_FLIGHTS_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Flight>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Airport> getAllAirports() throws Exception {
        Request request = new Request(Operation.RETURN_AIRPORTS_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Airport>) response.getResult();
        } else {
            System.out.println("Error");
            throw response.getException();
        }
    }

    public List<Airplane> getAllAirplanes() throws Exception {
        Request request = new Request(Operation.RETURN_AIRPLANES_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Airplane>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Line> getAllLines() throws Exception {
        Request request = new Request(Operation.RETURN_LINES_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Line>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Coupon> getAllCoupons() throws Exception {
        Request request = new Request(Operation.RETURN_COUPONS_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Coupon>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Passenger> getAllPassengers() throws Exception {
        Request request = new Request(Operation.RETURN_PASSENGERS_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Passenger>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Reservation> getAllReservations() throws Exception {
        Request request = new Request(Operation.RETURN_RESERVATIONS_ALL, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Reservation>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addFlight(Flight flight) throws Exception {
        Request request = new Request(Operation.ADD_FLIGHT, flight);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Flight newFlight = (Flight) response.getResult();
            flight.setId(newFlight.getFlightID());
        } else {
            throw response.getException();
        }
    }

    public void addPassenger(Passenger passenger) throws Exception {
        Request request = new Request(Operation.ADD_PASSENGER, passenger);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Passenger newPassenger = (Passenger) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void addReservation(Reservation reservation) throws Exception {
        Request request = new Request(Operation.ADD_RESERVATION, reservation);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Reservation newReservation = (Reservation) response.getResult();
            reservation.setReservationID(newReservation.getReservationID());
        } else {
            throw response.getException();
        }
    }

    public void deleteReservation(Reservation reservation) throws Exception {
        Request request = new Request(Operation.DELETE_RESERVATION, reservation);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public void deleteFlight(Flight flight) throws Exception {
        Request request = new Request(Operation.DELETE_FLIGHT, flight);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public List<Airport> searchAirports(Airport airport) throws Exception {
        Request request = new Request(Operation.SEARCH_AIRPORTS, airport);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Airport>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Airplane> searchAirplanes(Airplane airplane) throws Exception {
        Request request = new Request(Operation.SEARCH_AIRPLANES, airplane);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Airplane>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Line> searchLines(Line line) throws Exception {
        Request request = new Request(Operation.SEARCH_LINES, line);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Line>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Coupon> searchCoupons(Coupon coupon) throws Exception {
        Request request = new Request(Operation.SEARCH_COUPONS, coupon);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Coupon>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Flight> searchFlights(Flight flight) throws Exception {
        Request request = new Request(Operation.SEARCH_FLIGHTS, flight);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Flight>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Passenger> searchPassengers(Passenger passenger) throws Exception {
        Request request = new Request(Operation.SEARCH_PASSENGERS, passenger);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Passenger>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Reservation> searchReservations(Reservation reservation) throws Exception {
        Request request = new Request(Operation.SEARCH_RESERVATIONS, reservation);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Reservation>) response.getResult();
        } else {
            throw response.getException();
        }
    }

}
