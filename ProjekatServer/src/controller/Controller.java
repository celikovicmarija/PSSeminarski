package controller;

import coordinator.ServerCoordinator;
import domain.GenericEntity;
import form.FrmMain;
import java.util.List;
import domain.User;
import form.models.ActiveUsersTableModel;
import java.util.LinkedList;
import operation.AbstractGenericOperation;
import operation.airplane.GetAllAirplanes;
import operation.airplane.SearchAirplanes;
import repository.Repository;
import repository.db.impl.RepositoryDbUser;
import server.StartServerThread;
import thread.ProcessClientsRequests;
import operation.line.GetAllLines;
import operation.coupon.GetAllCoupons;
import operation.coupon.SearchCoupons;
import operation.flight.CreateFlight;
import operation.flight.DeleteFlight;
import operation.flight.GetAllFlights;
import operation.flight.SaveFlight;
import operation.flight.SearchFlights;
import operation.line.SearchLines;
import operation.passenger.CreatePassenger;
import operation.passenger.GetAllPassengers;
import operation.passenger.SearchPassengers;
import operation.reservation.CreateReservation;
import operation.reservation.DeleteReservation;
import operation.reservation.GetAllReservations;
import operation.reservation.SaveReservation;
import operation.reservation.SearchReservations;
import repository.db.impl.RepositoryDBGeneric;


public class Controller {

    private final Repository repositoryUser;
    private List<User> activeUsers;
    private final Repository repositoryGeneric;

    private static Controller controller;
    StartServerThread sst;

    private Controller() {
        activeUsers = new LinkedList<>();
        this.repositoryUser = new RepositoryDbUser();
        this.repositoryGeneric = new RepositoryDBGeneric();

    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public User login(String username, String password) throws Exception {
        List<User> users = repositoryUser.getAll();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               if(activeUsers.contains(user)){      
                   throw new Exception("User already logged in");
               }else{
                user.setStatus("active");
                activeUsers.add(user);
                fillTblUsers(ServerCoordinator.getInstance().getFrmMainController().getFrmMain());

                return user;
               }
 
            }
        }
        throw new Exception("Unknown user!");
    }

        public User logout(User u) throws Exception {
        List<User> users = repositoryUser.getAll();
        for (User user : users) {
            if (user.getUsername().equals(u.getUsername())) {
                user.setStatus("not active");
                activeUsers.remove(user);
                fillTblUsers(ServerCoordinator.getInstance().getFrmMainController().getFrmMain());
                return user;
                
       
            }
        }
        throw new Exception("Unknown user!");
    }
    
    
    
    public List<User> getAllUsers() {
        return repositoryUser.getAll();
    }

    public List<GenericEntity> getAllAirplanes(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new GetAllAirplanes();
        operation.execute(entity);
        return ((GetAllAirplanes) operation).getList();
    }

 

    public List<GenericEntity> getAllLines(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new GetAllLines();
        operation.execute(entity);
        return ((GetAllLines) operation).getList();
    }

    public List<GenericEntity> getAllCoupons(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new GetAllCoupons();
        operation.execute(entity);
        return ((GetAllCoupons) operation).getList();
    }

    public List<GenericEntity> getAllPassengers(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new GetAllPassengers();
        operation.execute(entity);
        return ((GetAllPassengers) operation).getList();
    }

    public List<GenericEntity> getAllFlights(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new GetAllFlights();
        operation.execute(entity);
        return ((GetAllFlights) operation).getList();
    }

    public List<GenericEntity> getAllReservations(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new GetAllReservations();
        operation.execute(entity);
        return ((GetAllReservations) operation).getList();
    }

    public void addFlight(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new CreateFlight();
        operation.execute(entity);
    }

    public void addPassenger(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new CreatePassenger();
        operation.execute(entity);
    }

    public void addReservation(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new CreateReservation();
        operation.execute(entity);
    }

    public void deleteFlight(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new DeleteFlight();
        operation.execute(entity);
    }

    public void deleteReservation(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new DeleteReservation();
        operation.execute(entity);
    }

    public void editFlight(GenericEntity flightEdit) throws Exception {
        AbstractGenericOperation operation = new SaveFlight();
        operation.execute(flightEdit);
    }

    public void editReservation(GenericEntity reservationEdit) throws Exception {
        AbstractGenericOperation operation = new SaveReservation();
        operation.execute(reservationEdit);
    }

    public List<GenericEntity> searchFlights(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new SearchFlights();
        operation.execute(entity);
        return ((SearchFlights) operation).getList();
    }

    public List<GenericEntity> searchReservations(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new SearchReservations();
        operation.execute(entity);
        return ((SearchReservations) operation).getList();
    }

    public List<GenericEntity> searchLines(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new SearchLines();
        operation.execute(entity);
        return ((SearchLines) operation).getList();
    }


    public List<GenericEntity> searchAirplanes(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new SearchAirplanes();
        operation.execute(entity);
        return ((SearchAirplanes) operation).getList();
    }

    public List<GenericEntity> searchPassengers(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new SearchPassengers();
        operation.execute(entity);
        return ((SearchPassengers) operation).getList();
    }

    public List<GenericEntity> searchCoupons(GenericEntity entity) throws Exception {
        AbstractGenericOperation operation = new SearchCoupons();
        operation.execute(entity);
        return ((SearchCoupons) operation).getList();
    }

    public List<User> getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(List<User> activeUsers) {
        this.activeUsers = activeUsers;
    }

    public void startServer(FrmMain frm) {
        sst = new StartServerThread(frm);
        sst.start();
    }

    public void stopServer() {

       for (ProcessClientsRequests obradaKlijenskihZahteva : StartServerThread.clients) {
            for(User kor:Controller.getInstance().getActiveUsers()){
                if(kor.getUsername().equals(obradaKlijenskihZahteva.getUser().getUsername()))
                    activeUsers.remove(obradaKlijenskihZahteva.getUser());
                
          }
            fillTblUsers(ServerCoordinator.getInstance().getFrmMainController().getFrmMain());
      }
     

        sst.stopAllThreads();
    }

    public void fillTblUsers(FrmMain frm) {

        ActiveUsersTableModel model = null;
        try {
            model = new ActiveUsersTableModel(Controller.getInstance().getAllUsers());
        } catch (Exception ex) {

        }
        frm.getTblActiveUsers().setModel(model);
    }

}
