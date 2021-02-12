/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinator;

import java.util.HashMap;
import java.util.Map;
import view.controller.CreateFlightController;
import view.controller.CreateReservationController;

import view.controller.LoginController;
import view.controller.MainContoller;
import view.controller.SearchFlightsController;
import view.controller.SearchReservationsController;
import view.controller.UpdateFlightController;
import view.controller.UpdateReservationController;
import view.form.FrmCreateFlight;
import view.form.FrmCreateReservation;
import view.form.FrmLogin;
import view.form.FrmSearchFlights;
import view.form.FrmSearchReservations;
import view.form.FrmUpdateFlight;
import view.form.FrmUpdateReservation;
import view.form.FrmUserMain;

public class MainCoordinator {

    private static MainCoordinator instance;

    private final MainContoller mainContoller;
    private final Map<String, Object> params;

    private MainCoordinator() {
        mainContoller = new MainContoller(new FrmUserMain());
        params = new HashMap<>();
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }
    public void openLoginForm() {
        LoginController loginContoller = new LoginController(new FrmLogin());
        loginContoller.openForm();
    }

    public void openMainForm() {
        mainContoller.openForm();
    }
    public void openCreateFlightForm() {
        FrmCreateFlight fcf= new FrmCreateFlight();
        CreateFlightController createFlightController = new CreateFlightController(fcf);
        createFlightController.openForm();
    }
    
    public void openCreateReservationForm() {
         CreateReservationController reservationController= new CreateReservationController(new FrmCreateReservation());
         reservationController.openForm();
    }
    public void openSearchFlightsForm(){
        SearchFlightsController searchFlightsController= new SearchFlightsController(new FrmSearchFlights());
        searchFlightsController.openForm();
    }
    public void openSearchResevationsForm(){
        SearchReservationsController searchReservationsController= new SearchReservationsController(new FrmSearchReservations());
        searchReservationsController.openForm();
    }
   public void openUpdateFlightForm(){
        UpdateFlightController updateFlightController= new UpdateFlightController(new FrmUpdateFlight());
        updateFlightController.openForm();
    }
    public void openUpdateResevationForm(){
 UpdateReservationController updateReservationController= new UpdateReservationController(new FrmUpdateReservation());
        updateReservationController.openForm();
    }

    public MainContoller getMainContoller() {
        return mainContoller;
    }

    public void addParam(String name, Object key) {
        params.put(name, key);
    }

    public Object getParam(String name) {
        return params.get(name);
    }



  
   
}
