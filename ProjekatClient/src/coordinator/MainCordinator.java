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
import view.form.FrmCreateFlight;
import view.form.FrmCreateReservation;
import view.form.FrmLogin;
import view.form.FrmSearchFlights;
import view.form.FrmUserMain;

public class MainCordinator {

    private static MainCordinator instance;

    private final MainContoller mainContoller;
    private final Map<String, Object> params;

    private MainCordinator() {
        mainContoller = new MainContoller(new FrmUserMain());
        params = new HashMap<>();
    }

    public static MainCordinator getInstance() {
        if (instance == null) {
            instance = new MainCordinator();
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
