package coordinator;

import java.util.HashMap;
import java.util.Map;
import view.controller.CreateFlightController;
import view.controller.CreatePassengerController;
import view.controller.CreateReservationController;

import view.controller.LoginController;
import view.controller.MainContoller;
import view.controller.SearchFlightsController;
import view.controller.SearchReservationsController;
import view.controller.UpdateFlightController;
import view.controller.UpdateReservationController;
import view.form.FrmAbout;
import view.form.FrmCreateFlight;
import view.form.FrmCreatePassenger;
import view.form.FrmCreateReservation;
import view.form.FrmLogin;
import view.form.FrmSearchFlights;
import view.form.FrmSearchReservations;
import view.form.FrmUpdateFlight;
import view.form.FrmUpdateReservation;
import view.form.FrmUserMain;
import view.form.util.FormMode;

public class MainCoordinator {

    private static MainCoordinator instance;

    private final MainContoller mainContoller;
    private final Map<String, Object> params;
    
    private SearchReservationsController searchReservationsController;
    private SearchFlightsController searchFlightsController;

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
        FrmCreateFlight fcf = new FrmCreateFlight();
        CreateFlightController createFlightController = new CreateFlightController(fcf);
        createFlightController.openForm();
    }

    public void openCreateReservationForm() {
        CreateReservationController reservationController = new CreateReservationController(new FrmCreateReservation());
        reservationController.openForm();
    }

    public void openCreatePassengerForm(FormMode mode) {
        CreatePassengerController passengerController = new CreatePassengerController(new FrmCreatePassenger(),mode);
        passengerController.openForm();
    }

    public void openAboutForm() {
        new FrmAbout(mainContoller.getFrmMain(), true).setVisible(true);

    }

    public void openSearchFlightsForm(FormMode mode) {
         searchFlightsController = new SearchFlightsController(new FrmSearchFlights(),mode);
        searchFlightsController.openForm();
    }

    public void openSearchResevationsForm(FormMode mode) {
         searchReservationsController = new SearchReservationsController(new FrmSearchReservations(),mode);
        searchReservationsController.openForm();
    }

    public void openUpdateFlightForm(FormMode mode) {
        UpdateFlightController updateFlightController = new UpdateFlightController(new FrmUpdateFlight(mainContoller.getFrmMain(), true),mode);
        updateFlightController.openForm();
    }

    public void openUpdateResevationForm(FormMode mode) {
        UpdateReservationController updateReservationController = new UpdateReservationController(new FrmUpdateReservation(mainContoller.getFrmMain(),true),mode);
        updateReservationController.openForm();
    }

    public MainContoller getMainContoller() {
        return mainContoller;
    }

    public void addParam(String name, Object key) {
        params.put(name, key);
    }
    public void removeParam(String name, Object key) {
        params.remove(name, key);
        
    }
    public Object getParam(String name) {
        return params.get(name);
    }

    public SearchReservationsController getSearchReservationsController() {
        return searchReservationsController;
    }

    public void setSearchReservationsController(SearchReservationsController searchReservationsController) {
        this.searchReservationsController = searchReservationsController;
    }

    public SearchFlightsController getSearchFlightsController() {
        return searchFlightsController;
    }

    public void setSearchFlightsController(SearchFlightsController searchFlightsController) {
        this.searchFlightsController = searchFlightsController;
    }

}
