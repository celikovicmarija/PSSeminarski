/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.flight;

import domain.Flight;
import operation.AbstractGenericOperation;

/**
 *
 * @author Marija
 */
public class SaveFlight extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
         repository.edit((Flight) param);
    }
    
}
