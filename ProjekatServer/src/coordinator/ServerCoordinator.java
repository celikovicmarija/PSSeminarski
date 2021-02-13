package coordinator;

import form.FrmAbout;
import form.FrmMain;
import form.FrmSettings;
import form.controller.FrmMainController;
import form.controller.FrmSettingsController;

/**
 *
 * @author Marija
 */
public class ServerCoordinator {
    
    private final FrmMainController frmMainController;
    private final FrmSettingsController frmSettingsController;
    private static ServerCoordinator instance;
    
    public static ServerCoordinator getInstance() {
        if (instance == null) {
            instance = new ServerCoordinator();
        }
        return instance;
    }
    
    private ServerCoordinator() {
        frmMainController = new FrmMainController(new FrmMain());
        frmSettingsController = new FrmSettingsController(new FrmSettings(frmMainController.getFrmMain(), true));        
        
    }
    
    public void openSettingsForm() {
        frmSettingsController.openForm();
    }
    
    public void openAboutForm() {
        new FrmAbout(frmMainController.getFrmMain(), true).setVisible(true);
    }
    
    public void openMainForm() {
        
        frmMainController.openForm();
    }
    
    public FrmMainController getFrmMainController() {
        return frmMainController;
    }
    
    public FrmSettingsController getFrmSettingsController() {
        return frmSettingsController;
    }
    
}
