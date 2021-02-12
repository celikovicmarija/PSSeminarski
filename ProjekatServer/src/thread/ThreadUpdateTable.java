/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.Controller;
import form.FrmMain;
import static java.lang.Thread.sleep;

/**
 *
 * @author Marija
 */
public class ThreadUpdateTable extends Thread{
    FrmMain frm;
    int korisniciUlogovani;

    public ThreadUpdateTable(FrmMain frm) {
        try {
            this.frm = frm;
            korisniciUlogovani=Controller.getInstance().getActiveUsers().size();
        } catch (Exception ex) {
            
        }
    }

    public FrmMain getFrm() {
        return frm;
    }

    public void setFrm(FrmMain frm) {
        this.frm = frm;
    }
    
    @Override
    public void run() {
        while(true){
          
            try {
                int korisniciUlogovaniNovi=Controller.getInstance().getActiveUsers().size();
                if( korisniciUlogovaniNovi!=korisniciUlogovani){
                    korisniciUlogovani=korisniciUlogovaniNovi;

               }
           
            } catch (Exception ex) {
                }
              
            }
    }
}
