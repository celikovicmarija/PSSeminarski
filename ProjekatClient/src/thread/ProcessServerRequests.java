/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;



import communication.Communication;
import communication.Request;
import communication.Response;
import coordinator.MainCoordinator;
import java.net.Socket;
import java.util.List;



/**
 *
 * @author Miroslav
 */
public class ProcessServerRequests extends Thread{
Response response;
    boolean kraj = false;
    
  /*  private boolean isLocalPortInUse(int port) {
    try {
        // ServerSocket try to open a LOCAL port
        new ServerSocket(port).close();
        // local port can be opened, it's available
        return false;
    } catch(IOException e) {
        // local port cannot be opened, it's in use
        return true;
    }
}*/
    @Override
    public void run() {
     
   
        while (!kraj) {            
                     
                try {
                    Socket s=Communication.getInstance().getSocket();
                    //System.out.println("Connected");
                    Request request = (Request) Communication.getInstance().getReceiver().receive(); 
                    switch(request.getOperation()){
                        case LOGOUT_AFTER_STOPPING_SERVER:
                            kraj=true;
                            System.out.println("Received the right operation");
                            MainCoordinator.getInstance().getMainContoller().logout();
                            break;
                       /*  case SALJI_PORUKU_SVIMA:
                             Poruka poruka= (Poruka) request.getArgument();
                            MainCordinator.getInstance().getKorisnickaFormaKontroler().prikaziPoruku( poruka.getPoruka());
                            break; 
                        case UPDATE_COMBO_BOX:
                             List<Korisnik> aktivni= (List<Korisnik>) request.getArgument();
                             System.out.println("Recevied for the combo box:");
                             for (Korisnik korisnik : aktivni) {
                                 System.out.println(""+korisnik);
                            }*/
                           // MainCordinator.getInstance().getKorisnickaFormaKontroler().fillCbAktivniKlijenti(aktivni);
//                            break;  
                            
                    }
                } catch (Exception ex) {
                    
 
                }
                
          
            
        }
      
      
  
  }  
    
}
