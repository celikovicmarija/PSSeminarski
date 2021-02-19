package communication;

import config.ServerProperties;
import domain.Airplane;
import domain.Airport;
import domain.Coupon;
import domain.Flight;
import domain.Line;
import domain.Passenger;
import domain.Reservation;
import java.net.Socket;
import domain.User;
import exception.CommunicationException;
import java.io.IOException;
import java.net.SocketException;
import java.util.List;

public class Communication {

    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;
    int port;
    String url;

    private Communication() throws Exception {
        loadData();
        socket = new Socket(url, port);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public static Communication getInstance() throws Exception {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    private void loadData() {
        try {
            ServerProperties sp = new ServerProperties();
            port = Integer.parseInt(sp.returnServerPort());
            url = sp.returnServerURL();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public User login(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Request request = new Request(Operation.LOGIN, user);
        try {
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (User) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public void logout(User u) throws Exception {
        Request request = new Request(Operation.LOGOUT, u);

        try {
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                // return (User) response.getResult();
            } else {
                throw response.getException();
            }
        } catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public void editFlight(Flight flight) throws Exception {
        Request request = new Request(Operation.CHANGE_FLIGHT, flight);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
        } catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

        

    }

    public void editReservation(Reservation reservation) throws Exception {
        Request request = new Request(Operation.CHANGE_RESERVATION, reservation);
        try{
               sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
        }catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
     
    }

    public List<Flight> getAllFlights() throws Exception {
        Request request = new Request(Operation.RETURN_FLIGHTS_ALL, null);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (List<Flight>) response.getResult();
        } else {
            throw response.getException();
        }
        }catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
     

    }


    public List<Airplane> getAllAirplanes() throws Exception {
        Request request = new Request(Operation.RETURN_AIRPLANES_ALL, null);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Airplane>) response.getResult();
        } else {
            throw response.getException();
        }
        }catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public List<Line> getAllLines() throws Exception {
        Request request = new Request(Operation.RETURN_LINES_ALL, null);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Line>) response.getResult();
        } else {
            throw response.getException();
        }
        }
        catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public List<Coupon> getAllCoupons() throws Exception {
        Request request = new Request(Operation.RETURN_COUPONS_ALL, null);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Coupon>) response.getResult();
        } else {
            throw response.getException();
        }
        } catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public List<Passenger> getAllPassengers() throws Exception {
        Request request = new Request(Operation.RETURN_PASSENGERS_ALL, null);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Passenger>) response.getResult();
        } else {
            throw response.getException();
        }
        }
 catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public List<Reservation> getAllReservations() throws Exception {
        Request request = new Request(Operation.RETURN_RESERVATIONS_ALL, null);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Reservation>) response.getResult();
        } else {
            throw response.getException();
        }
        } catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public void addFlight(Flight flight) throws Exception {
        Request request = new Request(Operation.ADD_FLIGHT, flight);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Flight newFlight = (Flight) response.getResult();
            flight.setId(newFlight.getFlightID());
        } else {
            throw response.getException();
        }
        }catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public void addPassenger(Passenger passenger) throws Exception {
        Request request = new Request(Operation.ADD_PASSENGER, passenger);
        try{
            sender.send(request);
            Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Passenger newPassenger = (Passenger) response.getResult();
        } else {
            throw response.getException();
        }
        }catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
        
    }

    public void addReservation(Reservation reservation) throws Exception {
        Request request = new Request(Operation.ADD_RESERVATION, reservation);
        try{
                 sender.send(request);
        
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            Reservation newReservation = (Reservation) response.getResult();
            reservation.setReservationID(newReservation.getReservationID());
        } else {
            throw response.getException();
        }
        }catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
   
    }

    public void deleteReservation(Reservation reservation) throws Exception {
        Request request = new Request(Operation.DELETE_RESERVATION, reservation);
        try{
            sender.send(request);
                    Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
        }

        catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
    }

    public void deleteFlight(Flight flight) throws Exception {
        Request request = new Request(Operation.DELETE_FLIGHT, flight);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
        }    catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }



    public List<Airplane> searchAirplanes(Airplane airplane) throws Exception {
        Request request = new Request(Operation.SEARCH_AIRPLANES, airplane);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Airplane>) response.getResult();
        } else {
            throw response.getException();
        }
        }     catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public List<Line> searchLines(Line line) throws Exception {
        Request request = new Request(Operation.SEARCH_LINES, line);
        try{
                   sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Line>) response.getResult();
        } else {
            throw response.getException();
        } 
        }
     catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
    }

    public List<Coupon> searchCoupons(Coupon coupon) throws Exception {
        Request request = new Request(Operation.SEARCH_COUPONS, coupon);
        try{
                   sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Coupon>) response.getResult();
        } else {
            throw response.getException();
        }
        }     catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
 
    }

    public List<Flight> searchFlights(Flight flight) throws Exception {
        Request request = new Request(Operation.SEARCH_FLIGHTS, flight);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

            return (List<Flight>) response.getResult();
        } else {
            throw response.getException();
        }
        }  catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public List<Passenger> searchPassengers(Passenger passenger) throws Exception {
        Request request = new Request(Operation.SEARCH_PASSENGERS, passenger);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Passenger>) response.getResult();
        } else {
            throw response.getException();
        }
        }

          catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }
    }

    public List<Reservation> searchReservations(Reservation reservation) throws Exception {
        Request request = new Request(Operation.SEARCH_RESERVATIONS, reservation);
        try{
                    sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Reservation>) response.getResult();
        } else {
            throw response.getException();
        }
        }   catch (SocketException ex) {
            throw new CommunicationException("Server got disconnected");
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

}
